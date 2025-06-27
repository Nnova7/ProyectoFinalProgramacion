package States;

import Auxx.Chronometer;
import Auxx.Size;
import GameObjects.*;
import Input.KeyBoard;
import Main.WindowGame;
import Math.Vector2D;
import Graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import Auxx.ScoreFile;

import Graphics.Animation;
import Graphics.Text;
import Graphics.Sound;

public class GameState extends State {
    private Player player;
    private int meteors;
    public static ArrayList<MovingObject> movingObjects = new ArrayList<>();
    public static final double METEORVELOCITY = 2;
    private ArrayList<Animation> explotions = new ArrayList<>();
    public static int score;
    private int waves = 1;
    private ArrayList<Message> messages = new ArrayList<>();
    private Sound backgroundMusic;
    private long gameOverTime;
    private boolean gameOverHandled = false;
    private ScoreFile scoreFile = new ScoreFile();

    // Para controlar el escudo mejor que con Thread.sleep, usa Chronometer:
    private boolean shielded = false;
    private Chronometer shieldTimer = new Chronometer();

    public GameState() {
        player = new Player(new Vector2D(450, 250), new Vector2D(), 4, Assets.player, this);
        movingObjects.add(player);
        meteors = 4;
        WindowGame.lives = 3;
        score = 0;
        waves = 1;
        startWave();
        backgroundMusic = new Sound(Assets.backgraundMusic);
        backgroundMusic.loop();
        backgroundMusic.changeVolume(-10);
    }

    public void addScore(int score, Vector2D pos) {
        this.score += score;
        messages.add(new Message(pos, true, "+" + score + " SCORE", new Color(0xe4fdff), false, Assets.fontsmed, this));
    }

    private void startWave() {
        messages.add(new Message(new Vector2D(WindowGame.WIDTH / 2, WindowGame.HEIGHT / 2), true,
                "LEVEL " + waves, new Color(0xe4fdff), true, Assets.fontsbig, this));

        double x, y;
        for (int i = 0; i < meteors; i++) {
            x = i % 2 == 0 ? Math.random() * WindowGame.WIDTH : 0;
            y = i % 2 == 0 ? 0 : Math.random() * WindowGame.HEIGHT;

            BufferedImage texture = Assets.bigs[(int) (Math.random() * Assets.bigs.length)];

            movingObjects.add(new Asteroid(
                    new Vector2D(x, y),
                    new Vector2D(0, 1).setDirection(Math.random() * Math.PI),
                    METEORVELOCITY * Math.random() + 1,
                    texture,
                    this,
                    Size.BIG
            ));
        }
        waves++;
        meteors += 2;
        if (meteors > 12) {
            meteors = 12;
        }


        //spawnUfo();
        spawnShield();
    }

    public Player getPlayer() {
        return player;
    }

    public void stopGame() {
        scoreFile.writeScore(score);
        Player.gameOver = false;
        backgroundMusic.stop();
        movingObjects.clear();
        State.changeState(new MenuState());
    }

    private boolean negative=false;

    public void update() {
        if (WindowGame.lives <= 0 && !gameOverHandled) {
            Player.gameOver = true;
            gameOverTime = System.currentTimeMillis();
            gameOverHandled = true;
        }

        if (Player.gameOver && gameOverHandled) {
            if (System.currentTimeMillis() - gameOverTime >= 2000) {
                stopGame();
                return;
            }
        }

        // Actualizar animaciones y remover las que ya no están corriendo
        for (int i = 0; i < explotions.size(); i++) {
            Animation animation = explotions.get(i);
            animation.update();
            if (!animation.isRunning()) {
                explotions.remove(i);
                i--; // Ajustar índice tras remover
            }
        }

        // Actualizar objetos en movimiento
        for (int i = 0; i < movingObjects.size(); i++) {
            movingObjects.get(i).update();
        }

        // Si no hay asteroides vivos, inicia la siguiente ola
        boolean hasAsteroids = false;
        for (MovingObject mo : movingObjects) {
            if (mo instanceof Asteroid) {
                hasAsteroids = true;
                break;
            }
        }
        if (!hasAsteroids) {
            startWave();
            negative =false;
        }
        if(movingObjects.size() < 3 && !negative) {
            spawnUfo();
            negative=true;
        }
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        for (Message message : new ArrayList<>(messages)) {
            message.draw(g2d);
        }

        for (MovingObject mo : new ArrayList<>(movingObjects)) {
            mo.draw(g);
        }

        for (Animation animation : new ArrayList<>(explotions)) {
            g2d.drawImage(animation.getFrame(), (int) animation.getPosition().getX(),
                    (int) animation.getPosition().getY(), null);
        }


        if (Player.gameOver) {
            Vector2D center = new Vector2D(WindowGame.WIDTH / 2, (WindowGame.HEIGHT / 3) + 50);
            Text.drawText(g, "GAME OVER", center, true, Color.white, Assets.fontsbig);
        }

        drawScore(g);
        drawLives(g);
    }

