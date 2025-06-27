package States;

import Auxx.ScoreFile;
import Main.WindowGame;
import Ui.Action;
import Ui.Button;
import java.awt.*;
import java.awt.image.BufferedImage;
import Graphics.Assets;
import Graphics.Text;
import Math.Vector2D;

public class InstructionsState extends State {

    private Button boton;
    private BufferedImage background; // Fondo de 800x500

    public InstructionsState() {

        boton = new Button(Assets.buttonBlue, Assets.buttonWhite,
                WindowGame.WIDTH / 2 - Assets.buttonWhite.getWidth() / 2 - 15,
                WindowGame.HEIGHT / 2 - Assets.buttonWhite.getHeight() + 265,
                "RETURN", new Action() {
            @Override
            public void doAction() {
                State.changeState(new MenuState());
            }
        });
    }


    @Override
    public void update() {
        boton.update();
    }

    @Override
    public void draw(Graphics g) {
        // Dibujar imagen de fondo ajustada a 800x500
        g.drawImage(Assets.instructions, 0, 0, 1200, 720, null);

        // Dibujar el botón
        boton.draw(g);
    }
}
