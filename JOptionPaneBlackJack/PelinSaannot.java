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
            + "Pelin alussa pelaaja asettaa haluamansa panoksen.\n" + "\n"
            + "Jakaja saa yhden kortin ja pelaaja kaksi korttia. \n"
            + "Pelaaja pyrkii saamaan korteillaan suuremman summan kuin jakaja,\n"
            + "mutta korttien summa ei saa ylittää 21:tä. \n"
            + "Numerokorttien (2-10) arvot ovat 2-10. Kuvakorttien arvo on 10.\n"
            + "Ässän arvo on 1 tai 11 pelaajan edun mukaan.\n" + "\n"
            + "Pelaaja voi pyytää yhden kortin kerrallaan lisää, \n"
            + "niin monta kertaa kuin haluaa -  tai tyytyä saamiinsa kahteen korttiin.\n"
            + "Kun pelaaja ei enää pyydä kortteja, jakaja ottaa kortteja, \n"
            + "kunnes hänen korttiensa summa on vähintään 16.  \n" + "\n"
            + "Peli päättyy, jos pelaajan korttien summa ylittää 21 \n"
            + "tai kun jakaja on saanut summaksi vähintään 16.\n"
            + "Jos pelaajan kahden ensimmäisen kortin summa on 21, \n"
            + "kyseessä on ”BlackJack”, ja hän voittaa panoksensa 2,5-kertaisena \n"
            + " - ellei jakajakin saa BlackJackiä kahdella ensimmäisellä kortilla,\n"
            + "jolloin tilanne on tasapeli. \n" + "\n"
            + "Pelin päättyessä pelaaja, jonka korttien summa on suurempi, voittaa. \n"
            + "Kun summat ovat samat, on tulos tasapeli.\n" + "\n"
            + "Pelaajan voittaessa hän saa panoksensa kaksinkertaisena takaisin. \n"
            + "Hävitessään hän menettää panoksensa. \n"
            + "Pelaajan ja jakajan tasatilanteessa pelaaja saa panoksensa takaisin.", "Blackjack Saannot", JOptionPane.INFORMATION_MESSAGE);
  }
}
