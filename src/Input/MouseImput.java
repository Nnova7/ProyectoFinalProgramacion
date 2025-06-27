package Input;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseImput extends MouseAdapter {
    public static int X, Y;
    public static Boolean MLB=false;

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            MLB=true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            MLB=false;
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        X=e.getX();
        Y=e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        X=e.getX();
        Y=e.getY();
    }
}
