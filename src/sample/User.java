package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    String id;
    String name;
    HashMap<String, CheckList> checkLists;

    public User(String n){
        checkLists = new HashMap<String, CheckList>();
        name = n;

        //test default values
        addCheckList("shopping", "christmas");
        addCheckList("todo", "INF122");

    }

    public void getName(){

    }

    public void editName(String n){

    }

    public void addCheckList(String type, String n){
        if (type == "shopping"){
            checkLists.put(n, new ShoppingList(n));
        }
        else if (type == "todo"){
            checkLists.put(n, new TodoList(n));
        }
    }

    public void showCheckList(String n){


    }

    public CheckList getCheckList(String n){
        return checkLists.get(n);
    }

    public HashMap<String, CheckList> getCheckLists(){
        return checkLists;
    }
}
