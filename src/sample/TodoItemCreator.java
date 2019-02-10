package sample;

public class TodoItemCreator implements ItemCreator {
    @Override
    public Item create(String n) {
        return new TodoItem(n);
    }

    @Override
    public Item create(String n, int year, int month, int date, int hrs, int min, int p) {
        return new TodoItem(n,year,month,date,hrs,min,p);
    }
}
