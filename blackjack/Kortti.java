package blackjack;

/**
 *
 * @author ville
 */
public class Kortti {
    
    private final Maa maa;
    private final Arvo arvo;
    
    //jokaisella kortilla on maa sekä arvo
    public Kortti (final Maa maa, final Arvo arvo){
        this.maa = maa;
        this.arvo = arvo;
    }
    
    @Override
    public String toString(){
        return this.maa + " " + this.arvo;
    }
    
    //käytetään arvojen pisteyttämisessä
    public Arvo getArvo(){
        return this.arvo;
    }
}