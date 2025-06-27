package Main;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;

import Graphics.Assets;
import Input.KeyBoard;
import States.GameState;
import Auxx.Back;
import States.LoadingState;
import States.MenuState;
import States.State;
import Input.MouseImput;


public class WindowGame extends JFrame implements Runnable {
    public static final int WIDTH = 1200, HEIGHT=720;
    private Canvas canvas;
    private Thread thread;
    private Boolean running=false;
    private BufferStrategy bs;
    private Graphics g;
    private final int FPS=60;
    private double TARGETTIME=1000000000/FPS;
    private double delta=0;
    private int AVERAGEFPS=FPS;
    private KeyBoard keyBoard;
    public static int lives;
    private MouseImput mouseImput;

    public WindowGame(){
        setTitle("Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);//Center window on screen

        keyBoard=new KeyBoard();
        mouseImput=new MouseImput();

        //Create and configure canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true);//Allows it to receive input

        add(canvas);
        canvas.addKeyListener(keyBoard);
        canvas.addMouseListener(mouseImput);
        canvas.addMouseMotionListener(mouseImput);
        setVisible(true);
    }//constructor


    public void draw() {
        bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        //-----------------------
        // Primero dibuja la imagen de fondo
        if (Assets.back != null) {
            g.drawImage(Assets.back, 0, 0, WIDTH, HEIGHT, null);
        } else {
            // Si no hay imagen, pinta fondo negro
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }


        // Luego dibuja el resto del juego
        State.getCurrentState().draw(g);

        // Y dibuja el texto FPS
        g.setColor(Color.WHITE);

        g.dispose();
        bs.show();
    }

    private void update(float dt){
        keyBoard.update();
        State.getCurrentState().update();
    }


    @Override
    public void run() {

        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        init();

        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime)/TARGETTIME;
            time += (now - lastTime);
            lastTime = now;

            if(delta >= 1)
            {
                update((float) (delta * TARGETTIME * 0.000001f));
                draw();
                delta --;
                frames ++;
            }
            if(time >= 1000000000)
            {

                AVERAGEFPS = frames;
                frames = 0;
                time = 0;

            }


        }

        stop();
    }


    public void start(){

        running = true;
        thread = new Thread(this);
        thread.start();
    }


    public void stop(){

        try{
            thread.join();
            running=false;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void init(){
        Thread loadingTrhead=new Thread(new Runnable() {
            @Override
            public void run() {
                Assets.init();
            }
        });
        State.changeState(new LoadingState(loadingTrhead));
    }//Load resources (images, etc.)


}//Windows class
