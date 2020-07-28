import javax.swing.*;

public class TankGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.add(new Games1(1565,687));
        frame.setTitle("坦克大戰");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

    }
}
