package designPatterns.structualPatterns.decorator.notifer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmsDecoratorTest {
    private static SmsDecorator nonConfiguredSmsNotifier;
    private static SmsDecorator fullyConfiguredSmsNotifier;

    @BeforeAll
    static void createAndConfigureSmsNotifier() {
        createNotifiers();
        configureNotifier();
    }

    private static void createNotifiers() {
        MailNotifier mailNotifier = new MailNotifier();
        nonConfiguredSmsNotifier = new SmsDecorator(mailNotifier);
        fullyConfiguredSmsNotifier = new SmsDecorator(mailNotifier);
    }

    private static void configureNotifier() {
        fullyConfiguredSmsNotifier.setTelephoneNumber(123456789);
    }

    @Test
    public void testSendMessage() {
        nonConfiguredSmsNotifier.sendMessage("helloWorld");
        fullyConfiguredSmsNotifier.sendMessage("HelloWorld");

        assertEquals("", nonConfiguredSmsNotifier.lastMessage);
        assertEquals("123456789 : HelloWorld", fullyConfiguredSmsNotifier.lastMessage);
    }

}
