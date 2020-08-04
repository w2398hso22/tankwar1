import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final Games1 games1=new Games1(1024,768);
        frame.add(games1);
        frame.setTitle("坦克大戰");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

        games1.repaint();

        frame.addKeyListener(new KeyAdapter() {


            @Override
            public void keyPressed(KeyEvent e) {
                games1.keyPressed(e);

                //super.keyPressed(e);

                //System.out.println((char)e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                games1.keyReleased(e);

            }
        });

    }
}
