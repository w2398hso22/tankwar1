import java.awt.*;

public class PlayerTank extends Tank implements SuperFire {
    public PlayerTank(int x, int y, Direction direction, Image[] image) {
        super(x, y, direction, image);
    }

    @Override
    public void superFire(){
        for(Direction direction:Direction.values()){
            Bullet bullet = new Bullet(x+(width-Games1.bulletImg[0].getWidth(null))/2,
                    y+(height-Games1.bulletImg[0].getHeight(null))/2, direction, enemy, Games1.bulletImg);
            TankGame.games1.addGameObject(bullet);
        }

    }
}
