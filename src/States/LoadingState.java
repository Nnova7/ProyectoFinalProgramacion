package States;

import java.awt.*;
import Graphics.Assets;
import Main.WindowGame;
import Graphics.Text;
import Math.Vector2D;
import Graphics.Loader;

public class LoadingState extends State{
    public Thread loadingThread;
    private Text loadingText;
    private Font loadingFont;


    public LoadingState(Thread loadingThread){

        this.loadingThread=loadingThread;
        this.loadingThread.start();
        loadingFont=Loader.loadFont("/Rec/Fonts/m42.TTF", 15);
    }

    @Override
    public void update() {
        if(Assets.loaded){
            State.changeState(new MenuState());
            try {
                loadingThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        GradientPaint gradient=new GradientPaint(WindowGame.WIDTH/2-500/2,WindowGame.HEIGHT/2-50/2,Color.WHITE,WindowGame.WIDTH/2+500/2,WindowGame.HEIGHT/2+50/2,Color.cyan);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setPaint(gradient);
        float percentaje=Assets.count/Assets.MAX_COUNT;

        g2d.fillRect(WindowGame.WIDTH/2-500/2,WindowGame.HEIGHT/2-50/2, (int)(500*percentaje), 50);
        g2d.drawRect(WindowGame.WIDTH/2-500/2,WindowGame.HEIGHT/2-50/2, 500, 50);

        Text.drawText(g2d, "LOADING...", new Vector2D(WindowGame.WIDTH/2, WindowGame.HEIGHT/2), true, Color.WHITE, loadingFont);
    }
}
