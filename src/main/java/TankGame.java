import javax.swing.*;

public class TankGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        Games1 games1=new Games1(1024,768);
        frame.add(games1);
        frame.setTitle("坦克大戰");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

        games1.repaint();

    }
}
