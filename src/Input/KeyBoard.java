package Input;

import GameObjects.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    private boolean[] keys = new boolean[256];
    public static boolean UP, LEFT, RIGHT, SHOOT, TELETRANSPORT;
    private Boolean upPressedPrev;
    private Boolean downPressedPrev;

    public KeyBoard() {
        UP = false;
        LEFT = false;
        RIGHT = false;
        SHOOT = false;
        TELETRANSPORT=false;
    }//constructor

    public void update() {
        UP=keys[KeyEvent.VK_UP];
        LEFT=keys[KeyEvent.VK_LEFT];
        RIGHT=keys[KeyEvent.VK_RIGHT];
        SHOOT= keys[KeyEvent.VK_Z];
        TELETRANSPORT= keys[KeyEvent.VK_X];

        if (TELETRANSPORT) {
            if (upPressedPrev == false) { upPressedPrev = true;
            }
        }
        else { upPressedPrev = true; }
        // Resetear toggle para que no lo repita



    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;


    }

    ////when a key is press, this method is call and the key is stored in the object
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}//keyboard class
