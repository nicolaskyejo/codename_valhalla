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
        
        //System.out.println(peliPakka);
        
        Pakka pelaaja = new Pakka();
        
        pelaaja.hit(peliPakka);
        pelaaja.hit(peliPakka);
        
        System.out.println("Pelaajan käsi: " + pelaaja.toString());
        
        Pakka jakaja = new Pakka();
        
        jakaja.hit(peliPakka);
        jakaja.hit(peliPakka);
        
        System.out.println("Jakajan käsi: " + jakaja.toString());
    }
}
