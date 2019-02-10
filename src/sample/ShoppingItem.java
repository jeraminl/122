package sample;

public class ShoppingItem extends Item implements ItemMutable, ItemPeekable {
    int priority;
    public ShoppingItem(String i) {
        super(i);
    }

    public void setPriority(int n){
        priority = n;
    }

    public int getPriority(){
        return priority;
    }
}
