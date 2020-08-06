import javax.swing.*;
import java.awt.*;

public abstract class GameObject {
    protected int oldx;
    protected int oldy;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    protected Image[] image;


    public GameObject(int x,int y,Image[] image){
        this.x=x;
        this.y=y;
        this.image=image;
        width=image[0].getWidth(null);
        height=image[0].getHeight(null);
    }

    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }



    public abstract void draw(Graphics g);



}
