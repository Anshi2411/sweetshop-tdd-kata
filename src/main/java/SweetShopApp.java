// Running the Sweet Shop console application
import java.util.Scanner;

public class SweetShopApp {
    public static void main(String[] args) {
        SweetShop shop = new SweetShop(); // object to manage sweet operations
        Scanner sc = new Scanner(System.in); // scanner for user input

        // Menu runs continuously until user exits
        while (true) {
            System.out.println("\n1. Add  2. Purchase  3. View  4. Search  5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline from input

            switch (choice) {
                // Option 1: Add new sweet
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Cat: ");
                    String cat = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Qty: ");
                    int qty = sc.nextInt();
                    shop.addSweet(new Sweet(id, name, cat, price, qty));
                    break;

                // Option 2: Purchase sweet (reduces quantity if available)
                case 2:
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    System.out.print("Qty: ");
                    qty = sc.nextInt();
                    try {
                        shop.purchaseSweet(id, qty);
                        System.out.println("Bought!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                // Option 3: View all sweets
                case 3:
                    shop.viewSweets().forEach(System.out::println);
                    break;

                // Option 4: Search sweets by name/category/price range
                case 4:
                    System.out.print("Name or blank: ");
                    String n = sc.nextLine();
                    System.out.print("Cat or blank: ");
                    String c = sc.nextLine();
                    System.out.print("Min price: ");
                    String mn = sc.nextLine();
                    System.out.print("Max price: ");
                    String mx = sc.nextLine();

                    // Convert input to null or Double
                    Double min = mn.isEmpty() ? null : Double.parseDouble(mn);
                    Double max = mx.isEmpty() ? null : Double.parseDouble(mx);

                    // Perform search and print results
                    shop.searchSweets(n.isEmpty() ? null : n, c.isEmpty() ? null : c, min, max)
                            .forEach(System.out::println);
                    break;

                // Option 5: Exit program
                case 5:
                    sc.close();
                    return;
            }
        }
    }
}
