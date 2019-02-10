package sample;

import java.util.ArrayList;

public class ShoppingList extends CheckList {
    int priority;


    public ShoppingList(String n){
        super(n);
        //getItems().add(new Item("Buy coats"));
        //getItems().add(new Item("Buy toys for the kids"));

        //completeItem(0);
    }

    @Override
    void addItem(String n) {
        ShoppingItem toAdd = null;
        ItemCreator iCreator = new ShoppingItemCreator();
        toAdd = (ShoppingItem)iCreator.create(n);

        getItems().add(toAdd);
    }

    @Override
    void addItem(String n, int year, int month, int date, int hrs, int min, int p) {
        ShoppingItem toAdd = null;
        ItemCreator iCreator = new ShoppingItemCreator();
        toAdd = (ShoppingItem)iCreator.create(n);

        getItems().add(toAdd);

    }
}
