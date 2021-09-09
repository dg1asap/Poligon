package designPatterns.structualPatterns.composite.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {
    static Manager emptyManager;
    static Manager managerWithOneProgrammer;
    static Manager managerWithOneManager;
    static Manager managerWithMultipleProgrammers;
    static Manager managerWithMultipleManagers;
    static Manager managerWithEmployees;

    @BeforeAll
    static void createManagers() {
        createEmptyManager();
        createManagerWithOneProgrammer();
        createManagerWithOneManager();
        createManagerWithMultipleProgrammers();
        createManagerWithMultipleManagers();
        createManagerWithEmployees();
    }

    private static void createEmptyManager() {
        emptyManager = new Manager(5000);
    }

    private static void createManagerWithOneProgrammer() {
        managerWithOneProgrammer = new Manager(5000);
        Programmer programmer = new Programmer(4000);
        managerWithOneProgrammer.addEmployee(programmer);
    }

    private static void createManagerWithOneManager() {
        managerWithOneManager = new Manager(3000);
        Manager manager = new Manager(2000);
        managerWithOneManager.addEmployee(manager);
    }

    private static void createManagerWithMultipleProgrammers() {
        managerWithMultipleProgrammers = new Manager(2000);
        Programmer firstProgrammer = new Programmer(400);
        Programmer secondProgrammer = new Programmer(400);
        Programmer thirdProgrammer = new Programmer(400);
        managerWithMultipleProgrammers.addEmployee(firstProgrammer);
        managerWithMultipleProgrammers.addEmployee(secondProgrammer);
        managerWithMultipleProgrammers.addEmployee(thirdProgrammer);
    }

    private static void createManagerWithMultipleManagers() {
        managerWithMultipleManagers = new Manager(1000);
        Manager firstManager = new Manager(500);
        Manager secondManager = new Manager(500);
        Manager thirdManager = new Manager(500);
        Manager fourManager = new Manager(500);
        managerWithMultipleManagers.addEmployee(firstManager);
        managerWithMultipleManagers.addEmployee(secondManager);
        managerWithMultipleManagers.addEmployee(thirdManager);
        managerWithMultipleManagers.addEmployee(fourManager);
    }

    private static void createManagerWithEmployees() {
        managerWithEmployees = new Manager(500);
        Programmer firstProgrammer = new Programmer(400);
        Programmer secondProgrammer = new Programmer(400);
        Manager firstManager = new Manager(500);
        Manager secondManager = new Manager(500);
        Manager thirdManager = new Manager(500);
        firstManager.addEmployee(firstProgrammer);
        secondManager.addEmployee(secondProgrammer);
        managerWithEmployees.addEmployee(firstManager);
        managerWithEmployees.addEmployee(secondManager);
        managerWithEmployees.addEmployee(thirdManager);
    }

    @Test
    void testGetCost() {
        assertEquals(5000, emptyManager.getCost());
        assertEquals(9000, managerWithOneProgrammer.getCost());
        assertEquals(5000, managerWithOneManager.getCost());
        assertEquals(3200, managerWithMultipleProgrammers.getCost());
        assertEquals(3000, managerWithMultipleManagers.getCost());
        assertEquals(2800, managerWithEmployees.getCost());
    }

    @Test
    void testAddAndRemoveEmployee() {
        Programmer programmer = new Programmer(400);
        Manager manager = new Manager(500);

        emptyManager.addEmployee(programmer);
        emptyManager.removeEmployee(programmer);
        emptyManager.addEmployee(manager);
        emptyManager.removeEmployee(manager);

        managerWithOneProgrammer.addEmployee(programmer);
        managerWithOneProgrammer.removeEmployee(programmer);
        managerWithOneProgrammer.addEmployee(manager);
        managerWithOneProgrammer.removeEmployee(manager);

        managerWithOneManager.addEmployee(programmer);
        managerWithOneManager.removeEmployee(programmer);
        managerWithOneManager.addEmployee(manager);
        managerWithOneManager.removeEmployee(manager);

        managerWithMultipleProgrammers.addEmployee(programmer);
        managerWithMultipleProgrammers.removeEmployee(programmer);
        managerWithMultipleProgrammers.addEmployee(manager);
        managerWithMultipleProgrammers.removeEmployee(manager);

        managerWithMultipleManagers.addEmployee(programmer);
        managerWithMultipleManagers.removeEmployee(programmer);
        managerWithMultipleManagers.addEmployee(manager);
        managerWithMultipleManagers.removeEmployee(manager);

        managerWithEmployees.addEmployee(programmer);
        managerWithEmployees.removeEmployee(programmer);
        managerWithEmployees.addEmployee(manager);
        managerWithEmployees.removeEmployee(manager);

        testGetCost();
    }


}
