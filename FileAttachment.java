import java.io.File;

public class FileAttachment extends Message {

    private File file;
    private int size;

    public FileAttachment(File file) {
        this.file = file;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public Object getContents() {
        return file;
    }

    public int getMsgID() {
        return -1;
    }

    public void setContents(String some) {}

    public boolean hasReceiptConfMessage() {
        return false;
    }

    public void setReceipt(ReceiptConfMessage receipt) {}

    public ReceiptConfMessage getReceipt() {
        return null;
    }
}
