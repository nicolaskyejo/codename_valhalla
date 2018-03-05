package JOptionPaneBlackJack;

import java.util.*;
import javax.swing.JOptionPane;

/*
Tämä luoka tallenaa nimit ja highscoret
 */

 /*
 *@author nk
 */
public class HighScore {

  private ArrayList<Integer> TopTen = new ArrayList(10);
  private ArrayList<String> TopTen_nimet = new ArrayList(10);

  public void checkHighScore(int hscore, String nimi) {
    for (int i = 0; i < 9; i++) {
      if (hscore >= TopTen.get(i)) {
        this.TopTen.add(i, hscore);
        this.TopTen_nimet.add(i, nimi);

        i = 9;
      }
    }
  }

  /* The following fills the arrays so out of bound errors do not occur */
  public void initialize() {
    this.TopTen.add(0, 100000);
    this.TopTen_nimet.add(0, "Julius Caesar");
    this.TopTen.add(1, 90000);
    this.TopTen_nimet.add(1, "Augustus");
    this.TopTen.add(2, 80000);
    this.TopTen_nimet.add(2, "Tiberius");
    this.TopTen.add(3, 70000);
    this.TopTen_nimet.add(3, "Caligula");
    this.TopTen.add(4, 60000);
    this.TopTen_nimet.add(4, "Cladius");
    this.TopTen.add(5, 10000);
    this.TopTen_nimet.add(5, "Nero");
    this.TopTen.add(6, 8000);
    this.TopTen_nimet.add(6, "Galba");
    this.TopTen.add(7, 7000);
    this.TopTen_nimet.add(7, "Otho");
    this.TopTen.add(8, 6000);
    this.TopTen_nimet.add(8, "Vitellius");
    this.TopTen.add(9, 5000);
    this.TopTen_nimet.add(9, "Vespasian");
  }

  public void showHighScore() {
    StringBuilder kimba = new StringBuilder();        // helps to save all string output to one "string"
    for (int i = 0; i < 10; i++) {
      kimba.append(" \t" + TopTen_nimet.get(i) + "  \t" + TopTen.get(i) + "\n");
    }

    JOptionPane.showMessageDialog(null, kimba.toString(), "Hall of Fame", JOptionPane.INFORMATION_MESSAGE);
  }

}
