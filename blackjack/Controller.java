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
    long score;  // Luulen että score voisi ola raha mikä käytäjällä on jaljella x 10 es. 300€ x10 = 3000
    int raha;
    
    //  Oliot
    Peli peliobjeekti = new Peli();
    HighScore nimi_ja_score = new HighScore();

    // Beginning
    nimi = peliobjeekti.Alus();
    
    // Kaikki
    
    
    // End
   // score = raha * 10;
  }
}
