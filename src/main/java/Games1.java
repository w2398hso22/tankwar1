import javax.swing.*;
import java.awt.*;

public class Games1 extends JComponent {

    private int screenWidth;
    private int screenHeight;

    public Games1(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    }


    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(new ImageIcon("assets/images/itankD.png").getImage(), 400, 100, null);
    }
}







