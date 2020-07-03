import java.util.ArrayList;

public class TextMessage extends Message {

    private int id;
    private String text;
    private ReceiptConfMessage receipt;

    public TextMessage(int id) {
        this.id = id;
    }

    public int getMsgID() {
        return id;
    }

    public void setContents(String text) {
        this.text = text;
    }

    public Object getContents() {
        return text;
    }

    public int getSize() {
        return text.length();
    }

    public void setReceipt(ReceiptConfMessage receipt) {
        this.receipt = receipt;
    }

    public ReceiptConfMessage getReceipt() {
        return receipt;
    }

    public boolean hasReceiptConfMessage() {
        if (receipt != null)
            return true;
        else return false;
    }

}
