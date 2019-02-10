package sample;

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
}
