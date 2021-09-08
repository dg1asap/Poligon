package designPatterns.structualPatterns.adapter.characterClasses;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WizardTest {
    static Wizard wizard;

    @BeforeAll
    static void createWizard() {
        wizard = new Wizard();
    }

    @Test
    void testCastDestructionSpell() {
        int damage = wizard.castDestructionSpell();
        assertEquals(40, damage);
    }

    @Test
    void testMagicShield() {
        wizard.magicShield(40);
        assertEquals(wizard.health, 80);
    }

}
