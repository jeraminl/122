package sample;

import java.util.ArrayList;

public class ShoppingList extends CheckList {
    int priority;


    public ShoppingList(String n){
        super(n);
        items.add(new Item("Buy coats"));
        items.add(new Item("Buy toys for the kids"));
    }
}
