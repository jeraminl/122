package sample;

import java.util.Date;
import java.util.Timer;

public class Item {
    private String id;
    private String content;
    private Boolean completed;
    private Date completeTime;
    private Timer delTimer;

    public Item(String i){
        content = i;

        completed = false;
    }
    public String getID(){
        return id;
    }

    public Boolean editContent(String s){
        content = s;
        return true;
    }

    public String getContent(){
        return content;
    }

    public void printContent(){
        if (isCompleted())  System.out.println("Done - " + getContent());
        else System.out.println( "    - " + getContent());
    }

    public Boolean isCompleted(){
        return completed;
    }

    public Boolean isDeleted(){
        return true;
    }

    public void complete(){
        completed = true;
    }
}
