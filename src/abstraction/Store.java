package abstraction;

// manage list of product for sale
// manage an order, list of OrderItem objects
// method to add an item to the order, and print the ordered items

import java.util.ArrayList;

// create a ProductForSale class: type, price, description
    // get a Sales Price, a concrete method, which take quantity and return the quantity times the price
    // print a PircedLineItem, a concrete method,

record OrderItem(int qty, ProductForSale product){}


public class Store {
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();
    public static void main(String[] args) {
        storeProducts.add(new ArtObject("Oil Painting", 1350, "Impressionisitc"));
        storeProducts.add(new ArtObject("Sculpture", 2000, "Bronze work by JKF"));

        listProducts();
    }

    public static void listProducts(){
        for(var item: storeProducts){
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemOrder(ArrayList<OrderItem> order, int orderIndex, int qty){
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){
        double salesTotal = 0;
        for( var item: order){
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
    }
}
