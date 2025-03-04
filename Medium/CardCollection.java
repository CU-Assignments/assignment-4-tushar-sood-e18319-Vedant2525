import java.util.*;

public class CardCollection {
    public static void main(String[] args) {
        HashMap<String, List<String>> cards = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Card\n2. Search Card\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter symbol (heart, spade, diamond, clubs): ");
                    String sym = sc.nextLine().toLowerCase();
                    
                    if (!Arrays.asList("heart", "spade", "diamond", "clubs").contains(sym)) {
                        System.out.println("Invalid symbol!");
                        break;
                    }
                    
                    System.out.print("Enter card name (A, 2-10, J, Q, K): ");
                    String val = sc.nextLine().toUpperCase();
                    
                    if (!Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K").contains(val)) {
                        System.out.println("Invalid card name!");
                        break;
                    }
                    
                    addCard(cards, sym, val);
                    System.out.println("Card added successfully!");
                    break;
                
                case 2:
                    System.out.print("Enter symbol to search: ");
                    String searchSym = sc.nextLine().toLowerCase();
                    
                    List<String> found = cards.getOrDefault(searchSym, new ArrayList<>());
                    
                    if (found.isEmpty()) {
                        System.out.println("No cards found for " + searchSym);
                    } else {
                        System.out.println("Cards in " + searchSym + ": " + found);
                    }
                    break;
                
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void addCard(HashMap<String, List<String>> map, String sym, String val) {
        map.putIfAbsent(sym, new ArrayList<>());
        map.get(sym).add(val);
    }
}
