package sample;

import java.util.ArrayList;
import java.util.Timer;

public class DeleteTimerThread extends Thread {
    ArrayList<Item> items;
    Item item;
    DeleteTask dt;
    Timer t = new Timer();
    public DeleteTimerThread(ArrayList<Item> a, Item i){
        items = a;
        item = i;
        dt = new DeleteTask(items, item);
    }

    public void run(){
        System.out.println(item.getContent() + "is done, commencing delete countdown");
        //t.schedule(dt, 3600000*24);
        t.schedule(dt, 60000);

    }

}
