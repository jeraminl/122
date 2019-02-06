package sample;

import java.util.ArrayList;
import java.util.Timer;

public class CheckList implements ListPeekable, ListMutable{
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

    public Boolean addItem(Item i){
        items.add(i);
        return true;
    }

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
        System.out.println(name + ": ");
        for (Item item : items){
            System.out.println(item.getContent());
        }
    }

    public void completeItem(int i){
        items.get(i).complete();
        DeleteTimerThread dt = new DeleteTimerThread(items,items.get(i));
        dt.start();
    }


}
