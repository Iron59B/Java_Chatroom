import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class ImageMessage extends Message {

    private int id;
    private BufferedImage image;
    private ReceiptConfMessage receipt;

    public ImageMessage(int id) {
        this.id = id;
    }

    public int getMsgID() {
        return id;
    }

    public int getSize() {
        return image.getHeight() * image.getWidth();
    }

    public void setContents(String path) {
        try {
            image = ImageIO.read(new File(path));
        }
        catch (IOException e) {
            System.out.println("image not found");
        }
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

    public BufferedImage getContents() {
        return image;
    }

}
