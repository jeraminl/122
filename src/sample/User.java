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

    public String getName(){
        return name;
    }

    public void editName(String n){
        name = n;
    }

    public void addCheckList(String type, String n){
        System.out.println(type);
        if (type.toLowerCase().equals("shopping")) checkLists.putIfAbsent(n, new ShoppingList(n));
        else if (type.toLowerCase().equals("todo")) checkLists.putIfAbsent(n, new TodoList(n));
        else if (type.equals("goal")) checkLists.putIfAbsent(n, new GoalList(n));
        else System.out.println("no such type");
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
