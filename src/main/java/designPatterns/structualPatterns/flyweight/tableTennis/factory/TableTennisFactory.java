package designPatterns.structualPatterns.flyweight.tableTennis.factory;

public abstract class TableTennisFactory {
    protected int counterID;

    public TableTennisFactory(int startingID) {
        this.counterID = startingID;
    }
}
