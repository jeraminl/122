package sample;

import java.util.ArrayList;

public class GoalList extends CheckList implements ListMutable, ListPeekable {

    public GoalList(String n) {
        super(n);
    }


    public void showItems(){
        System.out.println(getName() + ": ");
        System.out.println("========================items==========================");
        int i = 1;
        for (Item item : getItems()){
            System.out.print(i + ": ");
            item.printContent();
            if (((GoalItem)item).getSubGoalItems().size() > 0){

            }
        }
        System.out.println("==================================================");

    }

    @Override
    public void addItem(String n){
        GoalItem toAdd = null;
        ItemCreator iCreator = new GoalItemCreator();
        toAdd = (GoalItem)iCreator.create(n);
        getItems().add(toAdd);
    }

    @Override
    public void addItem(String i, int year, int month, int date, int hrs, int min, int p){
        GoalItem toAdd = null;
        ItemCreator iCreator = new GoalItemCreator();
        toAdd = (GoalItem)iCreator.create(i,year,month,date,hrs,min,p);
        getItems().add(toAdd);
    }



    @Override
    public Boolean addItem(Item i) {
        return null;
    }
}
