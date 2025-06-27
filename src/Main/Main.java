package Main;

import Auxx.Back;
import Graphics.Assets;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static
    void main(String[] argsz) {
        Back n = new Back(Assets.back);
        WindowGame windowGame = new WindowGame();
        windowGame.start();

    }//main

}//Class main
