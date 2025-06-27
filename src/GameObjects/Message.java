package GameObjects;

import States.GameState;
import Math.Vector2D;

import java.awt.*;
import Graphics.Text;

public class Message {
    private GameState gameState;
    private float alpha;
    private String text;
    private Vector2D position;
    private Color color;
    private boolean center;
    private boolean fade;
    private Font font;
    private final float deltaAlpha = 0.01f;

    public Message(Vector2D position, boolean fade, String text, Color color, boolean center, Font font, GameState gameState) {
        this.position = position;
        this.fade = fade;
        this.text = text;
        this.color = color;
        this.center = center;
        this.font = font;
        this.gameState = gameState;

        if(fade)
            alpha = 1;
        else
            alpha = 0;
    }

    public void draw(Graphics2D g) {
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        Text.drawText(g, text, position,center, color , font);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

        position.setY(position.getY() -1);

        if(fade)
            alpha -=deltaAlpha;
        else
            alpha+=deltaAlpha;

        if(fade && alpha < 0 || !fade && alpha > 1){
            gameState.getMessages().remove(this);
        }


    }



}
