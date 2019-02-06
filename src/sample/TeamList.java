package sample;

public class TeamList extends CheckList {
    public TeamList(String n) {
        super(n);

        //test adding items
        getItems().add(new TeamTodoItem("fix grammar", 2019, 3, 15, 11, 59, 1));

    }
}
