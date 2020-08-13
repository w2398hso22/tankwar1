import java.awt.*;

public class Explosion extends GameObject {
    public Explosion(int x, int y, Image[] image) {
        super(x, y, image);
        new Thread(()->{
            try{
                Thread.sleep(25);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(++frame>=image.length){
                alive=false;
            }
        }).start();
    }

    @Override
    public void draw(Graphics g) {
        if(alive){
            g.drawImage(image[frame],x,y,null);
        }

    }
}
