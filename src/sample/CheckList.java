package sample;

import java.util.ArrayList;

public class CheckList implements ListPeekable, ListMutable{
    String id;
    String name;
    ArrayList<Item> items;

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
            if(s == i.content){
                items.remove(s);
            }
        }

        return true;
    }

    public void showItems(){
        for (Item item : items){
            System.out.println(item.getContent());
        }
    }


}
