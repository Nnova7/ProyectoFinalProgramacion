package Graphics;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage player;
    public static BufferedImage speedF1;
    public static BufferedImage speedF2;
    public static BufferedImage speedF3;
    public static BufferedImage laser;
    public static BufferedImage orb;
    public static BufferedImage laserUFO;
    public static BufferedImage back;
    public static BufferedImage ufo;
    public static BufferedImage vida;
    public static BufferedImage buttonBlue;
    public static BufferedImage buttonWhite;
    public static BufferedImage instructions;
    public static Clip backgraundMusic, explosion, playerLoose, playerShoot, ufoShoot, teletransport, menumusic;
    public static BufferedImage[] bigs = new BufferedImage[4];
    public static BufferedImage[] meds = new BufferedImage[2];
    public static BufferedImage[] smalls=  new BufferedImage[2];
    public static BufferedImage[] tinies = new BufferedImage[2];
    public static BufferedImage[] exp = new BufferedImage[9];
    public static BufferedImage[] numbers = new BufferedImage[11];
    public static boolean loaded=false;
    public static float count=0;
    public static float MAX_COUNT=535;

    public static Font fontsbig;
    public static Font fontsmed;
    public static Font fontTitle;
    public static Font fontsPunt;
    public static Font fontslittle;


    public static void init(){
        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        orb = loadImage("/Rec/orb.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        instructions = loadImage("/Rec/Menu.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);
        fontsPunt=loadFont("/Rec/Fonts/m42.TTF", 20);
        fontTitle=loadFont("/Rec/Fonts/titile.ttf", 125);

        menumusic=loadSound("/Rec/Sounds/menu.wav");
        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");

        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");


        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);
        fontslittle=loadFont("/Rec/Fonts/m42.TTF", 10);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");


        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");


        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");


        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");


        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");


        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");


        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");


        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");


        player = loadImage("/Rec/Nave.png");
        speedF1 = loadImage("/Rec/Effects/fire1.png");
        speedF2 = loadImage("/Rec/Effects/fire2.png");
        speedF3 = loadImage("/Rec/Effects/fire3.png");
        laser = loadImage("/Rec/Laser.png");
        laserUFO = loadImage("/Rec/LaserUFO.png");
        back = loadImage("/Rec/Background.png");
        ufo = loadImage("/Rec/UFO.png");
        vida = loadImage("/Rec/vida.png");
        buttonWhite = loadImage("/Rec/Ui/blueBotton.png");
        buttonBlue = loadImage("/Rec/Ui/whiteBotton.png");
        for(int i=1; i<=bigs.length; i++){
            bigs[i-1] = loadImage("/Rec/Asteroids/AsteroidBig"+i+".png");
        }
        for(int i=1; i<=meds.length; i++){
            meds[i-1] = loadImage("/Rec/Asteroids/AsteroidMed"+i+".png");
        }
        for(int i=1; i<=smalls.length; i++){
            smalls[i-1] = loadImage("/Rec/Asteroids/AsteroidSmall"+i+".png");
        }
        for(int i=1; i<=tinies.length; i++){
            tinies[i-1] = loadImage("/Rec/Asteroids/AsteroidTiny"+i+".png");
        }
        for(int i=1; i<=exp.length; i++){
            exp[i-1] = loadImage("/Rec/Explotion/"+i+".png");
        }
        for(int i=0; i<numbers.length; i++){
            numbers[i] = loadImage("/Rec/Numbers/"+i+".png");
        }

        //fonts
        fontsmed=loadFont("/Rec/Fonts/m42.TTF", 15);
        fontsbig=loadFont("/Rec/Fonts/m42.TTF", 42);

        backgraundMusic=loadSound("/Rec/Sounds/backgroundMusic.wav");
        explosion=loadSound("/Rec/Sounds/explosion.wav");
        playerLoose=loadSound("/Rec/Sounds/playerLoose.wav");
        playerShoot=loadSound("/Rec/Sounds/ufoShoot.wav");
        ufoShoot=loadSound("/Rec/Sounds/playerShoot.wav");
        teletransport=loadSound("/Rec/Sounds/teletransport.wav");




        loaded=true;
    }//only execute when the code initialice
    //Load resources (images, etc.)

    public static BufferedImage loadImage (String path){
        count++;
        return Loader.loadImage(path);
    }

    public static Font loadFont (String path, int size){
        count++;
        return Loader.loadFont(path, size);
    }

    public static Clip loadSound (String path){
        count++;
        return Loader.loadSound(path);
    }

}
