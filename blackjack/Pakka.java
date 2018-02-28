package blackjack;

import java.util.ArrayList;
import java.util.Collections;

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
        for (Kortti tKortti : this.pakka){
            korttiLista += "\n " + tKortti.toString();
        }
        return korttiLista;
    }
    
    public void poistaKortti(int i){
        this.pakka.remove(i);
    }
    
    public Kortti getKortti(int i){
        return this.pakka.get(i);
    }
    
    public void lisaaKortti(Kortti lisaaKortti){
        this.pakka.add(lisaaKortti);
    }
    
    public void hit(Pakka jakoPakasta){
        this.pakka.add(jakoPakasta.getKortti(0));
        jakoPakasta.poistaKortti(0);
    }
}
