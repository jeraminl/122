package sample;

public class TeamTodoItemCreator implements ItemCreator{
    @Override
    public Item create(String n) {
        return new TeamTodoItem(n,0,0,0,0,0,0);
    }

    @Override
    public Item create(String n, int year, int month, int date, int hrs, int min, int p) {
        return new TeamTodoItem(n,year,month,date,hrs,min,p);
    }
}
