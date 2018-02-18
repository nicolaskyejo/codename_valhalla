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
  private ArrayList<Long> HighScore = new ArrayList(10);  // long koska highscore voila olla iso, ei tiedä viella
  // 10 koska Highscore

  public void Savename(String nimi) {
    this.nimi = nimi;
  }

  public void setHighScore(long hscore) {               // Add highscore, josakin pitää vertaa uusiHighscore ja top10 highscore
    HighScore.add(hscore);
  }

  public void getHighScore() {             //Printaa kaikki highscoret eli top10
    for (Long scores : HighScore) {
      System.out.println(scores);
    }
  }
}
