package com.theironyard.novauc;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<InventoryItem> inventory = new ArrayList<>();
    public static InventoryItem inventoryitem = new InventoryItem();
    public static Menu menu = new Menu();

    public static void main(String[] args) throws Exception {
        menu.mainMenu();

    }

    /***************************
     * Static methods below are
     * per assignment instructions
     * ....ish.
     */

    public static void createItem(String name,  String category, int quantity ) throws Exception{
        switch(category.toUpperCase()) {
            case "ARMOR":
                inventory.add(new Armor(name, category, quantity));
                break;
            case "DRINK":
                inventory.add(new Drink(name, category, quantity));
                break;
            case "WEAPON":
                inventory.add(new Weapon(name, category, quantity));
                break;
            case "BOOK":
                inventory.add(new Book(name, category, quantity));
                break;
            case "FOOD":
                inventory.add(new Food(name, category, quantity));
                break;
            default:
                throw new Exception("Attempted to add wrong category");
        }
    }
    public static void printInventoryitems(){
        int i = 0;
        //System.out.println("Item Name:\t\t\t\t\t\tItem Category:\t\t\t\t\tQuantity:");
        for (InventoryItem currentInventory: inventory){
            i++;
            System.out.printf("\t** item %s **", i);
            System.out.printf("\nItem name: %s", currentInventory.getName());
            System.out.printf("\nItem category: %s", currentInventory.getCategory());
            System.out.printf("\nItem quantity: %s\n\n", currentInventory.getQuantity());
            //System.out.printf("%s)  %s\t\t\t\t\t%s\t\t\t%s\n", i, currentInventory.getName(), currentInventory.getCategory(), currentInventory.getQuantity());
        }
    }
    public static int randomRange(int min, int max){
        int range = (max - min) + 1;
        return(int)(Math.random()*range) + min;
    }
}

