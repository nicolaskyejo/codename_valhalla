package JOptionPaneBlackJack;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 *@author Merja
 */
public class PelinSaannot {

    public PelinSaannot() {

    }

    private String saannot;

    public void kerrosaannot() {
        String msg = "<html><b>PELIN YLEISET OHJEET</b><br>"
                + "Tullessasi kasinolle sinulla on mukanasi 500 euroa. <br>"
                + "Voidaksesi pelata, sinun pitää vaihtaa osa rahoistasi <br>"
               + "<font color=#cc0052 ><i>chipeiksi.</i></font> Chipit ovat kasinon peleissä käytettävä valuutta. <br>"
                + "Valuutan vaihto tapahtuu Kassalla. <br><br>"
                + " <b>    BLACKJACK-PELIN SÄÄNNÖT </b><br>"
                + "Pelin alussa pelaaja asettaa haluamansa panoksen. <br><br>" 
                + "Jakaja saa yhden kortin ja pelaaja <font color=#cc0052 >kaksi korttia. </font>Pelaaja <br>"
                + "pyrkii saamaan korteillaan suuremman summan kuin jakaja,<br>"
                + "mutta <font color=#cc0052 >korttien summa ei saa ylittää 21:tä.</font> Numerokorttien <br>"
                + "(2-10) arvot ovat 2-10. Kuvakorttien arvo on 10. <font color=#cc0052 >Ässän arvo<br>"
                + "on 1 tai 11</font> pelaajan edun mukaan.<br><br>" 
                + "Pelaaja voi pyytää yhden kortin kerrallaan lisää, niin monta<br>"
                + "kertaa kuin haluaa -  tai tyytyä saamiinsa kahteen korttiin.<br>"
                + "Kun pelaaja ei enää pyydä kortteja, jakaja ottaa kortteja, <br>"
                + "kunnes hänen korttiensa summa on vähintään 16.<br>  <br>" 
                + "Peli päättyy, jos pelaajan korttien summa ylittää 21 tai kun<br>"
                + "jakaja on saanut summaksi vähintään 16. <font color=#cc0052 >Jos pelaajan kahden<br>"
                + "ensimmäisen kortin summa on 21, kyseessä on ”BlackJack”,  <br>"
                + "ja hän voittaa panoksensa 3-kertaisena</font> - ellei jakajakin saa <br>"
                + "BlackJackiä kahdella ensimmäisellä kortilla,jolloin tilanne <br>"
                + "on tasapeli. <br><br>"
                + "Pelin päättyessä pelaaja, jonka korttien summa on suurempi,  <br>"
                + "voittaa. Kun summat ovat samat, on tulos tasapeli.<br>"
               + "Pelaajan voittaessa hän saa panoksensa kaksinkertaisena  <br>"
                + "takaisin. Hävitessään hän menettää panoksensa. Pelaajan ja <br>"
                + "jakajan tasatilanteessa pelaaja saa panoksensa takaisin. </body > < / html >";
        JLabel message = new JLabel(msg);
        message.setFont(new Font("Tahoma", Font.PLAIN, 16));
        message.setForeground(new Color(0x2F2D2D));
        JOptionPane.showMessageDialog(null, message, "Peliohjeet", JOptionPane.PLAIN_MESSAGE);
    }
}