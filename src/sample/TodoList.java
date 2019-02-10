package sample;

import java.util.Date;

public class TodoList extends CheckList {

    public TodoList(String n) {
        super(n);

    }
    @Override
    void addItem(String n){
        TodoItem toAdd = null;
        ItemCreator iCreator = new TodoItemCreator();
        toAdd = (TodoItem)iCreator.create(n);

        getItems().add(toAdd);
    }

    @Override
    void addItem(String n, int year, int month, int date, int hrs, int min, int p) {
        TodoItem toAdd = null;
        ItemCreator iCreator = new TodoItemCreator();
        toAdd = (TodoItem)iCreator.create(n);

        getItems().add(toAdd);
    }

}
