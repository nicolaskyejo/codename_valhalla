package JOptionPaneBlackJack;

import javax.swing.JOptionPane;
/*
 *@author Merja
 */
public class PelinSaannot {

  public PelinSaannot() {

  }

  private String saannot;

  public void kerrosaannot() {

    JOptionPane.showMessageDialog(null,
            "BLACKJACK-PELIN SÄÄNNÖT \n"
            + "Pelin alussa pelaaja asettaa haluamansa panoksen. \n" + "\n"
            + "Jakaja saa yhden kortin ja pelaaja kaksi korttia. Pelaaja \n"
            + "pyrkii saamaan korteillaan suuremman summan kuin jakaja,\n"
            + "mutta korttien summa ei saa ylittää 21:tä. Numerokorttien \n"
            + "(2-10) arvot ovat 2-10. Kuvakorttien arvo on 10. Ässän arvo\n"
            + "on 1 tai 11 pelaajan edun mukaan.\n" + "\n"
            + "Pelaaja voi pyytää yhden kortin kerrallaan lisää, niin monta\n"
            + "kertaa kuin haluaa -  tai tyytyä saamiinsa kahteen korttiin.\n"
            + "Kun pelaaja ei enää pyydä kortteja, jakaja ottaa kortteja, \n"
            + "kunnes hänen korttiensa summa on vähintään 16.  \n" + "\n"
            + "Peli päättyy, jos pelaajan korttien summa ylittää 21 tai kun\n"
            + "jakaja on saanut summaksi vähintään 16. Jos pelaajan kahden\n"
            + "ensimmäisen kortin summa on 21, kyseessä on ”BlackJack”,  \n"
            + "ja hän voittaa panoksensa 2,5-kertaisena - ellei jakajakin saa \n"
            + "BlackJackiä kahdella ensimmäisellä kortilla,jolloin tilanne \n"
            + "on tasapeli. \n" + "\n"
            + "Pelin päättyessä pelaaja, jonka korttien summa on suurempi,  \n"
            + "voittaa. Kun summat ovat samat, on tulos tasapeli.\n" + "\n"
            + "Pelaajan voittaessa hän saa panoksensa kaksinkertaisena  \n"
            + "takaisin. Hävitessään hän menettää panoksensa. Pelaajan ja \n"
            + "jakajan tasatilanteessa pelaaja saa panoksensa takaisin., \n", "Blackjack Saannot", JOptionPane.INFORMATION_MESSAGE);
  }
}
