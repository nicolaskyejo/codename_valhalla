package JOptionPaneBlackJack;

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

        do {

          if (pelaaja.korttienPisteet() <= 21) {

            vastaus = naytto.kysyTieto("Jakajan käsi: " + jakaja.toString()
                    + "\n Korttien arvo: " + jakaja.korttienPisteet()
                    + "\n\nPelaajan käsi: " + pelaaja.toString()
                    + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                    + "\n\n\nSyötä (1), jos haluat uuden kortin. "
                    + "\nSyötä (2), jos haluat lopettaa vuorosi. ");

            switch (vastaus) {
              case "1":
                pelaaja.hit(pakka);
                break;
              case "2":
                if (jakaja.korttienPisteet() <= pelaaja.korttienPisteet()
                        && jakaja.korttienPisteet() < 21) {
                  do {
                    jakaja.hit(pakka);
                  } while (jakaja.korttienPisteet() < pelaaja.korttienPisteet());
                  if ((jakaja.korttienPisteet() > 21)) {
                    chipit.lisaa(panos * 2);
                    naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                            + "\n Korttien arvo: " + jakaja.korttienPisteet()
                            + "\n\nPelaajan käsi: " + pelaaja.toString()
                            + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                            + "\n\n\nJakajan korttien arvo ylitti 21. "
                            + "\nVoitit " + panos + " chippiä! ");
                  } else if (jakaja.korttienPisteet() == pelaaja.korttienPisteet()) {
                    chipit.lisaa(panos);
                    naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                            + "\n Korttien arvo: " + jakaja.korttienPisteet()
                            + "\n\nPelaajan käsi: " + pelaaja.toString()
                            + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                            + "\n\n\nKorttien arvot ovat samat: tasapeli!"
                            + "\nSait " + panos + " chippiäsi takaisin. ");
                  } else {
                    naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                            + "\n Korttien arvo: " + jakaja.korttienPisteet()
                            + "\n\nPelaajan käsi: " + pelaaja.toString()
                            + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                            + "\n\n\nJakajan korttien arvo on suurempi, hävisit pelin. "
                            + "\nMenetit " + panos + " chippiä.");
                  }
                }
                break;
              default:
                naytto.naytaViesti("Jakaja ei pitänyt vastauksestasi.\n"
                        + "Sinut häädettiin pelipöydästä ja hävisit panoksesi.");
                break;
            }

          } else {
            naytto.naytaViesti("Jakajan käsi: " + jakaja.toString()
                    + "\n Korttien arvo: " + jakaja.korttienPisteet()
                    + "\n\nPelaajan käsi: " + pelaaja.toString()
                    + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                    + "\n\n\nKorttiesi arvo ylitti 21, hävisit pelin. "
                    + "\nMenetit " + panos + " chippiä.");
            vastaus = "2";
          }
        } while (vastaus.equals("1"));
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

    // käsketään näyttöä kysymään mitä käyttäjä haluaa tehdä
    vastaus = naytto.kysyTieto("Sinulla on " + rahaMaara + " euroa ja " + chipMaara + " chippiä.\n\n"
            + "Syötä (1), jos haluat muuttaa rahaa chipeiksi.\n"
            + "Syötä (2), jos haluat muuttaa chippejä rahaksi.");
    switch (vastaus) {
      case "1":
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
        break;
      case "2":
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
        break;
      default:
        naytto.naytaViesti("Kassatyöntekijä katsoo sinua kummastuneena.\n"
                + "Poistut paikalta vikkelään. ");
        break;
    }

    // siirrytään aloitusnäyttöön
    naytto.aloitusNaytto();
  }

  public void lopetus() {
    int rahaMaara = rahat.getSaldo();
    int chipMaara = chipit.getSaldo();

    HighScore highscore;
    highscore = new HighScore();
    highscore.initialize();
    String nimi = JOptionPane.showInputDialog("Mikä on sinun nimesi?");
    int score = rahaMaara * 10;              // score formula
    highscore.checkHighScore(score, nimi);  // katso onko score hyvä 
    highscore.showHighScore();       // näytä kaikki scoret  

    naytto.naytaViesti("Poistut kasinolta taskussasi \n"
            + rahaMaara + " euroa ja " + chipMaara + " chippiä.");
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
