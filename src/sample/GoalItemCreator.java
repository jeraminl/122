package sample;

public class GoalItemCreator implements ItemCreator {
    @Override
    public Item create(String n) {
        return new GoalItem(n);

    }

    @Override
    public Item create(String n, int year, int month, int date, int hrs, int min, int p) {
        return new GoalItem(n,year,month,date,hrs,min,p);

    }
}
