package designPatterns.structualPatterns.flyweight.tableTennis.products;

public class Racket extends TableTennisProduct {
    protected RacketType type;

    public Racket(int ID, RacketType type) {
        super(ID);
        this.type = type;
    }

    public boolean isSameType(Racket racket) {
        return this.type == racket.type;
    }

}
