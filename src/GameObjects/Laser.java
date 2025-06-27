package GameObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Main.WindowGame;
import Math.Vector2D;
import States.GameState;

public class Laser extends MovingObject {
    private MovingObject owner;
    private boolean UFO;

    public Laser(Vector2D position, Vector2D velocity, double maxVel, double angle, BufferedImage texture, GameState gameState, MovingObject owner, boolean UFO) {
        super(position, velocity, maxVel, texture, gameState);
        this.angle = angle;
        this.velocity = velocity.scale(maxVel);
        this.owner = owner;
        this.UFO = UFO;
    }

    public boolean isUFO() {
        return UFO;
    }

    public void setUFO(boolean UFO) {
        this.UFO = UFO;
    }

    public MovingObject getOwner() {
        return owner;
    }


    @Override
    public void update() {
        position=position.add(velocity);
        if(position.getX()<0 || position.getX()> WindowGame.WIDTH || position.getY()<0 || position.getY()> WindowGame.HEIGHT){
            destroid();
        }
        collideswith();
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        transform= AffineTransform.getTranslateInstance(position.getX()-width/2, position.getY()+10);
        transform.rotate(angle, width/2, 10);
        g2d.drawImage(texture, transform, null);
    }

    @Override
    public Vector2D getCenter() {
        return new Vector2D(position.getX() + width/2, position.getY() + width/2);
    }


}
