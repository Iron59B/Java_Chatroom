import java.util.ArrayList;

public abstract class Message {

    public abstract void setContents(String contents);
    public abstract int getMsgID();
    public abstract Object getContents();
    public abstract int getSize();
    public abstract boolean hasReceiptConfMessage();
    public abstract void setReceipt(ReceiptConfMessage receipt);
    public abstract ReceiptConfMessage getReceipt();

}
