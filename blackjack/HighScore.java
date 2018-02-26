package blackjack;

import java.util.*;

/*
Tämä luoka tallenaa nimit ja highscoret
 */

 /*
 *@author Vladimir,Merja,Ville,Nicolas
 */
public class HighScore {

  private ArrayList<Integer> TopTen = new ArrayList(10);  
  private ArrayList<String> TopTen_nimet = new ArrayList(10);

  public void setHighScore(int index, int hscore) {
    TopTen.add(index, hscore);
  }

  public void setHighScoreName(int index, String name) {
    TopTen_nimet.add(index, name);
  }

  public int getHighScore(int index) {
    return TopTen.get(index);
  }

  public void checkHighScore(int hscore, String nimi) {
    for (int i = 0; i > -1; i++) {
      if (hscore > TopTen.get(i)) {
        TopTen.add(i, hscore);
        TopTen_nimet.add(i, nimi);

        i = -2;
      }
    }
  }

  /* The following fills the arrays so out of bound errors do not occur */
  public void initialize() {
    TopTen.add(0, 10000);
    TopTen_nimet.add(0, "Julius Caesar");
    TopTen.add(1, 9000);
    TopTen_nimet.add(1, "Augustus");
    TopTen.add(2, 8000);
    TopTen_nimet.add(2, "Tiberius");
    TopTen.add(3, 7000);
    TopTen_nimet.add(3, "Caligula");
    TopTen.add(4, 6000);
    TopTen_nimet.add(4, "Cladius");
    TopTen.add(5, 6000);
    TopTen_nimet.add(5, "Nero");
    TopTen.add(6, 6000);
    TopTen_nimet.add(6, "Galba");
    TopTen.add(7, 5500);
    TopTen_nimet.add(7, "Otho");
    TopTen.add(8, 5400);
    TopTen_nimet.add(8, "Vitellius");
    TopTen.add(9, 5000);
    TopTen_nimet.add(9, "Vespasian");
  }

  public void showHighScore() {
    for (int i = 0; i < 10; i++) {
      System.out.println(" " + TopTen_nimet.get(i) + "\t" + TopTen.get(i));
    }

  }
}
