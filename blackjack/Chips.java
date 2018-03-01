package blackjack;


/*
 *@author Merja
 */
public class Chips {

    private int chipmaara;
    private int euromaara = 500;
    private int arvo;

    public Chips() {

    }

    public void setChipmaara(int arvo) {
        this.chipmaara = arvo;
        
    }

    public int getChipmaara() {
        return chipmaara;
    }

    public int vahenna(int arvo) {
        euromaara = this.euromaara - arvo;
        return euromaara;
    }

    public int getEuromaara() {
        return euromaara;
    }

}
