import java.util.ArrayList;

public class User {

    private int userID;
    private String username;
    private Message lastMessage;
    private String senderLastMessage;

    public User(String username) {
        this.username = username;
        senderLastMessage = "notnullanymore";
    }

    public String getUsername() {
        return username;
    }

    public void setUserID(int id) {
        userID = id;
    }

    public int getUserID() {
        return userID;
    }

    public void update(Message message, String sender) {
        lastMessage = message;
        senderLastMessage = sender;
        if (message.hasReceiptConfMessage())
            message.getReceipt().update(username);
    }

    public void sendMessage(Channel channel, Message message) {
        channel.notify(message, username);
    }

    public void processLastReceivedMessage() {
        System.out.println(username + " received from " + senderLastMessage + " the message " + lastMessage.getMsgID() + " with the size " + lastMessage.getSize());
    }

    public boolean checkReception(Message m) {

        if (m.hasReceiptConfMessage()) {
            System.out.println("Message " + m.getMsgID() + " has been confirmed by " + m.getReceipt().getUsersThatReceived());
            return true;
        }
        else {
            System.out.println("Message " + m.getMsgID() + " has not been confirmed by any receiver");
            return false;
        }
    }

}
