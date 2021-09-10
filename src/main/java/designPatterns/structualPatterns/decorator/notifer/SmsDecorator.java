package designPatterns.structualPatterns.decorator.notifer;

public class SmsDecorator extends NotifierDecorator {
    protected String lastMessage = "";
    private int telephoneNumber;

    public SmsDecorator(Notifier notifier) {
        super(notifier);
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public void sendMessage(String message) {
        if (telephoneNumber != 0)
            lastMessage = telephoneNumber + " : " + message;
        super.sendMessage(message);
    }

}
