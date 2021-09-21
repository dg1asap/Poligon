package designPatterns.structualPatterns.flyweight.tableTennis.products;

public abstract class TableTennisProduct {
    protected int ID;

    public TableTennisProduct(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
