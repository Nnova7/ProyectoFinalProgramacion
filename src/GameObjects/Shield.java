package GameObjects;

import Main.WindowGame;
import States.GameState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import Math.Vector2D;

public class Shield extends MovingObject {
    public static boolean ON=false;


    public Shield(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState) {
        super(position, velocity, maxVel, texture, gameState);
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        transform= AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, transform, null);
    }

    @Override
    public void update() {
        // Se puede mover si lo deseas, pero no hace falta hacer nada aquí
    }


    //Se genera en spawnshield (Game object) cada nuevo nivel
}
