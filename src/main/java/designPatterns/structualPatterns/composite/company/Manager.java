package designPatterns.structualPatterns.composite.company;

import java.util.ArrayList;

public class Manager implements Employee {
    private ArrayList <Employee> employees = new ArrayList<>();
    private double cost;

    public Manager(double cost) {
        this.cost = cost;
    }

    @Override
    public double getCost() {
        double cost = this.cost;
        for (Employee employee : employees)
            cost += employee.getCost();
        return cost;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

}
