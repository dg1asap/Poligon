package designPatterns.structualPatterns.composite.company;

public class Programmer implements Employee {
    double cost;

    public Programmer(double cost) {
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
