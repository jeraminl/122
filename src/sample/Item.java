package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

public class Item {
    private String id;
    private String content;
    private Boolean completed;
    private Timer delTimer;


    public Item(String i){
        content = i;

        completed = false;
    }

    public String getId(){
        return id;
    }

    public void editContent(String s){
        content = s;
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
