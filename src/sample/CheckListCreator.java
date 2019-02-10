package sample;

public class CheckListCreator {
    static CheckList createChecklist(String type, String n){
        System.out.println(type);
        if (type.toLowerCase().equals("shopping")) {

            System.out.println(n + " created");
            return new ShoppingList(n);
        }
        else if (type.toLowerCase().equals("todo")) {
            System.out.println(n + " created");
            return new TodoList(n);

        }
        else if (type.equals("goal")) {
            System.out.println(n + " created");
            return new GoalList(n);
        }
        else if (type.equals("team")) {
            System.out.println(n + " created");
            return new TeamList(n);
        }
        else System.out.println("no such type");
        return null;
    }
}
