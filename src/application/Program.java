package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products:");
        int n = sc.nextInt();

        for(int i = 1 ; i <= n; i++){
            System.out.println("Product #" + 1 + " data: ");
            System.out.print("Common, used or imported?(c/u/i)");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if( ch == 'c'){
                Product product = new Product(name,price);
                products.add(product);
            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                Product product = new UsedProduct(name,price,manufactureDate);
                products.add(product);
            } else if (ch == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product product = new ImportedProduct(name,price,customsFee);
                products.add(product);
            }
        }

        System.out.println("PRICE TAGS: ");
        for(int i = 0 ; i < n; i++){
            System.out.println(products.get(i));
        }
    }
}
