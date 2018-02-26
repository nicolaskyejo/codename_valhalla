package blackjack;

/**
 *
 * @author ville
 */
public class Kortti {
    
    private final Maa maa;
    private final Arvo arvo;
    
    public Kortti (final Maa maa, final Arvo arvo){
        this.maa = maa;
        this.arvo = arvo;
    }
    
    @Override
    public String toString(){
        return this.maa + " " + this.arvo;
    }
}
