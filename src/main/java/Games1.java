import javax.swing.*;
import java.awt.*;

public class Games1 extends JComponent {

    private int screenWidth;
    private int screenHeight;

    public Games1(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    }



    Games1(){
        this.setPreferredSize(new Dimension(800,600));
    }

}
