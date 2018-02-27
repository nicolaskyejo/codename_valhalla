package blackjack;

import java.util.*;
import javax.swing.*;

/*
 *@author Nicolas
 */
public class test {

  public static void main(String[] args) {

    // HighScore testi
    String vastaus;
    HighScore test = new HighScore();
    RandomCards testi = new RandomCards();

    test.initialize();
    
    int score = 5100;
    test.checkHighScore(score, "paska");
    test.showHighScore();
    
    System.out.println("\n");
    // RandomCards testi
    for (int i=0;i < 10;i++) {
      System.out.println(""+    testi.TakeOne());

    }
  }
}
