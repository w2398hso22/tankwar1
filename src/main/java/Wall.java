import javax.swing.*;
import java.awt.*;

public class Wall extends GameObject {
    private int x;
    private int y;

    private boolean horizontal;
    private int bricks;
    private Image image;


    Wall(int x,int y,boolean horizontal,int bricks,Image image){
        super(x,y,image);
        this.horizontal=horizontal;
        this.bricks=bricks;


    }



    public void draw(Graphics g){
        if(horizontal){
            for(int i=0;i<bricks;i++){
                g.drawImage(image,x+i*image.getWidth(null),y,null);
            }
        }else{
            for(int i=0;i<bricks;i++){
                g.drawImage(image,x,y+i*image.getWidth(null),null);
            }
        }
    }
}
