package designPatterns.structualPatterns.decorator.notifer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscordDecoratorTest {
    private static DiscordDecorator nonConfiguredDiscordNotifier;
    private static DiscordDecorator fullyConfiguredDiscordNotifier;

    @BeforeAll
    static void createAndConfigureSmsNotifier() {
        createNotifiers();
        configureNotifier();
    }

    private static void createNotifiers() {
        MailNotifier mailNotifier = new MailNotifier();
        nonConfiguredDiscordNotifier = new DiscordDecorator(mailNotifier);
        fullyConfiguredDiscordNotifier = new DiscordDecorator(mailNotifier);
    }

    private static void configureNotifier() {
        fullyConfiguredDiscordNotifier.setCommunityID("#22442");
    }

    @Test
    public void testSendMessage() {
        nonConfiguredDiscordNotifier.sendMessage("This Is The End");
        fullyConfiguredDiscordNotifier.sendMessage("this is the end");

        assertEquals("", nonConfiguredDiscordNotifier.lastMessage);
        assertEquals("#22442 : this is the end", fullyConfiguredDiscordNotifier.lastMessage);
    }

}
