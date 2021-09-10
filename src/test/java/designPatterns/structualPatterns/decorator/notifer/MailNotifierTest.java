package designPatterns.structualPatterns.decorator.notifer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailNotifierTest {
    private static MailNotifier nonConfiguredMailNotifier;
    private static MailNotifier fullyConfiguredMailNotifier;

    @BeforeAll
    static void createAndConfigureMailNotifiers() {
        createNotifiers();
        configureNotifier();
    }

    private static void createNotifiers() {
        nonConfiguredMailNotifier = new MailNotifier();
        fullyConfiguredMailNotifier = new MailNotifier();
    }

    private static void configureNotifier() {
        fullyConfiguredMailNotifier.setReceiver("devilMayCry@gmail.com");
    }

    @Test
    public void testSendMessage() {
        nonConfiguredMailNotifier.sendMessage("best Capcom product");
        fullyConfiguredMailNotifier.sendMessage("the best Capcom product");

        assertEquals(nonConfiguredMailNotifier.lastMessage, "");
        assertEquals(fullyConfiguredMailNotifier.lastMessage, "devilMayCry@gmail.com : the best Capcom product");
    }

}
