package blackjack;

import java.util.*;

/*
Tämä luoka tallenaa nimit ja highscoret
 */

 /*
 *@author Vladimir,Merja,Ville,Nicolas
 */
public class HighScore {

  private String nimi;
  private long score;
  private ArrayList<Long> TopTen = new ArrayList(10);  // long koska highscore voila olla iso, ei tiedä viella
  private ArrayList<String> TopTen_nimet = new ArrayList(10);

  public void setHighScore(int index, long hscore) {  // Add highscore to top10 if highscore on hyvää
    TopTen.add(index, hscore);
  }

  public void setHighScoreName(int index, String name) {
    TopTen_nimet.add(index, name);
  }

  public void checkHighScore() {
    for (int i = 10; i < 0; i--) {

    }

  }

  public void getHighScore() {             //Printaa kaikki highscoret eli top10
    for (Long scores : TopTen) {
      System.out.println(scores);
      for (String nimet : TopTen_nimet) {
        System.out.println(nimet);
      }
    }
  }
}
