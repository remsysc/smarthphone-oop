package apps;

import java.util.ArrayList;
import java.util.List;

//Handles SMS and chat messages.

public class MessagingApp extends App {

    private List<String> inbox;

    public MessagingApp() {
        super("Messages", "3.2");
        this.inbox = new ArrayList<>();
    }


    @Override
    public void open() {
        super.open();
        System.out.println("  [" + getName() + "] Loading inbox... " + inbox.size() + " messages.");
    }

    public void sendMessage(String contact, String text) {
        System.out.println("  [" + getName() + "] Sending to " + contact + ": \"" + text + "\"");
        System.out.println("  [" + getName() + "] Message delivered.");
    }

    public void receiveMessage(String sender, String text) {
        inbox.add("From " + sender + ": " + text);
        System.out.println("  [" + getName() + "] New message from " + sender + ": \"" + text + "\"");
    }

    public int getInboxCount() {
        return inbox.size();
    }
}
