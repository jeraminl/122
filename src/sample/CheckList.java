package sample;

import java.util.ArrayList;
import java.util.Timer;

public abstract class CheckList{
    private String id;
    private String name;
    private ArrayList<Item> items;

    public CheckList(String n){
        name = n;
        items = new ArrayList<Item>();
    }

    public void changeName(String s){
        name = s;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    abstract void addItem(String n);
    abstract void addItem(String n, int year, int month, int date, int hrs, int min, int p);
        /*Item item = null;
        ItemCreator iCreator = new ItemCreator();

        items.add(i);
        return true;

        */


    public Boolean editItem(String i, String n){
        return true;
    }
    public Boolean deleteItem(String s){
        for(Item i : items){
            if(s == i.getContent()){
                items.remove(s);
            }
        }

        return true;
    }
    public void showItems(){
        System.out.println("================================Items================================");

        System.out.println(name + ": ");
        int i = 1;
        for (Item item : items){
            System.out.print(i + ": ");
            item.printContent();
        }

        System.out.println("================================================================");

    }

    public void completeItem(int i){
        items.get(i).complete();

        CompletedCleaner cleaner = CompletedCleaner.getInstance();
        cleaner.clean(items,items.get(i));
    }


}
