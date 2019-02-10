package sample;

import java.util.ArrayList;
import java.util.Scanner;

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
    void addItemMenu(Scanner sc, String n) {
        System.out.println("would you like to make a deadline and priority? Y/N");
        String cmd = sc.nextLine();

        if (cmd.toLowerCase().equals("y")) {
            System.out.println("Please enter deadline in the following format: \n" +
                    "YYYY/MM/DD/HR/MI");
            String[] deadline = sc.nextLine().split("/");
            int[] dl = Main.stringToInt(deadline);
            System.out.println("Please enter the priority of this item from 1-5 (low to high)");
            int priority = sc.nextInt(); sc.nextLine();

            addItem(n, dl[0], dl[1], dl[2], dl[3], dl[4], priority);
        }
        else {
            addItem(n);
        }
    }


    @Override
    public Boolean addItem(Item i) {
        return null;
    }
}
