package com.theironyard.novauc;

public class Armor extends InventoryItem {

    public Armor(String name, String category, int quantity){
        setName(name);
        setCategory(category);
        setQuantity(quantity);
        /**
         *  I decided to use setters  as a way to make this project more intersting.
         *  I could of used super(x, i, n) or this.x, this.i, this.n
         */
    }
}
