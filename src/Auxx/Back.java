package Auxx;import javax.swing.*;
import java.awt.*;

public class Back extends JPanel {
    private Image background;

    public Back(Image background) {
        this.background = background;
        setLayout(null); // para posicionamiento absoluto
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 800, 500, getWidth(), getHeight(), this);
    }
}
