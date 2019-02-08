package sample;

import java.util.ArrayList;

public class SubGoalList extends GoalList {
    ArrayList<SubGoalList> subGoalLists;
    public SubGoalList(String n) {
        super(n);
    }

    public void showItems(){
        System.out.println(getName() + ": ");
        System.out.println("------------------------------------------------------");
        for (SubGoalList subList : subGoalLists){
            subList.showItems();
        }
        for (Item item : getItems()){
            item.printContent();
        }
        System.out.println("-----------------------------------------------------");

    }


}
