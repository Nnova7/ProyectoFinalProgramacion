package GameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Graphics.Assets;
import Graphics.Sound;
import Math.Vector2D;
import States.GameState;
import Ui.Action;

public class PowerUp extends MovingObject {

    private long duration;
    private Action action;
    private Sound powerUpPick;
    private BufferedImage typeTexture;

    public static final long POWER_UP_DURATION = 10000;
    public static final long POWER_UP_SPAWN_TIME = 8000;

    public PowerUp(Vector2D position, BufferedImage texture, Action action, GameState gameState) {
        super(position, new Vector2D(), 0, Assets.orb, gameState);

        this.action = action;
        this.typeTexture = texture;
        duration = 0;
        /// ///////////////////////////
        powerUpPick = new Sound(Assets.playerShoot);

    }

    void executeAction() {
        action.doAction();
        powerUpPick.play();
    }

    @Override
    public void update() {
        angle += 0.1;

        if(duration > POWER_UP_DURATION) {
            this.destroid();
        }

        collideswith();

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        transform = AffineTransform.getTranslateInstance(
                position.getX() + Assets.orb.getWidth()/2 - typeTexture.getWidth()/2,
                position.getY() + Assets.orb.getHeight()/2 - typeTexture.getHeight()/2);

        transform.rotate(angle,
                typeTexture.getWidth()/2,
                typeTexture.getHeight()/2);

        g.drawImage(Assets.orb, (int)position.getX(), (int)position.getY(), null);



        g2d.drawImage(typeTexture, transform, null);
    }

}