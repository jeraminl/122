package sample;

import java.util.ArrayList;

public class ShoppingList extends CheckList {
    int priority;


    public ShoppingList(String n){
        super(n);
        getItems().add(new Item("Buy coats"));
        getItems().add(new Item("Buy toys for the kids"));

        completeItem(0);
    }
}
