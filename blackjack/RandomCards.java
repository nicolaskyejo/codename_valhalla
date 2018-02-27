package blackjack;

import java.util.*;

/*
Tämä luoka deals with randomizing cards ja korti jakaminen
 */

 /*
 *@author Vladimir,Merja,Ville,Nicolas
 */
public class RandomCards {

  private int card;
  

  public int TakeOne() {
    Double temp = Math.random() * 53;
    card = temp.intValue();
    return card;
  }

  public enum Arvo {
    KAKSI,
    KOLME,
    NELJA,
    VIISI,
    KUUSI,
    SEITSEMAN,
    KAHDEKSAN,
    YHDEKSAN,
    KYMMENEN,
    JATKA,
    QUNINGATAR,
    KUNINGAS,
    ASSA
  }

  public enum Maa {
    HERTTA,
    RUUTU,
    RISTI,
    PATA
  }

  public static Arvo randomArvo() {
    return Arvo.values()[new Random().nextInt(Arvo.values().length)];
  }
  
  public static Maa randomMaa() {
    return Maa.values()[new Random().nextInt(Maa.values().length)];
  }

  public static void main(String[] args) {
  
    System.out.println(""+randomArvo() + "."+randomMaa());

}
}
