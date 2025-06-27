package GameObjects;

import Auxx.Size;
import Main.Main;
import States.GameState;
import Math.Vector2D;
import Graphics.Assets;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import Main.WindowGame;
public class Asteroid extends MovingObject {
    private Size size;

    public Asteroid(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState, Size size) {
        super(position, velocity, maxVel, texture, gameState);
        this.size = size;
        this.velocity = velocity.scale(maxVel);
    }

    @Override
    public void update() {
        position=position.add(velocity);
        if(position.getX()> WindowGame.WIDTH){
            position.setX(-width);
        }
        if(position.getY()> WindowGame.HEIGHT){
            position.setY(-height);
        }

        if(position.getX()<-width){
            position.setX(WindowGame.WIDTH);
        }
        if(position.getY()<-height){
            position.setY( WindowGame.HEIGHT);
        }

        angle+=Player.DELTAANGLE/2;

        collideswith();
    }

    public Size getSize() {
        return size;
    }

    @Override
    public void draw(Graphics g){
Graphics2D g2d = (Graphics2D) g;
        transform = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        transform.rotate(angle, width / 2, height/ 2);
        g2d.drawImage(texture, transform, null);
    }

@Override
    public void destroid(){
        gameState.divideAsteroid(this);
        gameState.addScore(size.points, position);
        super.destroid();
    }
}

