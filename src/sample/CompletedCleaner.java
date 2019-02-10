package sample;

import java.util.ArrayList;

public class CompletedCleaner {
    private static CompletedCleaner cleaner;

    private CompletedCleaner(){
    }

    public static CompletedCleaner getInstance(){
        if (cleaner == null){
                cleaner = new CompletedCleaner();
        }
        return cleaner;
    }

    public void clean(ArrayList<Item> a, Item i){
        DeleteTimerThread dt = new DeleteTimerThread(a,i);
        dt.start();
    }
}
