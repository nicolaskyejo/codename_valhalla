package blackjack;

import java.util.ArrayList;

/**
 *
 * @author ville
 */
public class Pakka {
    public static void main(String[] args) {
        
    }
    private ArrayList<Kortti> pakka = new ArrayList<>();
    
    public Pakka(){
        
        for ( Maa maa: Maa.values()){
            for ( Arvo arvo: Arvo.values()){
                pakka.add (new Kortti (maa, arvo));
            }
        }
    }
    
    
}
