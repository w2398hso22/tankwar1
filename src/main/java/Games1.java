

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TypeHost;
import nana.tools.Tools1;


import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Games1 extends JComponent {

    private int screenWidth;
    private int screenHeight;

    private Tank playerTank;


    private List<GameObject> gameobjects=new ArrayList<>();






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

        Image[] brickImage={Tools.getImage("brick.png")};
        Image[] iTankImg=new Image[8];
        Image[] eTankImg=new Image[8];

        String[] subName={"U.png","D.png","L.png","R.png","LU.png","RU.png","LD.png","RD.png"};

        for(int i =0;i<iTankImg.length;i++){
            iTankImg[i]=Tools.getImage("itank"+subName[i]);
            eTankImg[i]=Tools.getImage("etank"+subName[i]);
        }






        playerTank=new Tank(getCenterPosX(47), getCenterPosY(580),Direction.DOWN,iTankImg);
        gameobjects.add(playerTank);
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                gameobjects.add(new Tank(350+j*80,500+80*i,Direction.UP,true,eTankImg));
            }

        }

        gameobjects.add(new Wall(250, 150, true, 15,brickImage));
        gameobjects.add(new Wall(150, 200, false, 15,brickImage));
        gameobjects.add(new Wall(800, 200, false, 15,brickImage));









    }


    @Override
    protected void paintComponent(Graphics g){



        for(GameObject object:gameobjects){
            object.draw(g);
        }


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

    public List<GameObject> getGameobjects(){
        return gameobjects;
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







