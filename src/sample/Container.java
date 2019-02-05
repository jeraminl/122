package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class Container {
    public static int NUMBER_OF_USERS = 4;
    HashMap<String, User> users;

    public Container(){
        users = new HashMap<String, User>();
    }

    public void showUsers(){
        System.out.println("Printing users");
    }

    public void showCheckLists(){

    }
    public void addUser(User u){
        users.put(u.name,u);
    }

    public User getUser(String n){
        return users.get(n);
    }
}
