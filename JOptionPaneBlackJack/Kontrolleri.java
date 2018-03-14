package JOptionPaneBlackJack;

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
            do {
                vastaus = naytto.kysyPelissa("Sinulla on " + chipMaara + " chippiä. \n"
                        + "Syötä kuinka paljon haluat asettaa panokseksi.");
                if (vastaus == null) {
                    naytto.aloitusNaytto();
                } else if (vastaus.length() > 0) {
                    try {
                        if (Integer.parseInt(vastaus) < 0) {
                            naytto.naytaPelissa("Panos ei voi olla negatiivinen");
                            vastaus = "";
                        } else if (Integer.parseInt(vastaus) > 0) {
                            //OK
                        }
                    } catch (Exception e) {
                        naytto.naytaPelissa("Sinun pitää kirjoittaa panos numeroina. ");
                        vastaus = "";
                    }
                }
            } while (vastaus.length() == 0 || Integer.parseInt(vastaus) > chipMaara);
            int panos = Integer.parseInt(vastaus);

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
                    naytto.naytaPelissa("Jakajan käsi: " + jakaja.toString()
                            + "\n Korttien arvo: " + jakaja.korttienPisteet()
                            + "\n\nPelaajan käsi: " + pelaaja.toString()
                            + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                            + "\n\n\nSekä pelaaja että jakaja saivat BlackJackin: tasapeli!"
                            + "\nSait " + panos + " chippiäsi takaisin. ");
                } else {
                    chipit.lisaa(panos * 4);
                    naytto.naytaPelissa("Jakajan käsi: " + jakaja.toString()
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
                                    naytto.naytaPelissa("Jakajan käsi: " + jakaja.toString()
                                            + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                            + "\n\nPelaajan käsi: " + pelaaja.toString()
                                            + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                            + "\n\n\nJakajan korttien arvo ylitti 21. "
                                            + "\nVoitit " + panos + " chippiä! ");
                                } else if (jakaja.korttienPisteet() == pelaaja.korttienPisteet()) {
                                    chipit.lisaa(panos);
                                    naytto.naytaPelissa("Jakajan käsi: " + jakaja.toString()
                                            + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                            + "\n\nPelaajan käsi: " + pelaaja.toString()
                                            + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                            + "\n\n\nKorttien arvot ovat samat: tasapeli!"
                                            + "\nSait " + panos + " chippiäsi takaisin. ");
                                } else if (jakaja.korttienPisteet() > pelaaja.korttienPisteet()) {
                                    naytto.naytaPelissa("Jakajan käsi: " + jakaja.toString()
                                            + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                            + "\n\nPelaajan käsi: " + pelaaja.toString()
                                            + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                            + "\n\n\nJakajan korttien arvo on suurempi, hävisit pelin. "
                                            + "\nMenetit " + panos + " chippiä.");
                                } else {
                                    chipit.lisaa(panos * 2);
                                    naytto.naytaPelissa("Jakajan käsi: " + jakaja.toString()
                                            + "\n Korttien arvo: " + jakaja.korttienPisteet()
                                            + "\n\nPelaajan käsi: " + pelaaja.toString()
                                            + "\n Korttien arvo: " + pelaaja.korttienPisteet()
                                            + "\n\n\nKorttiesi arvo on suurempi, kuin jakajan. "
                                            + "\nVoitit " + panos + " chippiä.");
                                }
                        }
                    } else {
                        naytto.naytaPelissa("Jakajan käsi: " + jakaja.toString()
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
            naytto.naytaPelissa("Valitettavasti sinulla ei ole yhtään chippejä. ");
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
        naytto.naytaTasku("Sinulla on " + rahaMaara + " euroa ja " + chipMaara + " chippiä.");
        // pyydetään näyttöä esittämään aloitusnäyttö
        naytto.aloitusNaytto();
    }

    public void kassa() {
        String vastaus;
        int valinta;
        // pyydetään Model-kerrokselta tietoa.
        int rahaMaara = rahat.getSaldo();
        int chipMaara = chipit.getSaldo();
        valinta = naytto.kassalla("Sinulla on " + rahaMaara + " euroa ja " + chipMaara + " chippiä.\n"
                + "Valitse, haluatko vaihtaa \n"
                + "euroja chipeiksi vai chippejä euroiksi.\n");

        switch (valinta) {
            case 0:
                if (rahaMaara > 0) {
                    do {
                        vastaus = naytto.kysyKassa("Syötä, kuinka paljon haluat \n"
                                + "muuttaa rahojasi chipeiksi.\n"
                                + "Sinulla on " + rahaMaara + " euroa");
                        if (vastaus == null) {
                            naytto.aloitusNaytto();
                        } else if (vastaus.length() > 0) {
                            try {
                                if (Integer.parseInt(vastaus) < 0) {
                                    naytto.naytaKassa("Syöttämäsi luvun täytyy olla positiivinen. ");
                                    vastaus = "";
                                } else if (Integer.parseInt(vastaus) > 0) {
                                    //OK
                                }
                            } catch (Exception e) {
                                naytto.naytaKassa("Sinun pitää kirjoittaa luku numeroina. ");
                                vastaus = "";
                            }
                        }
                    } while (vastaus.length() == 0 || Integer.parseInt(vastaus) > rahaMaara);
                    int rahamuunnos = Integer.parseInt(vastaus);

                    rahat.vahenna(rahamuunnos);
                    chipit.lisaa(rahamuunnos);
                    naytto.naytaKassa("Muunnos onnistui. ");

                } else {
                    naytto.naytaKassa("Valitettavasti sinulla ei ole yhtään rahaa. ");
                }
                break;
            case 1:
                if (chipMaara > 0) {
                    do {
                        vastaus = naytto.kysyKassa("Syötä, kuinka paljon haluat \n"
                                + "muuttaa chippejäsi euroiksi.\n"
                                + "Sinulla on " + chipMaara + " chippiä.");
                        if (vastaus == null) {
                            naytto.aloitusNaytto();
                        } else if (vastaus.length() > 0) {
                            try {
                                if (Integer.parseInt(vastaus) < 0) {
                                    naytto.naytaKassa("Syöttämäsi luvun täytyy olla positiivinen. ");
                                    vastaus = "";
                                } else if (Integer.parseInt(vastaus) > 0) {
                                    //OK
                                }
                            } catch (Exception e) {
                                naytto.naytaKassa("Sinun pitää kirjoittaa luku numeroina. ");
                                vastaus = "";
                            }
                        }
                    } while (vastaus.length() == 0 || Integer.parseInt(vastaus) > chipMaara);
                    int chipmuunnos = Integer.parseInt(vastaus);

                    chipit.vahenna(chipmuunnos);
                    rahat.lisaa(chipmuunnos);
                    naytto.naytaKassa("Muunnos onnistui. ");

                } else {
                    naytto.naytaKassa("Valitettavasti sinulla ei ole yhtään chippejä. ");
                }
                break;
            default:
                // siirrytään aloitusnäyttöön käytettään "X"
                naytto.aloitusNaytto();
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

        int score = rahaMaara + chipMaara;              // score formula
        if (score >= 510) {
            String nimi = naytto.kysyTieto("Mikä on sinun nimesi?");

            highscore.checkHighScore(score, nimi);  // katso onko score hyvä 
        }

        naytto.naytaExit("Poistut kasinolta taskussasi \n"
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
