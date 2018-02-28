package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author ville
 */
public class Pakka {

    private ArrayList<Kortti> pakka;
    
    public Pakka(){
        this.pakka = new ArrayList<Kortti>();
    }
    //pakan täyttö
    public void taysPakka(){
        for ( Maa maa: Maa.values()){                   // jokainen maa yksi kerrallaan
            for ( Arvo arvo: Arvo.values()){            // maahan jokainen arvo yksi kerrallaan
                this.pakka.add(new Kortti (maa, arvo)); // uusi kortti lisätään pakkaan
            }
        } // for toisto tapahtuu kunnes jokainen arvo on käytetty jokaisella maalla
    }
    // pakan sekoitus
    public void sekoita(){
        Collections.shuffle(pakka);
    }
    
    @Override
    public String toString(){
        String korttiLista = "";
        int i = 0;
        for (Kortti tKortti : this.pakka){
            korttiLista += "\n" + i + " " + tKortti.toString();
            i++;
        }
        return korttiLista;
    }
}
