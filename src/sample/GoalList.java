package sample;

import java.util.ArrayList;

public class GoalList extends CheckList {
    ArrayList<GoalItem> subGoalLists;

    public GoalList(String n) {
        super(n);
        subGoalLists = new ArrayList<GoalItem>();
    }

    public void showItems(){
        System.out.println(getName() + ": ");
        System.out.println("==================================================");

        for (GoalItem item : getGoalItems()){
            item.printContent();
            if (item.getSubGoalItems().size() > 0){

            }
        }
        System.out.println("==================================================");

    }

    public void addSubGoalList(String name){
        GoalItem toAdd = new GoalItem(name);
        getGoalItems().add(toAdd);
    }

    public void addSubGoalList(String i, int year, int month, int date, int hrs, int min, int p){
        GoalItem toAdd = new GoalItem(i,year,month,date,hrs,min,p);
        getGoalItems().add(toAdd);
    }

    public ArrayList<GoalItem> getGoalItems(){
        return subGoalLists;
    }


}
