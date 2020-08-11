

import java.awt.*;

public abstract class Moveobject extends GameObject {

    protected int speed;
    protected Direction direction;



    protected boolean enemy;




    public Moveobject(int x, int y, Direction direction, Image[] image) {
        this(x,y,direction,false,image);

    }

    public Moveobject(int x, int y, Direction direction, boolean enemy, Image[] image) {
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



    public void draw(Graphics g){

        move();
        collision();







        g.drawImage(image[direction.ordinal()],x,y,null);


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

    public abstract void collision();





    }


