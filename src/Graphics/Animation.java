package Graphics;
import Math.Vector2D;

import java.awt.image.BufferedImage;

public class Animation {
    private BufferedImage frames[];
    private int velocity;
    private boolean running;
    private int index;
    private Vector2D position;
    private long time, lastTime;

    public Animation(BufferedImage[] frames, int velocity, Vector2D position) {
        this.frames = frames;
        this.velocity = velocity;
        this.position = position;
        index = 0;
        lastTime = System.currentTimeMillis();
        running = true;
        time=0;
    }

    public BufferedImage[] getFrames() {
        return frames;
    }

    public boolean isRunning() {
        return running;
    }

    public Vector2D getPosition() {
        return position;
    }

    public BufferedImage getFrame() {
        return frames[index];
    }

    public void update(){
        time+=System.currentTimeMillis()-lastTime;
        lastTime = System.currentTimeMillis();

        if(time>=velocity){
            index++;
            time=0;
            if(index==frames.length){
                running =false;
            }
        }
    }


}
