import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ShippingMain {
    /**
     * Self Explanation
     * The createProduct method will take the scanner as an input and read each line using the hasNextLine method.
     * It will then read the first string of each line and determine what attribute of the product class it should be set to.
     * After doing this for all lines, all attributes will be read and a product will bre created by passing in all
     * of the variables to create a new object. 
     * 
     */
    public static Product createProduct(Scanner fileScanner) {
        String name = "";
        int sku = -1;
        double price = -1;
        double weight = -1;
        int destination = -1;
        int quantity = -1;

        while (fileScanner.hasNextLine()) {
            String data = fileScanner.nextLine();
            String firstAtt = data.substring(0, data.indexOf(":"));
            switch (firstAtt) {
                case "NAME": name = data.substring(data.indexOf(" ") + 1); break;
                case "SKU": sku = Integer.parseInt(data.substring(data.indexOf(" ") + 1)); break;
                case "PRICE": price = Double.parseDouble(data.substring(data.indexOf(" ") + 1));break;
                case "WEIGHT": weight = Double.parseDouble(data.substring(data.indexOf(" ") + 1));break;
                case "DESTINATION": destination = Integer.parseInt(data.substring(data.indexOf(" ") + 1)); break;
                case "QUANTITY": quantity = Integer.parseInt(data.substring(data.indexOf(" ") + 1)); break;
                default: System.out.println("Not an attribute of the Product"); break;
            }
        }

        return new Product(name,sku, price, weight, destination, quantity);
    }

    public static ShippingManifest createManifest(ArrayList<File> fileList) {
        FileHelper fileHelper = new FileHelper();
        ShippingManifest shipManifest = new ShippingManifest();

        for(File file: fileList) {
            Scanner fileScanner = fileHelper.getFileScanner(file);

            Product newProd = createProduct(fileScanner);
            shipManifest.addProduct(newProd);

            fileScanner.close();
        }

        return shipManifest;
    }

    public static void printSplash() {
        System.out.println("Please type:");
        System.out.println("\"X\" to exit program.");
        System.out.println("\"D\" to distribute products to addresses.");
        System.out.println("\"F-ZIPCODE\" to forwards products to destinations.");
        System.out.println("\"P\" to print current manifest.");
    }
    /**
     * Self Explanation
     * The go method will display options to the user and take in an input that the user enters. Using conditionals, 
     * the program determines what the user wants to do: P for printing, F for forwarding, D for distributing, and X to exit.
     * After getting the option, the program will call a corresponding method and return to the top of the loop to check
     * for the user input again. 
     */
    public static void go(Scanner scnr, ShippingManifest shipManifest) {
        printSplash();

        String input = scnr.nextLine();

        while (!input.toLowerCase().startsWith("x")) {
            if (input.toLowerCase().startsWith("d")) {
                shipManifest.distributeProducts();
                input = scnr.nextLine();
            }
            else if (input.toLowerCase().startsWith("f")) {
                shipManifest.forwardProducts(Integer.parseInt(input.substring(input.indexOf("-") + 1)));
                input = scnr.nextLine();
            }
            else if (input.toLowerCase().startsWith("p")) {
                shipManifest.printManifest();
                input = scnr.nextLine();
            }
            else {
                System.out.println("Unrecognized Command");
                input = scnr.nextLine();
            }
        }

    }

    public static void main(String[] args) {
        String directoryPath = "ShipmentFolder";
        FileHelper fileHelper = new FileHelper();
        ArrayList<File> fileList = fileHelper.getFileDirectory(directoryPath);

        ShippingManifest shipManifest = createManifest(fileList);
        System.out.println("Manifest created from " + directoryPath + "!");

        shipManifest.printManifest();

        Scanner scnr = new Scanner(System.in);
        go(scnr, shipManifest);
    }
}