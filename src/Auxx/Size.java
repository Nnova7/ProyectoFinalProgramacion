package Auxx;

import Graphics.Assets;

import java.awt.image.BufferedImage;

public enum Size {
    BIG(2, Assets.meds, 20), MED(2, Assets.smalls, 50), SMALL(2, Assets.tinies, 100);

    public int quantity;
    public BufferedImage[] textures;
    public int points;

    private Size(int quantity, BufferedImage[] textures, int points) {
        this.quantity = quantity;
        this.textures = textures;
        this.points = points;
    }
}
