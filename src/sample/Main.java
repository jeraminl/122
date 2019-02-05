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


        while(true){

            System.out.println("Please enter Username");
            String username = sc.nextLine();

            if (!sys.users.containsKey(username)) {
                System.out.println("User Does not exist... creating " + username);
            }
            sys.addUser(new User(username));
            curUser = sys.getUser(username);
            System.out.println("welcome " + username);
            mainMenu();




        }

    }

    public static void mainMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("what would you like to do? \n" +
                "1: Look at checklists \n"+
                "2: create a checklist \n" +
                "3: delete a checklist \n" +
                "4: edit a checkklist"
        );
        int cmd;
        cmd = sc.nextInt();
        switch(cmd) {
            case 1:
                System.out.println("which checklist do you wish to look at?");
                int i = 1;
                for (String k: curUser.getCheckLists().keySet()) {
                    System.out.println(i + ": " + k);
                    i++;
                }
                String listNum = sc.nextLine();
                lookMenu(listNum);
                break;

        }

    }

    public static void lookMenu(String i){
        CheckList cl = curUser.getCheckList(i);
        cl.showItems();
    }
}
