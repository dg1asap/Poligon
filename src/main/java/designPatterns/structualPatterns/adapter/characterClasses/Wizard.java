package designPatterns.structualPatterns.adapter.characterClasses;

public class Wizard {
    protected int health = 100;

    public int castDestructionSpell() {
        return 40;
    }

    public void magicShield(int damage) {
        health = health - damage/2;
    }
}
