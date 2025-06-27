package States;

import Auxx.ScoreFile;
import Main.WindowGame;
import Ui.Action;
import Ui.Button;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Graphics.Assets;
import Graphics.Text;
import Math.Vector2D;
import Graphics.Sound;

public class MenuState extends State {
    private ArrayList<Button> buttons;
    private Boolean print = true;
    private int highScore;
    private Sound menumusic;
    private GameState game;

    public MenuState() {
        buttons = new ArrayList<>();

        if (!Assets.menumusic.isRunning()) {
            menumusic = new Sound(Assets.menumusic);
            menumusic.loop();
            menumusic.changeVolume(-10);
        }

        // Leer el high score desde el archivo
        ScoreFile scoreFile = new ScoreFile();
        highScore = scoreFile.getScore();

        buttons.add(new Button(Assets.buttonBlue, Assets.buttonWhite,
                WindowGame.WIDTH / 2 - Assets.buttonWhite.getWidth() / 2-15,
                WindowGame.HEIGHT / 2 - Assets.buttonWhite.getHeight()+20,
                "PLAY", new Action() {
            @Override
            public void doAction() {

                if (Assets.menumusic.isRunning()) {
                    Assets.menumusic.stop();
                }
                game=null;
                State.changeState(game=new GameState());
            }
        }));



        /// //


        buttons.add(new Button(Assets.buttonBlue, Assets.buttonWhite,
                WindowGame.WIDTH / 2 - Assets.buttonWhite.getWidth() / 2-15,
                WindowGame.HEIGHT / 2 + Assets.buttonWhite.getHeight()+37-55,
                "INSTRUCTIONS", new Action() {
            @Override
            public void doAction() {
                State.changeState(new InstructionsState());
            }
        }));



        buttons.add(new Button(Assets.buttonBlue, Assets.buttonWhite,
                WindowGame.WIDTH / 2 - Assets.buttonWhite.getWidth() / 2-15,
                WindowGame.HEIGHT / 2 + Assets.buttonWhite.getHeight() / 2+120-45,
                "EXIT", new Action() {
            @Override
            public void doAction() {
                print = false;
                System.exit(0);
            }
        }));
    }

    @Override
    public void update() {
        for (Button b : buttons) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        int x = (WindowGame.WIDTH / 2);
        int y = WindowGame.HEIGHT / 3-50;

        Vector2D center = new Vector2D(x, y);

        if (print) {
            Text.drawText(g, "ASTEROIDS", center, true, new Color(0xe4fdff), Assets.fontTitle);

            Vector2D scorePos = new Vector2D(x, y + 85);
            //00c5ff
            Text.drawText(g, "HIGH SCORE: " + highScore, scorePos, true, new Color(0x00c5ff), Assets.fontsPunt);
        }

        for (Button b : buttons) {
            b.draw(g);
        }
    }
}
