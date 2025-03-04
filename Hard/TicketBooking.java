import java.util.Scanner;
import java.util.concurrent.locks.*;

class Ticket {
    private int seats = 10;
    private final Lock lock = new ReentrantLock();

    public int book(String name, int age) {
        lock.lock();
        try {
            if (seats > 0) {
                System.out.println(name + " (Age: " + age + ") booked seat " + seats);
                return seats--;
            } else {
                System.out.println(name + " (Age: " + age + ") failed to book. No seats left.");
                return -1;
            }
        } finally {
            lock.unlock();
        }
    }
}

class User extends Thread {
    private Ticket ticket;
    private String name;
    private int age;

    public User(Ticket ticket, String name, int age, int priority) {
        this.ticket = ticket;
        this.name = name;
        this.age = age;
        setPriority(priority);
    }

    public void run() {
        int seat = ticket.book(name, age);
        if (seat != -1) {
            System.out.println(name + " got seat number " + seat);
        }
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ticket ticket = new Ticket();
        
        System.out.print("Enter number of users: ");
        int numUsers = sc.nextInt();
        sc.nextLine();

        Thread[] users = new Thread[numUsers];
        
        for (int i = 0; i < numUsers; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();
            
            int priority = (i < 2) ? Thread.MAX_PRIORITY : Thread.NORM_PRIORITY;
            users[i] = new User(ticket, name, age, priority);
        }

        for (Thread user : users) {
            user.start();
        }

        sc.close();
    }
}
