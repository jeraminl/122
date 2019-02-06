package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String id;
    private String name;
    private HashMap<String, CheckList> checkLists;

    public User(String n){
        checkLists = new HashMap<String, CheckList>();
        name = n;

        //test default values
        addCheckList("shopping", "christmas");
        addCheckList("todo", "INF122");
        addCheckList("team", "Project 1");

    }

    public String getName(){
        return name;
    }

    public void editName(String n){
        name = n;
    }

    public void addCheckList(String type, String n){
        System.out.println(type);
        if (type.toLowerCase().equals("shopping")) {
            checkLists.putIfAbsent(n, new ShoppingList(n));
            System.out.println(n + " created");
        }
        else if (type.toLowerCase().equals("todo")) {
            checkLists.putIfAbsent(n, new TodoList(n));
            System.out.println(n + " created");

        }
        else if (type.equals("goal")) {
            Boolean exist = false;
            for (CheckList c : checkLists.values()){
                if (c instanceof GoalList){
                    exist = true;
                    System.out.println("You already have a goal list");
                    break;
                }
            }
            if (!exist) {
                checkLists.putIfAbsent(n, new GoalList(n));
                System.out.println(n + " created");

            }
        }
        else if (type.equals("team")) {
            checkLists.putIfAbsent(n, new TeamList(n));
            System.out.println(n + " created");
        }
        else System.out.println("no such type");
    }

    public void addCheckList(CheckList t){
        checkLists.putIfAbsent(t.getName(), t);
    }


    public void showCheckLists(){
        for (String k: getCheckLists().keySet()) {
            System.out.println(k);
        }
    }

    public void deleteChecklist(String n){
        checkLists.remove(n);
    }

    public CheckList getCheckList(String n){
        return checkLists.get(n);
    }

    public HashMap<String, CheckList> getCheckLists(){
        return checkLists;
    }
}
