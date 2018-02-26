package blackjack;

import java.util.*;
import javax.swing.*;

/*
 *@author Nicolas
 */
public class test {

  public static void main(String[] args) {

    // Muutujat
    String vastaus;
    HighScore test = new HighScore();

    test.initialize();
    /*
    test.setHighScore(9, 0);
    test.setHighScoreName(9, "paska");
    System.out.println(""+test.getHighScore(9));
    //test.checkHighScore(7100, "paska");
int score = 8000;
    for (int i = 9; i < 0; i--) {
      if (score > test.getHighScore(i)) {
        test.setHighScore(i, score);
        test.setHighScoreName(i, "paska");   
        
    }
      i = 0;
    }
     */
    int score = 8000;
    //test.checkHighScore(score, "paska");

    test.showHighScore();

  }
}
