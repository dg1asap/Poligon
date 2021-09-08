package designPatterns.structualPatterns.adapter.characterClasses;

public class WizardAdapter implements Fighter {
    protected Wizard wizard = new Wizard();

    @Override
    public int attack() {
        return wizard.castDestructionSpell();
    }

    @Override
    public void defend(int damage) {
        wizard.magicShield(damage);
    }
}
