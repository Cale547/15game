import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class PicComp extends JComponent {
    BufferedImage img;

    public PicComp() {}

    public PicComp(File f) {
        try{img = ImageIO.read(f);}
        catch (IOException e){System.out.println("Error");}
    }

    public void setImage(File f) {
        try{img = ImageIO.read(f);}
        catch (IOException e){System.out.println("Error");}
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, null, 0, 0);
    }
}