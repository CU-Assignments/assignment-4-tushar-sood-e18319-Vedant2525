import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public double getSalary() { 
        return salary; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    public void setSalary(double salary) { 
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Exit");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Salary: ");
                    employees.add(new Employee(sc.nextInt(), sc.next(), sc.nextDouble()));
                    break;
                case 2: 
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();
                    for (Employee emp : employees) {
                        if (emp.getId() == updateId) {
                            System.out.print("Enter New Name & Salary: ");
                            emp.setName(sc.next());
                            emp.setSalary(sc.nextDouble());
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Employee ID to Remove: ");
                    int removeId = sc.nextInt();
                    employees.removeIf(emp -> emp.getId() == removeId);
                    break;
                case 4:
                    System.out.print("Enter Employee ID to Search: ");
                    int searchId = sc.nextInt();
                    for (Employee emp : employees) {
                        if (emp.getId() == searchId) {
                            System.out.println(emp);
                            break;
                        }
                    }
                    break;
                case 5:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
