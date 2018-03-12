package JOptionPaneBlackJack;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Kontrolleri {

    // kapseloidut ominaisuudet
    private Naytto naytto;
    private Rahat rahat;
    private Chipit chipit;
    private Pakka pakka;
    private Pakka pelaaja;
    private Pakka jakaja;

    // luodaan tarvittavat komponentit ja käynnistetään sovellus
    public void kaynnistaMvcSovellus() {

        // luodaan sovelluksen tarvitsemat muut komponentit
        rahat = new Rahat(500);
        chipit = new Chipit(0);
        naytto = new Naytto();
        // välitetään näytölle tieto sovelluksen kontrollerista eli
        // tämä komponentti itse (this).
        naytto.rekisteroiOhjain(this);

        // pyydetään näyttöä esittämään aloitusnäyttö
        naytto.aloitusNaytto();
    }

    public void pelaa() {
        // pyydetään Model-kerrokselta chippien määrä
        int chipMaara = chipit.getSaldo();
        String vastaus;
        int valinta = 0;

        if (chipMaara > 0) {

            vastaus = naytto.kysyTieto("Sinulla on " + chipMaara + " chippiä. \n"
                    + "Syötä kuinka paljon haluat asettaa panokseksi.");
            int panos = Integer.parseInt(vastaus);

            if (panos <= chipMaara) {
                chipit.vahenna(panos);

                pakka = new Pakka();
                pakka.taysPakka();
                pakka.sekoita();

                jakaja = new Pakka();
                jakaja.hit(pakka);

                pelaaja = new Pakka();
                pelaaja.hit(pakka);
                pelaaja.hit(pakka);

                if (pelaaja.korttienPisteet() == 21) {
                    jakaja.hit(pakka);
                    if (jakaja.korttienPisteet() == 21) {
                        chipit.lisaa(panos);
                        naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                                + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                + "\n\nPelaajan käsi: " + pelaaja.toString()
                                + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                + "\n\n\nSekä pelaaja että jakaja saivat BlackJackin: tasapeli!"
                                + "\nSait " + panos + " chippiäsi takaisin. ");
                    } else {
                        chipit.lisaa(panos * 3);
                        naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                                + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                + "\n\nPelaajan käsi: " + pelaaja.toString()
                                + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                + "\n\n\nSait BlackJackin!"
                                + "\nVoitit panoksesi kolminkertaisena: " + panos * 3 + " chippiä!");
                    }
                } else {
                    do {
                        if (pelaaja.korttienPisteet() <= 21) {
                            valinta = naytto.otatkoKortin("Jakajan käsi: " + jakaja.toString()
                                    + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                    + "\n\nPelaajan käsi: " + pelaaja.toString()
                                    + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                    + "\n\n\nHaluatko ottaa ottaa kortin lisää "
                                    + "\nvai jäädä nykyisiin kortteihin? ");

                            switch (valinta) {
                                case 0:
                                    pelaaja.hit(pakka);
                                    break;
                                case 1:

                                    do {
                                        jakaja.hit(pakka);
                                    } while (jakaja.korttienPisteet() < 16);
                                    if ((jakaja.korttienPisteet() > 21)) {
                                        chipit.lisaa(panos * 2);
                                        naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                                                + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                                + "\n\nPelaajan käsi: " + pelaaja.toString()
                                                + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                                + "\n\n\nJakajan korttien arvo ylitti 21. "
                                                + "\nVoitit " + panos * 2 + " chippiä! ");
                                    } else if (jakaja.korttienPisteet() == pelaaja.korttienPisteet()) {
                                        chipit.lisaa(panos);
                                        naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                                                + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                                + "\n\nPelaajan käsi: " + pelaaja.toString()
                                                + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                                + "\n\n\nKorttien arvot ovat samat: tasapeli!"
                                                + "\nSait " + panos + " chippiäsi takaisin. ");
                                    } else if (jakaja.korttienPisteet() > pelaaja.korttienPisteet()){
                                        naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                                                + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                                + "\n\nPelaajan käsi: " + pelaaja.toString()
                                                + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                                + "\n\n\nJakajan korttien arvo on suurempi, hävisit pelin. "
                                                + "\nMenetit " + panos + " chippiä.");
                                    } else {
                                        chipit.lisaa(panos * 2);
                                        naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                                                + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                                + "\n\nPelaajan käsi: " + pelaaja.toString()
                                                + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                                + "\n\n\nKorttiesi arvo on suurempi, kuin jakajan. "
                                                + "\nVoitit " + panos * 2 + " chippiä.");
                                    }
                            }
                        } else {
                            naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                                    + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                    + "\n\nPelaajan käsi: " + pelaaja.toString()
                                    + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                    + "\n\n\nKorttiesi arvo ylitti 21, hävisit pelin. "
                                    + "\nMenetit " + panos + " chippiä.");
                            valinta++;
                        }

                    } while (valinta == 0);

                }
            } else {
                naytto.naytaViesti("Valitettavasti sinulla ei ole niin paljon chippejä. ");
            }
        } else {
            naytto.naytaViesti("Valitettavasti sinulla ei ole yhtään chippejä. ");
        }

        // peli päätyi, pyydetään näyttöä siirtymään aloitusnäyttöön
        naytto.aloitusNaytto();
    }

    // näytöltä tulevia pyyntöjä
    public void saldo() {
        // pyydetään Model-kerrokselta tietoa.
        int rahaMaara = rahat.getSaldo();
        int chipMaara = chipit.getSaldo();
        // pyydetään näyttöä esittämään saatu tieto
        naytto.naytaViesti("Sinulla on " + rahaMaara + " euroa ja " + chipMaara + " chippiä.");
        // pyydetään näyttöä esittämään aloitusnäyttö
        naytto.aloitusNaytto();
    }

    public void kassa() {
        String vastaus;
        // pyydetään Model-kerrokselta tietoa.
        int rahaMaara = rahat.getSaldo();
        int chipMaara = chipit.getSaldo();

        if (naytto.kassalla("Sinulla on " + rahaMaara + " euroa ja " + chipMaara + " chippiä.\n\n"
                + "Haluatko vaihtaa euroja chipeiksi vai chippejä euroiksi?\n") == 0) {
            if (rahaMaara > 0) {
                vastaus = naytto.kysyTieto("Syötä, kuinka paljon haluat muuttaa rahojasi chipeiksi. ");
                int rahamuunnos = Integer.parseInt(vastaus);

                if (rahamuunnos <= rahaMaara) {
                    rahat.vahenna(rahamuunnos);
                    chipit.lisaa(rahamuunnos);
                    naytto.naytaViesti("Muunnos onnistui. ");
                } else {
                    naytto.naytaViesti("Valitettavasti sinulla ei ole tarpeeksi rahaa. ");
                }
            } else {
                naytto.naytaViesti("Valitettavasti sinulla ei ole yhtään rahaa. ");
            }
        } else {
            if (chipMaara > 0) {
                vastaus = naytto.kysyTieto("Syötä, kuinka paljon haluat muuttaa chippejäsi rahaksi. ");
                int chipmuunnos = Integer.parseInt(vastaus);

                if (chipmuunnos <= chipMaara) {
                    chipit.vahenna(chipmuunnos);
                    rahat.lisaa(chipmuunnos);
                    naytto.naytaViesti("Muunnos onnistui. ");
                } else {
                    naytto.naytaViesti("Valitettavasti sinulla ei ole tarpeeksi chippejä. ");
                }
            } else {
                naytto.naytaViesti("Valitettavasti sinulla ei ole yhtään chippejä. ");
            }
        }

        // siirrytään aloitusnäyttöön
        naytto.aloitusNaytto();
    }
    
    
    public void lopetus() throws FileNotFoundException {
        int rahaMaara = rahat.getSaldo();
        int chipMaara = chipit.getSaldo();

        HighScore highscore;
        highscore = new HighScore();
        highscore.initialize();

        int score = rahaMaara * 10;              // score formula
        if (score >= 5100) {
            String nimi = JOptionPane.showInputDialog("Mikä on sinun nimesi?");

            highscore.checkHighScore(score, nimi);  // katso onko score hyvä 
        }

        naytto.naytaViesti("Poistut kasinolta taskussasi \n"
                + rahaMaara + " euroa ja " + chipMaara + " chippiä.");
        highscore.showHighScore();       // näytä kaikki scoret  
        // tämä metodi lopettaa koko sovelluksen toiminnan.
        System.exit(0);
    }

    // Koko sovelluksen käynnistäminen
    public static void main(String[] args) {
        // luodaan uusi kontrolleri-olio, ja
        // kutsutaan samalla sovelluksen käynnistää metodia.
        new Kontrolleri().kaynnistaMvcSovellus();

    }
}
