package blackjack;

import java.util.*;
import javax.swing.*;

/*

 */

 /*
 *@author Vladimir,Merja,Ville,Nicolas
 */
public class PelajaKasi {
  
  //esittelen ArrayList rakenteen
  ArrayList<Integer> kortit; // Integer - ens, toinen kortti ja ...
  
  //luodaan ArrayList-rakenne
  kortit = new ArrayList();
  
  //konstruktori ominaisuus
  PelajaKasi() {
    int ens = RandomCards.getKortti();
    int toinen = RandomCards.getKortti();
  
  //lisään rakennteeseen oletukseksi 2 kortit
    kortit.add(ens);
    kortit.add(toinen);
  }
  
  //kortit summa
  int summa = 0;
  public void pelajaSumma() {
   for (int i = 0; i < kortit.size(); i++) {
    summa = summa + kortit.get(i);
   }
   
  }

  public void nayta() {
    if (pelajaSumma > 21) {
     //ei palauttaa mitään
    } else {
     kortit.add(kortit.get(kortit.size()) + 1, RandomCards.getKortti());
     }
   }
     


}
