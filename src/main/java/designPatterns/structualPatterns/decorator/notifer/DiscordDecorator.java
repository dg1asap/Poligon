package designPatterns.structualPatterns.decorator.notifer;

public class DiscordDecorator extends NotifierDecorator {
    protected String lastMessage = "";
    private String communityID;

    public DiscordDecorator(Notifier notifier) {
        super(notifier);
    }

    public void setCommunityID(String communityID) {
        this.communityID = communityID;
    }

    @Override
    public void sendMessage(String message) {
        if (communityID != null)
            lastMessage = communityID + " : " + message;
        super.sendMessage(message);
    }
}