    private void drawScore(Graphics g) {
        Vector2D pos = new Vector2D(1100, 25);
        String scoreToString = Integer.toString(score);
        for (int i = 0; i < scoreToString.length(); i++) {
            g.drawImage(Assets.numbers[Integer.parseInt(scoreToString.substring(i, i + 1))], (int) pos.getX(), (int) pos.getY(), null);
            pos.setX(pos.getX() + 20);
        }
    }

    private void drawLives(Graphics g) {
        if (WindowGame.lives < 1)
            return;
        Vector2D livepos = new Vector2D(25, 25);
        g.drawImage(Assets.vida, (int) livepos.getX(), (int) livepos.getY(), null);
        g.drawImage(Assets.numbers[10], (int) livepos.getX() + 40, (int) livepos.getY() + 5, null);

        String livesToString = Integer.toString(WindowGame.lives);
        Vector2D pos = new Vector2D(livepos.getX(), livepos.getY());

        for (int i = 0; i < livesToString.length(); i++) {
            int number = Integer.parseInt(livesToString.substring(i, i + 1));
            if (number <= 0)
                break;
            g.drawImage(Assets.numbers[number], (int) pos.getX() + 60, (int) pos.getY() + 5, null);
            pos.setX(pos.getX() + 20);
        }
    }

    public boolean substractLife() {
        WindowGame.lives--;
        return WindowGame.lives > 0;
    }

    public void divideAsteroid(Asteroid asteroid) {
        Size size = asteroid.getSize();
        BufferedImage[] texture = size.textures;
        Size newSize = null;

        switch (size) {
            case BIG:
                newSize = Size.MED;
                break;
            case MED:
                newSize = Size.SMALL;
                break;
            default:
                return;
        }

        for (int i = 0; i < size.quantity; i++) {
            movingObjects.add(new Asteroid(
                    asteroid.getPosition(),
                    new Vector2D(0, 1).setDirection(Math.random() * Math.PI),
                    METEORVELOCITY * Math.random() + 1,
                    texture[(int) (Math.random() * texture.length)],
                    this,
                    newSize
            ));
        }
    }

    public void PlayExplotion(Vector2D position) {
        explotions.add(new Animation(Assets.exp, 25, position.substract(
                new Vector2D(Assets.exp[0].getWidth() / 2, Assets.exp[0].getHeight() / 2))));
    }

    private void spawnUfo() {
        int rand = (int) (Math.random() * 2);
        double x = rand == 0 ? Math.random() * WindowGame.WIDTH : 0;
        double y = rand == 0 ? 0 : Math.random() * WindowGame.HEIGHT;

        ArrayList<Vector2D> path = new ArrayList<>();

        double posX, posY;

        posX = Math.random() * WindowGame.WIDTH / 2;
        posY = Math.random() * WindowGame.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));

        posX = Math.random() * WindowGame.WIDTH / 2 + WindowGame.WIDTH / 2;
        posY = Math.random() * WindowGame.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));

        posX = Math.random() * WindowGame.WIDTH / 2;
        posY = Math.random() * WindowGame.HEIGHT / 2 + WindowGame.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));

        posX = Math.random() * WindowGame.WIDTH / 2 + WindowGame.WIDTH / 2;
        posY = Math.random() * WindowGame.HEIGHT / 2 + WindowGame.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));

        movingObjects.add(new UFO(new Vector2D(x, y), new Vector2D(), UFO.UFOMAXVEL, Assets.ufo, this, path));
    }

    private void spawnShield() {
        int rand = (int) (Math.random() * 2);
        double posX, posY;

        posX = Math.random() * WindowGame.WIDTH   ;
        posY = Math.random() * WindowGame.HEIGHT  ;
        Vector2D aux= new Vector2D(posX, posY);

        movingObjects.add(new Shield(aux, new Vector2D() , 0, Assets.orb, this));
    }

    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }

    public void setMovingObjects(ArrayList<MovingObject> movingObjects) {
        this.movingObjects = movingObjects;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

}