package sample;

public class ShoppingItemCreator implements ItemCreator {


    @Override
    public Item create(String n) {
        return new ShoppingItem(n);
    }

    @Override
    public Item create(String n, int year, int month, int date, int hrs, int min, int p) {

        return new ShoppingItem(n);
    }
}
