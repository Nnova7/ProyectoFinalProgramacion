package GameObjects;

import java.awt.image.BufferedImage;

import Graphics.Assets;


public enum PowerUpTypes {
    SHIELD("SHIELD", Assets.orb);

    public String text;
    public BufferedImage texture;

    private PowerUpTypes(String text, BufferedImage texture){
        this.text = text;
        this.texture = texture;
    }
}