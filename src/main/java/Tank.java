

import javax.swing.*;
import java.awt.*;

public class Tank extends GameObject {

    protected int speed;
    protected Direction direction;

    protected boolean[] dirs=new boolean[4];

    protected boolean enemy;

    protected boolean[] getDirs() {
        return dirs;
    }


    public Tank(int x, int y, Direction direction,Image[] image) {
        this(x,y,direction,false,image);

    }

    public Tank(int x, int y, Direction direction,boolean enemy,Image[] image) {
        super(x,y,image);
        this.x = x;
        this.y = y;
        this.direction = direction;
        speed=10;
        this.enemy=enemy;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }












    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void detemainDirection(){
        if(dirs[0] && dirs[2] && !dirs[1] && !dirs[3]) direction=Direction.UP_LEFT;
        else if(dirs[0] && dirs[3] && !dirs[2] && !dirs[1]) direction=Direction.UP_RIGHT;
        else if(dirs[1] && dirs[2] && !dirs[0] && !dirs[3]) direction=Direction.DOWN_LEFT;
        else if(dirs[1] && dirs[3] && !dirs[0] && !dirs[2]) direction=Direction.DOWN_RIGHT;
        else if(dirs[0] && !dirs[3] && !dirs[1] && !dirs[2]) direction=Direction.UP;
        else if(dirs[1] && !dirs[3] && !dirs[0] && !dirs[2]) direction=Direction.DOWN;
        else if(dirs[2] && !dirs[3] && !dirs[0] && !dirs[1]) direction=Direction.LEFT;
        else if(dirs[3] && !dirs[1] && !dirs[0] && !dirs[2]) direction=Direction.RIGHT;
    }

    public void draw(Graphics g){
        if(!isStop()) {
            detemainDirection();
            move();
            collision();

        }





        g.drawImage(image[direction.ordinal()],x,y,null);


    }

    public boolean isStop(){
        for(int i=0;i<dirs.length;i++){
            if(dirs[i]){
                return false;
            }
        }return true;
    }



    public void move() {
        oldx=x;
        oldy=y;
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP_RIGHT:
                y -= speed;
                x += speed;
                break;
            case UP_LEFT:
                y -= speed;
                x -= speed;
                break;
            case DOWN_RIGHT:
                y += speed;
                x += speed;
                break;
            case DOWN_LEFT:
                y += speed;
                x -= speed;
                break;

        }


    }
    public  void fire(){
        Bullet bullet=new Bullet(x,y,direction,false,TankGame.games1.bulletImg);
        TankGame.games1.addGameObject(bullet);

    }

    public boolean collisionBound(){
        boolean collision=false;

        if(x<0){
            x=0;
            collision=true;
        }else if(x>TankGame.games1.getWidth()-width){
            x=TankGame.games1.getWidth()-width;
            collision=true;
        }

        if(y<0){
            y=0;
            collision=true;
        }else if(y>TankGame.games1.getHeight()-height){
            y=TankGame.games1.getHeight()-height;
            collision=true;
        }
        return collision;

    }

    public void collision(){
        if(x<0){
            x=0;
        }else if(x>TankGame.games1.getWidth()-width){
            x=TankGame.games1.getWidth()-width;
        }

        if(y<0){
            y=0;
        }else if(y>TankGame.games1.getHeight()-height){
            y=TankGame.games1.getHeight()-height;
        }

        for(GameObject object:TankGame.games1.getGameobjects()){
            if(object!=this){
                if(object.getRectangle().intersects(getRectangle())){
                    x=oldx;
                    y=oldy;
                    return;
                }
            }
        }



    }

    }

