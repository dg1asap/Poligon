package designPatterns.structualPatterns.decorator.notifer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotifierDecoratorTest {
    private static MailNotifier mailNotifier;
    private static SmsDecorator smsDecorator;
    private static DiscordDecorator discordDecorator;
    private static Notifier notifier;

    @BeforeAll
    static void createAndConfigureNotifier() {
        createNotifier();
        configureNotifier();
    }

    private static void createNotifier() {
        mailNotifier = new MailNotifier();
        smsDecorator = new SmsDecorator(mailNotifier);
        discordDecorator = new DiscordDecorator(smsDecorator);
        notifier = discordDecorator;
    }

    private static void configureNotifier() {
        configureMailNotifier();
        configureSmsNotifier();
        configureDiscordNotifier();
    }

    private static void configureMailNotifier() {
        mailNotifier.setReceiver("lifeIsBeautiful@gmail.com");
    }

    private static void configureSmsNotifier() {
        smsDecorator.setTelephoneNumber(987654321);
    }

    private static void configureDiscordNotifier() {
        discordDecorator.setCommunityID("#33991");
    }

    @Test
    public void testSendMessage() {
        notifier.sendMessage("Is anyone here?");

        assertEquals("lifeIsBeautiful@gmail.com : Is anyone here?", mailNotifier.lastMessage);
        assertEquals("987654321 : Is anyone here?", smsDecorator.lastMessage);
        assertEquals("#33991 : Is anyone here?", discordDecorator.lastMessage);
    }

}
