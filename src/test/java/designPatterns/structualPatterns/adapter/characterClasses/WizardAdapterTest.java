package designPatterns.structualPatterns.adapter.characterClasses;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WizardAdapterTest {
    static WizardAdapter wizardAdapter;

    @BeforeAll
    static void createWizardAdapter() {
        wizardAdapter = new WizardAdapter();
    }

    @Test
    void testAttack(){
        int damage = wizardAdapter.attack();
        assertEquals(40, damage);
    }

    @Test
    void testMagicShield() {
        wizardAdapter.defend(40);
        assertEquals(wizardAdapter.wizard.health, 80);
    }
}
