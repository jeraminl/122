package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String id;
    private String name;
    private HashMap<String, CheckList> checkLists;
    private boolean goalExist = false;

    public User(String n){
        checkLists = new HashMap<String, CheckList>();
        name = n;

        //test default values
        //addCheckList("shopping", "christmas");
        //addCheckList("todo", "INF122");
        //addCheckList("team", "Project 1");

    }

    public String getName(){

        return name;
    }

    public void editName(String n){

        name = n;
    }

    public void addCheckList(String type, String n){
        CheckList toAdd = CheckListCreator.createChecklist(type,n);
        if (toAdd == null){
            System.out.println("no such type");
        }
        else if (toAdd instanceof GoalList && !goalExist){
            goalExist = true;
            checkLists.putIfAbsent(toAdd.getName(),toAdd);
        }
        else{
            checkLists.putIfAbsent(toAdd.getName(),toAdd);
        }

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
