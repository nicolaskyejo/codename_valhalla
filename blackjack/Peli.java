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
  private int arvo;

  Chips lompakko = new Chips();                   // Olliot Chips.java luokalta
  Chips vaihdetutChipit = new Chips();

  public String Alus() {

    JOptionPane.showMessageDialog(null, "This is a blackjack game."
            + " The aim of this game is to hit 21 also known as blackjack\nAll players start with 500€");
    vastaus = JOptionPane.showInputDialog("What is your player name?");
    return vastaus;

  }

  public void Raha_to_Chips() {
    JOptionPane.showMessageDialog(null, "Paljonko euroja haluat vaihtaa chipeiksi, ");
    vastaus = JOptionPane.showInputDialog("Anna euromäärä: ");
    arvo = Integer.parseInt(vastaus);

    vaihdetutChipit.setChipmaara(arvo);
    lompakko.vahenna(arvo);

    JOptionPane.showMessageDialog(null, "Sinulla on nyt chipejä " + vaihdetutChipit.getChipmaara() + " kappaletta");
    JOptionPane.showMessageDialog(null, "Ja kasinolompakkoosi jäi rahaa " + lompakko.getEuromaara() + " euroa.");
  }
}
