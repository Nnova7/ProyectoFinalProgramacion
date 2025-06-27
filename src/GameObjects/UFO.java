package GameObjects;
import Auxx.Chronometer;
import Main.WindowGame;
import Math.Vector2D;
import States.GameState;
import Graphics.Assets;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Graphics.Sound;

public class UFO extends MovingObject {

    private ArrayList<Vector2D> path;
    private Vector2D currentNode;
    private int index;
    private Boolean following;
    public static final int NODERADIUS = 160;
    public static final double UFOMASS = 60;
    public static final int UFOMAXVEL = 3;
    public static final long FIRERATE = 1000;
    private Chronometer fireRate;
    private Sound shoot;
    public static boolean nopoints=false;


    public UFO(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState, ArrayList<Vector2D> path) {
        super(position, velocity, maxVel, texture, gameState);
        this.path = path;
        following = true;
        index = 0;
        fireRate = new Chronometer();
        fireRate.run(FIRERATE);
        shoot=new Sound(Assets.ufoShoot);
    }

    private Vector2D pathFollowing(){
        currentNode = path.get(index);
        double distanceToNode=currentNode.substract(getCenter()).getMagnitude();
        if(distanceToNode<NODERADIUS){
            index++;
            if(index>=path.size()){
                following = false;
            }
        }
        return seekForce(currentNode);
    }

    private Vector2D seekForce(Vector2D target){
        Vector2D desiredVelocity = target.substract(getCenter());
        desiredVelocity = desiredVelocity.normalize().scale(maxVel);
        return desiredVelocity.substract(velocity);
     }

    @Override
    public void update() {
        Vector2D pathFollowing;

        if(following){
            pathFollowing = pathFollowing();
        }else{
            pathFollowing = new Vector2D();
        }
        pathFollowing = pathFollowing.scale(1.0 / UFOMASS);
        velocity = velocity.add(pathFollowing);
        velocity=velocity.limit(maxVel);
        position = position.add(velocity);

        if(position.getX()> WindowGame.WIDTH || position.getX()<0 || position.getY()> WindowGame.HEIGHT || position.getY()<0){
            nopoints=true;
            destroid();
        }

        if(!fireRate.isRunning()){
            Vector2D toPlayer=gameState.getPlayer().getCenter().substract(getCenter());
            toPlayer=toPlayer.normalize();
            double currentAngle=toPlayer.getAngle();
            double newAngle = Math.random()*Math.PI/2-(Math.PI/2)/2;

            if(toPlayer.getX()<0){
                currentAngle=-currentAngle+Math.PI;
            }


            toPlayer=toPlayer.setDirection(currentAngle);

            Laser laser=new Laser(getCenter().add(toPlayer.scale(width)), toPlayer, 5, newAngle+Math.PI/2, Assets.laserUFO, gameState, this, true);
            gameState.getMovingObjects().add(0,laser);
            fireRate.run(FIRERATE);
            shoot.play();
            shoot.changeVolume(-5);

        }

        angle+=0.05;
        collideswith();
        fireRate.update();
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        transform= AffineTransform.getTranslateInstance(position.getX(), position.getY());
        transform.rotate(angle, width/2, height/2);
        g2d.drawImage(texture, transform, null);
    }

    @Override
    public void destroid(){
        if(!nopoints){
            gameState.addScore(100, position);
        }
        super.destroid();
        nopoints=false;
    }
}
