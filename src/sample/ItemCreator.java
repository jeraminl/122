package sample;

public interface ItemCreator {
    Item create(String n);
    Item create(String n, int year, int month, int date, int hrs, int min, int p);
}
