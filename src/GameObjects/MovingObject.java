package GameObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Math.Vector2D;
import States.GameState;
import Graphics.Sound;
import Graphics.Assets;
import States.GameState;

public abstract class MovingObject extends GameObject {
    protected Vector2D velocity;
    protected AffineTransform transform;
    protected double angle;
    protected double maxVel;
    protected int height, width;
    protected GameState gameState;
    private Sound explosion;

    public MovingObject(Vector2D position, Vector2D velocity, double maxVel,BufferedImage texture, GameState gameState) {
        super(position, texture);
        this.velocity = velocity;
        this.maxVel=maxVel;
        angle=0;
        width=texture.getWidth();
        height=texture.getHeight();
        this.gameState=gameState;
        explosion=new Sound(Assets.explosion);
    }

    protected void collideswith(){
        ArrayList<MovingObject> movingObjects = gameState.getMovingObjects();

        for(int i=0; i<movingObjects.size(); i++){
            MovingObject movingObject = movingObjects.get(i);
            if(movingObject.equals(this)){
                continue;
            }

            double distance=movingObject.getCenter().substract(getCenter()).getMagnitude();
            if(distance<movingObject.width/2+width/2 && movingObjects.contains(this)){
                ObjectCollision(movingObject, this);
            }
        }
    }

    private void ObjectCollision(MovingObject a, MovingObject b) {
        if(a instanceof Player && ((Player)a).isSpawing()){
            return;
        }

        if(b instanceof Player && ((Player)b).isSpawing()){
            return;
        }

        if(b instanceof Shield && a instanceof Player){
            ((Shield)b).ON=true;

        }else if(a instanceof Shield && b instanceof Player){
            ((Shield)a).ON=true;
        }

        // Evitar autocolisión del láser con su dueño
        if ((a instanceof Laser && b == ((Laser) a).getOwner()) ||
                (b instanceof Laser && a == ((Laser) b).getOwner())) {
            return;
        }

        // Ignorar colisión entre láser del UFO y asteroides
        if ((a instanceof Laser && b instanceof Asteroid && ((Laser) a).isUFO()) ||
                (b instanceof Laser && a instanceof Asteroid && ((Laser) b).isUFO())) {
            return;
        }

        // Láser golpea al jugador
        if ((a instanceof Laser && b instanceof Player)  || (b instanceof Laser && a instanceof Player) ){
            gameState.PlayExplotion(a.getCenter());
            a.destroid();
            b.destroid();
            return;
        }

        // Jugador choca con asteroide
        if (a instanceof Player && b instanceof Asteroid ) {
            gameState.PlayExplotion(a.getCenter());
            a.destroid();
            return;
        }

        if ( b instanceof Player && a instanceof Asteroid) {
            gameState.PlayExplotion(a.getCenter());
            b.destroid();
            return;
        }

        // Láser (no UFO) golpea UFO
        if (a instanceof Laser && b instanceof UFO && !((Laser) a).isUFO()) {
            gameState.PlayExplotion(b.getCenter());
            a.destroid();
            b.destroid();
            return;
        }

        if (b instanceof Laser && a instanceof UFO && !((Laser) b).isUFO()) {
            gameState.PlayExplotion(a.getCenter());
            a.destroid();
            b.destroid();
            return;
        }

        // Asteroide colisiona con algo que no sea otro asteroide o UFO
        if (a instanceof Asteroid && !(b instanceof Asteroid) && !(b instanceof UFO) && !(a instanceof Shield)  && !(b instanceof Shield)) {
            gameState.PlayExplotion(b.getCenter());
            a.destroid();
            b.destroid();
            return;
        }

        if (b instanceof Asteroid && !(a instanceof Asteroid) && !(a instanceof UFO)) {
            gameState.PlayExplotion(a.getCenter());
            a.destroid();
            b.destroid();
        }
    }




    protected void destroid(){
        gameState.getMovingObjects().remove(this);
        if(!(this instanceof Laser )){
            explosion.play();
            explosion.changeVolume(-10);
        }
    }

    protected Vector2D getCenter() {
        return new Vector2D(position.getX() + width/2, position.getY() + height/2);
    }


    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

    }

    public Rectangle getBounds() {
        return new Rectangle((int) position.getX(), (int) position.getY(), width, height);
    }

}
