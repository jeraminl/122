package sample;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DeleteTask extends TimerTask {
    ArrayList<Item> items;
    Item item;
    public DeleteTask(ArrayList<Item> a, Item i){
        super();
        items = a;
        item = i;
    }

    public void run(){
        System.out.println("deleting : " + item.getContent());
        items.remove(item);

    }
}
