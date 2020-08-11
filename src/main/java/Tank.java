

import javax.swing.*;
import java.awt.*;

public class Tank extends Moveobject {



    protected boolean[] dirs=new boolean[4];



    protected boolean[] getDirs() {
        return dirs;
    }


    public Tank(int x, int y, Direction direction,Image[] image) {
        this(x,y,direction,false,image);

    }

    public Tank(int x, int y, Direction direction,boolean enemy,Image[] image) {
        super(x,y,direction,enemy,image);
        this.x = x;
        this.y = y;
        this.direction = direction;
        speed=10;
        this.enemy=enemy;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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


    @Override
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




    public  void fire(){
        Bullet bullet=new Bullet(x,y,direction,false,TankGame.games1.bulletImg);
        TankGame.games1.addGameObject(bullet);

    }


    @Override
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

