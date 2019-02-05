package sample;

import java.util.Date;

public class Item {
    String id;
    String content;
    Boolean completed;
    Date completeTime;
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
        if (isCompleted()) return "- " + content + "   " + "Done";
        else return "- " + content + "   " + "";
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
