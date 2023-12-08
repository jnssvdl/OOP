package inventorymanager;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static InventoryManager inventoryManager = new InventoryManager();

    public static void main(String[] args) {
        simulation();
    }

    static void simulation() {
        while (true) {
            printOptions();
            System.out.print("Choice: ");
            String choice = in.nextLine();
            switch (choice) {
                case "1":
                    addSingleProduct();
                    break;
                case "2":
                    addBoxProduct();
                    break;
                default:
                    break;
            }
            if (choice.equals("3")) {
                inventoryReport();
                break;
            }
            System.out.println();
        }
    }
    
    static void printOptions() {
        System.out.println("Options: ");
        System.out.println("\t[1] Add Single Product");
        System.out.println("\t[2] Add Box Product");
        System.out.println("\t[3] Exit");
    }
    
    static void addSingleProduct() {
        System.out.print("Brand: ");
        String brand = in.nextLine();
        System.out.print("Quantity: ");
        int quantity = in.nextInt();
        in.nextLine();
        inventoryManager.add(new SingleProduct(brand), quantity);;
    }
    
    static void addBoxProduct() {
        System.out.print("Brand: ");
        String brand = in.nextLine();
        System.out.print("Items in Box: ");
        int items = in.nextInt();
        in.nextLine();
        System.out.print("Quantity: ");
        int quantity = in.nextInt();
        in.nextLine();
        inventoryManager.add(new BoxedProduct(brand, items), quantity);;
    }

    static void inventoryReport() {
        System.out.println("-Inventory Report-");
        for (String brand : inventoryManager.getBrands()) {
            int singles = inventoryManager.getSingles(brand).length;
            BoxedProduct[] boxes = inventoryManager.getBoxes(brand);
            System.out.println();
            System.out.println(brand);
            System.out.println("\tSingles: " + singles);
            System.out.println("\tBoxes: " + boxes.length);
            System.out.println("\tTotal Pieces: " + (singles + getTotalBoxes(boxes)));
        }
    }

    static int getTotalBoxes(BoxedProduct[] boxes) {
        int totalBoxes = 0;
        for (BoxedProduct p : boxes) {
            totalBoxes += p.getQuantity();
        }
        return totalBoxes;
    }
}
