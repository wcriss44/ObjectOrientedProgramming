package com.theironyard.novauc;


public class InventoryItem {

    /********************************
     * Variables
     * Some additional variables
     * were added as a means of expansion
     *******************************/

    private String name;
    private String category;
    private int quantity;
    private boolean enchanted;
    private double cost;

    /********************************
     * Constructors
     *******************************/
    public InventoryItem(){
        this.name = "Inventory Item";
        this.category = "Inventory";
        this.quantity = 0;
        this.enchanted = false;
        this.cost = 0;
    }

    /********************************
     * Getters
     *******************************/
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }
    public int getQuantity(){
        return quantity;
    }
    /********************************
     * Setters
     *******************************/

    public void setName(String name){
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /********************************
     * Other methods
     *******************************/

    public void findItem(int numItems) throws Exception{
        String foundItem = "";
        String category = "";
        int foundItemCheck;
        while (numItems > 0){
            foundItemCheck = Game.randomRange(1, 6);
            switch(foundItemCheck){
                case 1:
                    System.out.println("You found a piece of Armor!");
                    foundItem = itemGenerator("armor");
                    System.out.printf("You found a %s!", foundItem);
                    category = "Armor";
                    break;
                case 2:
                    System.out.println("You found some Food!");
                    foundItem = itemGenerator("food");
                    System.out.printf("You found a %s!", itemGenerator("food"));
                    category = "Food";
                    break;
                case 3:
                    System.out.println("You found some Drink!");
                    foundItem = itemGenerator("drink");
                    System.out.printf("You found a %s!", itemGenerator("drink"));
                    category = "Drink";
                    break;
                case 4:
                    System.out.println("You found a weapon!");
                    foundItem = itemGenerator("weapon");
                    System.out.printf("You found a %s!", itemGenerator("weapon"));
                    category = "Weapon";
                    break;
                case 5:
                    System.out.println("You found a book!");
                    foundItem = itemGenerator("book");
                    System.out.printf("You found a %s!", itemGenerator("book"));
                    category = "Book";
                    break;
                case 6:
                    System.out.println("You found something that looks useless. . .");
                    break;
            }
            if(foundItemCheck < 6){
                loop: while(true){
                    System.out.println("\nDo you wish to keep this item? [Y][N]");
                    switch(Game.scanner.nextLine().toUpperCase()){
                        case "Y":
                            Game.createItem(foundItem, category, 1);
                            break loop;
                        case "N":
                            System.out.printf("Discarding %s . . .", foundItem);
                            break loop;
                        default:
                            System.out.println("Please enter a valid choice!");
                    }
                }
            }
            numItems--;
        }
    }
    public String itemGenerator(String type){
        String prefix = "";
        String suffix = "";
        int prefixSel = Game.randomRange(1, 5);
        int suffixSel = Game.randomRange(1, 5);

        switch(prefixSel){
            case 1:
                prefix = "Flaming";
                break;
            case 2:
                prefix = "Chilled";
                break;
            case 3:
                prefix = "Venomous";
                break;
            case 4:
                prefix = "Quick";
                break;
            case 5:
                prefix = "Deadly";
                break;
        }
        switch (suffixSel){
            case 1:
                suffix = "of the Whale";
                break;
            case 2:
                suffix = "of the Quick";
                break;
            case 3:
                suffix = "of Grace";
                break;
            case 4:
                suffix = "of the Heavens";
                break;
            case 5:
                suffix = "of Fire";
                break;
        }
        return prefix + " " + type + " " + suffix;
    }
}
