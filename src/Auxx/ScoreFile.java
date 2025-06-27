package Auxx;

import States.GameState;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreFile {
    private int score = 0;

    public ScoreFile() {
        File file = new File("score.txt");
        if (!file.exists()) {
            try {
                FileWriter writer = new FileWriter(file);
                writer.write("0");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeScore(int newScore) {
        int currentHighScore = getScore();

        if (newScore > currentHighScore) {
            try {
                FileWriter myWriter = new FileWriter("score.txt");
                myWriter.write(String.valueOf(newScore));
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public int getScore() {
        try {
            File file = new File("score.txt");
            Scanner sc = new Scanner(file);

            if (sc.hasNextLine()) {
                score = Integer.parseInt(sc.nextLine().trim());
            }
            sc.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return score;
    }
}

