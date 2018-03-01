package blackjack;

import java.util.*;
import javax.swing.*;

/*
Tämä on meijan kontrolleri mikä yhdistää kaikki luokat (MVC model)
Tässä on main method, toisissa luokassa ei ole main methodi.
 */

 /*
 *@author Vladimir,Merja,Ville,Nicolas
 */
public class Controller {

  public static void main(String[] args) {

    // Muutujat 
    String nimi;
    int score;
    int raha = 500;
    

    //  Oliot
    Peli peliobjeekti = new Peli();
    HighScore nimi_ja_score = new HighScore();
    
   

    // Beginning
    nimi = peliobjeekti.Alus();
    peliobjeekti.Raha_to_Chips();
    
    // Kaikki
    
    // End
    nimi_ja_score.initialize();
    // joku funktio mikä kastoo paljon raha on remaining
    score = raha * 10;   // score formula
    nimi_ja_score.checkHighScore(score, nimi);  // katso onko score hyvä 
    nimi_ja_score.showHighScore();       // näytä kaikki scoret
  }
}
