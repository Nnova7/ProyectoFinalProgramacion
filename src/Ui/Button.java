package Ui;

import Input.MouseImput;
import java.awt.*;
import java.awt.image.BufferedImage;
import Graphics.Text;
import Math.Vector2D;
import Graphics.Assets;

public class Button {
    private BufferedImage mouseOutImg;
    private BufferedImage mouseInImg;
    private boolean mouseIn;
    private Rectangle boundingBox;
    private String text;
    private Action action;

    public Button(BufferedImage mouseOutImg, BufferedImage mouseInImg, int x, int y, String text, Action action) {
        this.mouseOutImg = mouseOutImg;
        this.mouseInImg = mouseInImg;
        this.text = text;
        this.action = action;
        this.boundingBox = new Rectangle(x, y, mouseOutImg.getWidth(), mouseOutImg.getHeight());
    }

    public void update() {
        mouseIn = boundingBox.contains(MouseImput.X, MouseImput.Y);

        if (mouseIn && MouseImput.MLB) {
            action.doAction();
        }
    }

    public void draw(Graphics g) {
        // Dibuja la imagen del botón dependiendo del estado del mouse
        if (mouseIn) {
            g.drawImage(mouseInImg, boundingBox.x, boundingBox.y, null);
        } else {
            g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y, null);
        }

        // Dibuja el texto centrado dentro del botón
        Vector2D center = new Vector2D(
                boundingBox.getX() + boundingBox.getWidth() / 2,
                boundingBox.getY() + boundingBox.getHeight() / 2
        );

        Text.drawText(g, text, center, true, Color.WHITE, Assets.fontslittle);
    }
}
