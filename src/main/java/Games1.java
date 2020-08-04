

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Games1 extends JComponent {

    private int screenWidth;
    private int screenHeight;

    private Tank playerTank;

    private boolean stop;

    public Games1(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        init();

        new Thread(()->{
            while (!stop){
                repaint();
                try {
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public void init(){
        playerTank=new Tank(getCenterPosX(47), getCenterPosY(47),Direction.DOWN);
    }


    @Override
    protected void paintComponent(Graphics g){
        playerTank.draw(g);
    }

    private int getCenterPosX(int width){
        return (screenWidth-width)/2;
    }

    private int getCenterPosY(int height){
        return (screenHeight-height)/2;
    }

    public void keyPressed(KeyEvent e){
        boolean[] dirs=playerTank.getDirs();
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                //playerTank.setDirection(Direction.UP)
                dirs[0]=true;
                break;
            case KeyEvent.VK_DOWN:
                //playerTank.setDirection(Direction.DOWN);
                dirs[1]=true;
                break;
            case KeyEvent.VK_LEFT:
                //playerTank.setDirection(Direction.LEFT);
                dirs[2]=true;
                break;
            case KeyEvent.VK_RIGHT:
                //playerTank.setDirection(Direction.RIGHT);
                dirs[3]=true;
                break;
            default:
        }

    }


    public void keyReleased(KeyEvent e) {
        boolean[] dirs=playerTank.getDirs();
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                //playerTank.setDirection(Direction.UP)
                dirs[0]=false;
                break;
            case KeyEvent.VK_DOWN:
                //playerTank.setDirection(Direction.DOWN);
                dirs[1]=false;
                break;
            case KeyEvent.VK_LEFT:
                //playerTank.setDirection(Direction.LEFT);
                dirs[2]=false;
                break;
            case KeyEvent.VK_RIGHT:
                //playerTank.setDirection(Direction.RIGHT);
                dirs[3]=false;
                break;
            default:
        }


    }
}







