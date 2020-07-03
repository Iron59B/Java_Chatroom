import java.util.ArrayList;

public class ReceiptConfMessage extends Message {

    private String usersThatReceived;

    public ReceiptConfMessage(Message message) {
        setContents("Message has been received!");
        usersThatReceived = "";
        message.setReceipt(this);
    }

    public void setContents(String text) {}

    public String getContents() {
        return null;
    }

    public int getSize() {
        return -1;
    }

    public int getMsgID() {
        return -1;
    }

    public void setReceipt(ReceiptConfMessage receipt) {}

    public ReceiptConfMessage getReceipt() {
        return null;
    }

    public boolean hasReceiptConfMessage() {
        return false;
    }

    public void update(String username) {
        usersThatReceived += username + ", ";
    }

    public String getUsersThatReceived() {
        return usersThatReceived;
    }



}
