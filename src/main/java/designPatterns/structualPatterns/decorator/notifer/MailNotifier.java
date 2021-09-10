package designPatterns.structualPatterns.decorator.notifer;

public class MailNotifier implements Notifier {
    protected String lastMessage = "";
    private String mail;

    public void setReceiver(String mail) {
        this.mail = mail;
    }

    public void sendMessage(String message) {
        if (mail != null)
            lastMessage = mail + " : " + message;
    }

}
