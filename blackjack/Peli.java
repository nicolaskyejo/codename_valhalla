package blackjack;

import javax.swing.*;

/*
Tämä on meijan peli grafiika, siis GUI tai View(MVC modeli)
 */

 /*
 *@author Vladimir,Merja,Ville,Nicolas
 */
public class Peli {

  private String vastaus;

  public String Alus() {

    JOptionPane.showMessageDialog(null, "This is a blackjack game."
            + " The aim of this game is to hit 21 also known as blackjack\nAll players start with 500€");
    vastaus = JOptionPane.showInputDialog("What is your player name?");
    return vastaus;
  }

}
