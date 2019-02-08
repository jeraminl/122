package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main /*extends Application*/ {

    static Container sys;
    static User curUser;
    /*
    @Override
    public void start(Stage primaryStage) throws Exception{
        sys = new Container();
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane, 700, 700);
        primaryStage.setTitle("122 Checklists");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    */
    public static void main(String[] args) {
        //launch(args);
        sys = new Container();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("Please enter Username");
            String username = sc.nextLine();

            if (!sys.users.containsKey(username)) {
                System.out.println("User Does not exist... creating " + username);
                sys.addUser(new User(username));
            }
            curUser = sys.getUser(username);
            System.out.println("welcome " + username);
            mainMenu();
        }
    }

    public static void mainMenu(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("what would you like to do? \n" +
                    "1: Look at checklists \n" +
                    "2: create a checklist \n" +
                    "3: delete a checklist \n" +
                    "4: Share a Team List \n" +
                    "5: log out"
            );
            int cmd;
            cmd = sc.nextInt();
            sc.nextLine();
            if (cmd == 1) {
                System.out.println("which checklist do you wish to look at?");
                curUser.showCheckLists();
                String listNum = sc.nextLine();
                lookMenu(listNum, sc);
            } else if (cmd == 2) {
                System.out.println("please enter a name");
                String cName = sc.nextLine();
                System.out.println("Name: " + cName);
                System.out.println("please enter a type \n" +
                        "todo: Make a To Do List \n" +
                        "shopping: Make a Shopping list \n" +
                        "goal: Make a Goal List \n" +
                        "team: Make a Team List");
                String cType = sc.nextLine();
                System.out.println("Type: " + cType);
                curUser.addCheckList(cType, cName);
                //System.out.println(cName + " created \n");
            } else if (cmd == 3) {
                System.out.println("which checklist do you wish to look at?");
                curUser.showCheckLists();
                String listToDel = sc.nextLine();
                curUser.deleteChecklist(listToDel);
            } else if (cmd == 4) {
                System.out.println("Which team list would you like to share?");
                for (String k : curUser.getCheckLists().keySet()) {
                    if (curUser.getCheckLists().get(k) instanceof TeamList) System.out.println(k);
                }
                String ListToShare = sc.nextLine();
                System.out.println("Enter the username of the person you would like to share it to");
                String userToShare = sc.nextLine();
                sys.getUser(userToShare).addCheckList(curUser.getCheckList(ListToShare));
            } else if (cmd == 5) {
                break;
            }
        }
    }

    public static void lookMenu(String i, Scanner sc){
        CheckList cl = curUser.getCheckList(i);
        cl.showItems();
        System.out.println("What would you like to do with this list? \n" +
                "1: complete an item \n" +
                "2: create an item \n" +
                "3: delete an item \n" +
                "4: edit an item \n" +
                "5: Interact with sub-goals" +
                "6: back to main menu" );
        int cmd = sc.nextInt();
        sc.nextLine();
        while (true) {
            cl.showItems();
            if (cmd == 1){
                System.out.println("what item would you like to complete?");
                int item = sc.nextInt();
                sc.nextLine();
                cl.getItems().get(item-1).complete();
                break;

            } else if (cmd == 2) {
                System.out.println("Enter the task description to create");
                String name = sc.nextLine();
                addItemCmd(cl, name, sc);
                break;
            } else if (cmd == 3) {
                System.out.println("What would you like to delete?");
                int item = sc.nextInt();
                cl.getItems().remove(item-1);
                sc.nextLine();

                break;
            } else if (cmd == 4) {
                System.out.println("what Item would you like to edit?");
                int item = sc.nextInt();
                sc.nextLine();
                System.out.println("what is the new description?");
                String content = sc.nextLine();
                cl.getItems().get(item-1).editContent(content);
                System.out.println("What is the new priority 1-5? 0 for no priority");
                int nPriority = sc.nextInt();
                sc.nextLine();



                break;
            } else if (cmd == 5) {
                if (!(cl instanceof GoalList)){
                    System.out.println("This option is only available for a Goal List");
                }
                else{
                    System.out.println("which Goal chain would you like to interact with?");
                    int item = sc.nextInt();
                    sc.nextLine();
                    goalItemMenu(((GoalList) cl).getGoalItems().get(item-1), sc);
                }
                break;
            } else if (cmd == 6) {
                break;
            } else {
                System.out.println("invalid command");
            }
        }

    }

    public static void addItemCmd(CheckList cl, String name, Scanner sc){
        if (cl instanceof GoalList){
            System.out.println("would you like to make a deadline and priority? Y/N");
            String cmd = sc.nextLine();

            if (cmd == "y") {
                System.out.println("Please enter deadline in the following format: \n" +
                        "YYYY/MM/DD/HR/MI");
                String[] deadline = sc.nextLine().split("/");
                int[] dl = stringToInt(deadline);
                System.out.println("Please enter the priority of this item from 1-5 (low to high)");
                int priority = sc.nextInt();
                sc.nextLine();

                ((GoalList) cl).addSubGoalList(name, dl[0], dl[1], dl[2], dl[3], dl[4], priority);
            }
            else {
                ((GoalList) cl).addSubGoalList(name);
            }

        } else if (cl instanceof TeamList) {
            System.out.println("Please enter deadline in the following format: \n" +
                    "YYYY/MM/DD/HR/MI");
            String[] deadline = sc.nextLine().split("/");
            int[] dl = stringToInt(deadline);

            System.out.println("Please enter the priority of this item from 1-5 (low to high)");
            int priority = sc.nextInt();
            sc.nextLine();

            cl.addItem(new TeamTodoItem(name,dl[0],dl[1],dl[2],dl[3],dl[4],priority));


        } else if (cl instanceof TodoList) {
            System.out.println("would you like to make a deadline and priority? Y/N");
            String cmd = sc.nextLine();

            if (cmd == "y") {
                System.out.println("Please enter deadline in the following format: \n" +
                        "YYYY/MM/DD/HR/MI");
                String[] deadline = sc.nextLine().split("/");
                int[] dl = stringToInt(deadline);

                System.out.println("Please enter the priority of this item from 1-5 (low to high)");
                int priority = sc.nextInt();
                sc.nextLine();

                cl.addItem(new TodoItem(name, dl[0], dl[1], dl[2], dl[3], dl[4], priority));
            }
            else {
                cl.addItem(new TodoItem(name));
            }


        } else if (cl instanceof ShoppingList) {
            cl.addItem(new ShoppingItem(name));
        }

    }

    public static int[] stringToInt(String[] sArray){
        int[] dl = new int[5];
        int i = 0;
        for (String s: sArray){
            dl[0] = Integer.valueOf(s);
            i++;
        }
        return dl;
    }

    public static void goalItemMenu(GoalItem item, Scanner sc){
        item.showItems();
        System.out.println("What would you like to do with this list? \n" +
                "1: complete an item \n" +
                "2: create an item \n" +
                "3: delete an item \n" +
                "4: edit an item \n" +
                "5: Interact with sub-goals \n" +
                "6: back to main menu" );
        int cmd = sc.nextInt();
        sc.nextLine();
        while (true) {
            item.showItems();
            if (cmd == 1){
                System.out.println("what item would you like to complete?");
                int i = sc.nextInt();
                sc.nextLine();
                item.getSubGoalItems().get(i-1).complete();
                break;

            } else if (cmd == 2) {
                System.out.println("Enter the task description to create");
                String name = sc.nextLine();
                addSubItemCmd(item, name, sc);
                break;
            } else if (cmd == 3) {
                System.out.println("What would you like to delete?");
                int i = sc.nextInt();
                item.getSubGoalItems().remove(i-1);
                sc.nextLine();

                break;
            } else if (cmd == 4) {
                System.out.println("what Item would you like to edit?");
                int i = sc.nextInt();
                sc.nextLine();
                System.out.println("what is the new description?");
                String content = sc.nextLine();
                item.getSubGoalItems().get(i-1).editContent(content);


                break;
            } else if (cmd == 5) {

                System.out.println("which Goal chain would you like to interact with?");
                int i = sc.nextInt();
                sc.nextLine();
                goalItemMenu(item.getSubGoalItems().get(i-1),sc);
                break;

            } else if (cmd == 6) {
                break;
            } else {
                System.out.println("invalid command");
            }
        }
    }

    public static void addSubItemCmd(GoalItem cl, String name, Scanner sc){

        System.out.println("would you like to make a deadline and priority? Y/N");
        String cmd = sc.nextLine();

        if (cmd == "y") {
            System.out.println("Please enter deadline in the following format: \n" +
                    "YYYY/MM/DD/HR/MI");
            String[] deadline = sc.nextLine().split("/");
            int[] dl = stringToInt(deadline);
            System.out.println("Please enter the priority of this item from 1-5 (low to high)");
            int priority = sc.nextInt();
            sc.nextLine();

            cl.addSubItems(new GoalItem(name, dl[0], dl[1], dl[2], dl[3], dl[4], priority));
        } else {
            cl.addSubItems(new GoalItem(name));
        }


    }
}
