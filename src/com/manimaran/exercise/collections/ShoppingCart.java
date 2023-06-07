package com.manimaran.exercise.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
    private Map<String, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        cart.put(item, cart.getOrDefault(item, 0) + quantity);
        System.out.printf("Successfully added %d %s to the cart.\n", quantity, item);
    }

    public void removeItem(String item) {
        if (cart.containsKey(item)) {
            cart.remove(item);
            System.out.printf("Successfully removed %s from the cart.\n", item);
        } else {
            System.out.println("The item is not in the cart.");
        }
    }

    public void viewCart() {
        System.out.println("Here is what's in your cart right now:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }

    public void checkout() {
        int totalQuantity = cart.values().stream().mapToInt(Integer::intValue).sum();
        System.out.printf("You've chosen to checkout. Here's the total quantity of items in your cart: %d\n", totalQuantity);
        cart.clear();
        System.out.println("Your cart is now empty. Thank you for using the Shopping Cart Simulator!");
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        String operation;

        System.out.println("Welcome to the Shopping Cart Simulator! What would you like to do? (Options: Add, Remove, View, Checkout)");

        while (true) {
            operation = scanner.nextLine();
            switch (operation.toLowerCase()) {
                case "add":
                    System.out.println("You've chosen to add an item. Please enter the item name and the quantity, separated by a space.");
                    String[] inputs = scanner.nextLine().split(" ");
                    String addItem = inputs[0];
                    int quantity = Integer.parseInt(inputs[1]);
                    shoppingCart.addItem(addItem, quantity);
                    break;
                case "remove":
                    System.out.println("You've chosen to remove an item. Please enter the item name.");
                    String removeItem = scanner.nextLine();
                    shoppingCart.removeItem(removeItem);
                    break;
                case "view":
                    shoppingCart.viewCart();
                    break;
                case "checkout":
                    shoppingCart.checkout();
                    return;
                default:
                    System.out.println("Invalid operation. Please enter a valid operation: Add, Remove, View, Checkout.");
            }
            System.out.println("What would you like to do next?");
        }
    }
}
