package JOptionPaneBlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class Pakka {

    private ArrayList<Kortti> pakka;

    public Pakka() {
        this.pakka = new ArrayList<Kortti>();
    }

    //pakan täyttö
    public void taysPakka() {
        for (Maa maa : Maa.values()) {                   // jokainen maa yksi kerrallaan
            for (Arvo arvo : Arvo.values()) {            // maahan jokainen arvo yksi kerrallaan
                this.pakka.add(new Kortti(maa, arvo)); // uusi kortti lisätään pakkaan
            }
        } // for toisto tapahtuu kunnes jokainen arvo on käytetty jokaisella maalla
    }

    // pakan sekoitus
    public void sekoita() {
        Collections.shuffle(pakka);
    }

    @Override
    public String toString() {
        String korttiLista = "";
        for (Kortti tKortti : this.pakka) {
            korttiLista += "\n " + tKortti.toString();
        }
        return korttiLista;
    }

    public void poistaKortti(int i) {
        this.pakka.remove(i);
    }

    public Kortti getKortti(int i) {
        return this.pakka.get(i);
    }

    public void hit(Pakka jakoPakasta) {
        this.pakka.add(jakoPakasta.getKortti(0));
        jakoPakasta.poistaKortti(0);
    }

    //korttien arvot, kutsutaan pisteiksi ettei mene sekaisin
    public int korttienPisteet() {
        int kokoPisteet = 0;
        // ässä voi olla 1 tai 11 jotenka ne pitää tilanteesta riippuen
        int assat = 0;

        // for lause pakan jokaiselle kortille
        for (Kortti tKortti : this.pakka) {
            //käytetään switch case jokaisen kortin arvon määrittelyyn
            switch (tKortti.getArvo()) {
                case KAKSI:
                    kokoPisteet += 2;
                    break;
                case KOLME:
                    kokoPisteet += 3;
                    break;
                case NELJA:
                    kokoPisteet += 4;
                    break;
                case VIISI:
                    kokoPisteet += 5;
                    break;
                case KUUSI:
                    kokoPisteet += 6;
                    break;
                case SEITSEMAN:
                    kokoPisteet += 7;
                    break;
                case KAHDEKSAN:
                    kokoPisteet += 8;
                    break;
                case YHDEKSAN:
                    kokoPisteet += 9;
                    break;
                case KYMMENEN:
                    kokoPisteet += 10;
                    break;
                case JÄTKÄ:
                    kokoPisteet += 10;
                    break;
                case KUNINGATAR:
                    kokoPisteet += 10;
                    break;
                case KUNINGAS:
                    kokoPisteet += 10;
                    break;
                case ÄSSÄ:
                    assat += 1;
                    break;
            }
        }
        //ässien arvon määrittely
        for (int i = 0; i < assat; i++) {
            // jos pisteet menisi yli 21 ässän ollessa 11, sen arvo on 1.
            if (kokoPisteet > 10) {
                kokoPisteet += 1;
            } else {
                kokoPisteet += 11;
            }
        }
        //palautetaan korttien yhteenlasketut pisteet
        return kokoPisteet;
    }
}
