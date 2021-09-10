package designPatterns.structualPatterns.decorator.notifer;

public abstract class NotifierDecorator implements Notifier {
    private Notifier component;

    public NotifierDecorator(Notifier notifier) {
        this.component = notifier;
    }

    public void sendMessage(String message) {
        component.sendMessage(message);
    }

}
