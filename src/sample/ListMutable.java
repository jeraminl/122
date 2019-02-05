package sample;

public interface ListMutable {
    public Boolean addItem(Item i);
    public Boolean editItem(String i, String n);
    public Boolean deleteItem(String s);
    public void changeName(String s);

}
