import java.util.Scanner;

public class SweetShopApp {
    public static void main(String[] args) {
        SweetShop shop = new SweetShop();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSweet Shop Menu:");
            System.out.println("1. Add Sweet");
            System.out.println("2. Purchase Sweet");
            System.out.println("3. View Sweets");
            System.out.println("4. Search Sweets");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    shop.addSweet(new Sweet(id, name, category, price, qty));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int pid = scanner.nextInt();
                    System.out.print("Quantity: ");
                    int pq = scanner.nextInt();
                    try {
                        shop.purchaseSweet(pid, pq);
                        System.out.println("Purchase successful!");
                    } catch (OutOfStockException | IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    for (Sweet s : shop.viewSweets()) {
                        System.out.println(s);
                    }
                    break;

                case 4:
                    System.out.print("Name (or leave blank): ");
                    String sname = scanner.nextLine();
                    if (sname.isEmpty()) sname = null;

                    System.out.print("Category (or leave blank): ");
                    String scat = scanner.nextLine();
                    if (scat.isEmpty()) scat = null;

                    System.out.print("Min price (or leave blank): ");
                    String min = scanner.nextLine();
                    Double minPrice = min.isEmpty() ? null : Double.parseDouble(min);

                    System.out.print("Max price (or leave blank): ");
                    String max = scanner.nextLine();
                    Double maxPrice = max.isEmpty() ? null : Double.parseDouble(max);

                    for (Sweet s : shop.searchSweets(sname, scat, minPrice, maxPrice)) {
                        System.out.println(s);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
