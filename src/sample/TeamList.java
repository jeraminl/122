package sample;

import java.util.Scanner;

public class TeamList extends CheckList {
    public TeamList(String n) {
        super(n);
    }

    @Override
    void addItem(String n){
        TeamTodoItem toAdd = null;
        ItemCreator iCreator = new TeamTodoItemCreator();
        toAdd = (TeamTodoItem)iCreator.create(n);

        getItems().add(toAdd);
    }

    @Override
    void addItem(String n, int year, int month, int date, int hrs, int min, int p) {
        TeamTodoItem toAdd = null;
        ItemCreator iCreator = new TeamTodoItemCreator();
        toAdd = (TeamTodoItem) iCreator.create(n, year, month, date, hrs, min, p);
        getItems().add(toAdd);
    }

    @Override
    void addItemMenu(Scanner sc, String n) {
        System.out.println("Please enter deadline in the following format: \n" +
                "YYYY/MM/DD/HR/MI");
        String[] deadline = sc.nextLine().split("/");
        int[] dl = Main.stringToInt(deadline);

        System.out.println("Please enter the priority of this item from 1-5 (low to high)");
        int priority = sc.nextInt(); sc.nextLine();

        addItem(n,dl[0],dl[1],dl[2],dl[3],dl[4],priority);
    }
}
