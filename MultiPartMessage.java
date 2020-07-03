import java.io.File;
import java.util.ArrayList;

public class MultiPartMessage extends Message {

    private int id;
    private String text;
    private ArrayList<Message> attachments;
    private ReceiptConfMessage receipt;

    public MultiPartMessage(int id) {
        this.id = id;
        attachments = new ArrayList<Message>();
    }

    public int getMsgID() {
        return id;
    }

    public int getSize() {
        int sum = 0;
        for (int i = 0; i < attachments.size(); i++) {
            sum += attachments.get(i).getSize();
        }
        sum += text.length();
        return sum;
    }

    public void setContents(String text) {
        this.text = text;
    }

    public Object getContents() {
        return text;
    }

    // attaching another message
    public void addAttachment(Message attachment) {
        attachments.add(attachment);
    }

    // attaching a file
    public void addAttachment(String attachment) {
        File file = new File(attachment);
        FileAttachment fileAtt = new FileAttachment(file);
        fileAtt.setSize(attachment.length());
        attachments.add(fileAtt);
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
