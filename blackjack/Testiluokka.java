package blackjack;

/**
 *
 * @author ville
 */
public class Testiluokka {
    public static void main(String[] args) {
        
        Pakka peliPakka = new Pakka();
        peliPakka.taysPakka();
        peliPakka.sekoita();
        
        System.out.println(peliPakka);
    }
}
