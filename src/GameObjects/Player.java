package GameObjects;

import Auxx.Chronometer;
import Input.KeyBoard;
import Main.WindowGame;
import Math.Vector2D;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

import Graphics.Assets;
import States.GameState;
import Graphics.Sound;

public class Player extends MovingObject {
    private Vector2D heading;
    private Vector2D acceleration;
    private final double ACC = 0.1;
    public static final double DELTAANGLE = 0.1;
    private int aux = 1;
    private boolean accelerating = false;
    private Chronometer fireRate;
    public static final int FIRERATE = 300;
    private boolean visible;
    public static boolean spawing;
    private Chronometer spawTime, flockerTime;
    public static final long FLICKER_TIME = 200;
    public static final int SPAWING_TIME = 3000;
    private Sound shoot, loose, teletransport;
    public static boolean gameOver = false;
    public boolean invensible = false;
    private Chronometer invencibilityTimer;
    public static final long INVINCIBILITY_TIME = 5000; // 5 segundos

    public boolean isInvensible() {
        return invensible;
    }

    public void setInvensible(boolean invensible) {
        this.invensible = invensible;
    }

    public Player(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState) {
        super(position, velocity, maxVel, texture, gameState);
        heading = new Vector2D(0, 1);
        acceleration = new Vector2D();
        fireRate = new Chronometer();
        spawTime = new Chronometer();
        flockerTime = new Chronometer();
        shoot = new Sound(Assets.playerShoot);
        loose = new Sound(Assets.playerLoose);
        teletransport = new Sound(Assets.teletransport);
        invencibilityTimer = new Chronometer();
    }

    @Override
    public void update() {
        boolean auxx=false;
        if(spawTime.getTime()==5000){
            auxx=true;
        }
        if (!spawTime.isRunning()) {
            spawing = false;
            visible = true;
            auxx=false;
        }
        if (spawing) {
            if (!flockerTime.isRunning()) {
                visible = !visible;
            }
        }

        if (KeyBoard.SHOOT && !fireRate.isRunning() && (!spawing || auxx))
        {
            gameState.getMovingObjects().add(0,
                    new Laser(getCenter().add(heading.scale(width)), heading, 20, angle, Assets.laser, gameState, this,
                            false));
            fireRate.run(FIRERATE);
            shoot.play();
            shoot.getFramePosition();
            shoot.changeVolume(-5);
        }

        if (KeyBoard.TELETRANSPORT && !spawTime.isRunning()) {
            Random random = new Random();
            int x = random.nextInt((int) WindowGame.WIDTH);
            int y = random.nextInt((int) WindowGame.HEIGHT);
            setPosition(new Vector2D(x, y));
            teletransport.play();
            teletransport.changeVolume(-5);
        }

        if (KeyBoard.RIGHT)
            angle += DELTAANGLE;
        if (KeyBoard.LEFT) {
            angle -= DELTAANGLE;
        }
        if (KeyBoard.UP) {
            acceleration = heading.scale(ACC);
            accelerating = true;
        } else {
            if (velocity.getMagnitude() != 0) {
                acceleration = (velocity.scale(-1).normalize()).scale(ACC / 2);
            }
            accelerating = false;
        }
        velocity = velocity.add(acceleration);
        velocity = velocity.limit(maxVel);
        heading = heading.setDirection(angle - Math.PI / 2); // Java work with rad
        position = position.add(velocity);

        if (position.getX() > WindowGame.WIDTH) {
            position.setX(0);
        }
        if (position.getY() > WindowGame.HEIGHT) {
            position.setY(0);
        }

        if (position.getX() < 0) {
            position.setX(WindowGame.WIDTH);
        }
        if (position.getY() < 0) {
            position.setY(WindowGame.HEIGHT);
        }

        aux++;
        if (aux == 30) {
            aux = 1;
        }

        fireRate.update();
        spawTime.update();
        flockerTime.update();
        collideswith();

            collidesWithShield(); // ← al final del update


    }

    @Override
    public void destroid() {
        spawing = true;
        spawTime.run(SPAWING_TIME);
        loose.play();
        if (!gameState.substractLife()) {
            Player.gameOver = true;
            super.destroid();
        }
        resetValues();
    }

    @Override
    public void draw(Graphics g) {
        if (!visible) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;

        transform = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        transform.rotate(angle, Assets.player.getWidth() / 1.5, Assets.player.getHeight() / 1.5);

        if (accelerating) {
            AffineTransform atFlame = new AffineTransform(transform);
            atFlame.translate(-Assets.speedF1.getWidth() / 20, Assets.player.getHeight() - 25);

            if (aux >= 1 && aux < 10) {
                g2d.drawImage(Assets.speedF1, atFlame, null);
            } else if (aux >= 10 && aux < 20) {
                g2d.drawImage(Assets.speedF2, atFlame, null);
            } else if (aux >= 20 && aux <= 30) {
                g2d.drawImage(Assets.speedF3, atFlame, null);
            }
        }

        g2d.drawImage(Assets.player, transform, null);
    }

    public boolean isSpawing() {
        return spawing;
    }

    private void resetValues() {
        angle = 0;
        velocity = new Vector2D();
        position = new Vector2D(450, 250);
    }

    private void collidesWithShield() {
        for (GameObject obj : gameState.getMovingObjects()) {
            if (obj instanceof Shield) {
                if (getBounds().intersects(((Shield) obj).getBounds())) {
                    activateSpawingShield(); // ← activa el efecto
                    gameState.getMovingObjects().remove(obj); // elimina el shield al tocarlo
                    break;
                }
            }
        }
    }

    private void activateSpawingShield() {
        spawing = true;
        spawTime.run(5000);
        flockerTime.run(FLICKER_TIME);
        invencibilityTimer.run(INVINCIBILITY_TIME);
        invensible = true;
    }



}
