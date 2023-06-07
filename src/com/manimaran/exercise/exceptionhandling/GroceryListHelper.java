package com.manimaran.exercise.exceptionhandling;

import java.util.*;
import java.io.*;

public class GroceryListHelper {
    public static void main(String[] args) {
        Set<String> groceryList = new HashSet<>();
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "\\" + "groceryList.txt";  // Update this path as per your file location

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String item = line.trim().toLowerCase();
                if (!groceryList.add(item)) {
                    System.out.println("Duplicate item found: " + line.trim());
                }
            }
            // Print final list
            System.out.println("Final grocery list: " + groceryList);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
