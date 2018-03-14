package JOptionPaneBlackJack;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Naytto {

    // määritetään kontrolleri, johon näyttö yhteydessä
    private Kontrolleri kontrolleri;
    private final License license = new License();
    private final PelinSaannot saannot = new PelinSaannot();

    ImageIcon iconA = new ImageIcon(Naytto.class.getResource("js.gif"));
    ImageIcon tasku = new ImageIcon(Naytto.class.getResource("tasku.png"));
    ImageIcon exit = new ImageIcon(Naytto.class.getResource("exit.png"));
    ImageIcon kirjaus = new ImageIcon(Naytto.class.getResource("kirjaus.png"));
    ImageIcon kassakone = new ImageIcon(Naytto.class.getResource("kassakone.png"));
    ImageIcon jakaja = new ImageIcon(Naytto.class.getResource("jakaja.png"));

    // metodi luo näytön, joka sisältää perusvalikon.
    public void aloitusNaytto() {
        String valintaK;      // käyttäjän valinta merkkijonona
        int valinta;            // valinta numerona

        String msg = "<html><b><font size=80>🂫</font>Tervetuloa kasinolle pelaamaan BlackJackiä<font size=80>🃛</font></b><br>"
                + "<i>&emsp&emsp&emsp&emsp Valitse toiminto <font color=#993d00><b>(1-6)</b></font> seuraavista:</i><br><br>"
                + "<b>&emsp&emsp&emsp&emsp&emsp&emsp 1:  <font color=#F11B2D>♦</font>Pelaa♣<br>"
                + "&emsp&emsp&emsp&emsp&emsp&emsp 2:  ♠Tarkastele taskujasi<font color=#F11B2D>♥</font><br>"
                + "&emsp&emsp&emsp&emsp&emsp&emsp 3:  <font color=#F11B2D>♥</font>Kassa♠<br>"
                + "&emsp&emsp&emsp&emsp&emsp&emsp 4:  ♣Peliohjeet<font color=#F11B2D>♦</font><br>"
                + "&emsp&emsp&emsp&emsp&emsp&emsp 5:  <font color=#F11B2D>♥</font>Lisenssi♣<br>"
                + "&emsp&emsp&emsp&emsp&emsp&emsp 6:  ♠Poistu kasinolta<font color=#F11B2D>♥</font></b>"
                + "</BODY > < / html >";
        JLabel message = new JLabel(msg);
        message.setFont(new Font("Verdana", Font.PLAIN, 16));
        message.setForeground(new Color(0x2F2D2D));

        do {

            // päävalikko
            valintaK = JOptionPane.showInputDialog(null, message,
                    "B  L  A  C  K  J  A  C  K    2 1", JOptionPane.PLAIN_MESSAGE);
            if (valintaK == null) {
                valintaK = "6";
            } else if (valintaK.length() > 0) {
                try {
                    if (Integer.parseInt(valintaK) > 0
                            && Integer.parseInt(valintaK) <= 6) {
                        //OK
                    } else {
                        naytaViesti("Sinun pitää valita numero 1-6");
                        valintaK = "0";
                    }
                } catch (Exception e) {
                    naytaViesti("Sinun pitää valita numero 1-6");
                    valintaK = "0";
                }
            }
        } while (valintaK.length() == 0);
        //try {
        // käyttäjän antama vastaus muutetaan numeroksi
        valinta = Integer.parseInt(valintaK);

        // ilmoitetaan kontrollerille käyttäjän valitsema toiminto
        switch (valinta) {
            case 1:
                kontrolleri.pelaa();
                break;
            case 2:
                kontrolleri.saldo();
                break;
            case 3:
                kontrolleri.kassa();
                break;
            case 4:
                saannot.kerrosaannot();
                aloitusNaytto();
                break;
            case 5:
                license.LicenseInfo();
                aloitusNaytto();
                break;
            case 6:
                kontrolleri.lopetus();
                break;
            default:
                aloitusNaytto();
        }

        //} catch (NumberFormatException e) {
        //    kontrolleri.lopetus();
        //}
    }

    // näytön toimintoja
    public void naytaViesti(String viesti) {
        // Parametrina näytettävä viesti
        JOptionPane.showMessageDialog(null, viesti, "Taskut", JOptionPane.PLAIN_MESSAGE, iconA);
    }

    public void naytaTasku(String viesti) {
        // Parametrina näytettävä viesti
        JOptionPane.showMessageDialog(null, viesti, "Taskut", JOptionPane.PLAIN_MESSAGE, tasku);
    }

    public void naytaExit(String viesti) {
        // Parametrina näytettävä viesti
        JOptionPane.showMessageDialog(null, viesti, "Tervetuloa uudestaan!", JOptionPane.PLAIN_MESSAGE, exit);
    }

    //naytaViesti jakajan kuvalla
    public void naytaPelissa(String viesti) {
        // Parametrina näytettävä viesti
        JOptionPane.showMessageDialog(null, viesti, "Blackjack pöydässä", JOptionPane.PLAIN_MESSAGE, jakaja);
    }

    public void naytaKassa(String viesti) {
        // Parametrina näytettävä viesti
        JOptionPane.showMessageDialog(null, viesti, "Kassalla", JOptionPane.PLAIN_MESSAGE, kassakone);
    }

    public String kysyTieto(String kysymys) {
        // kysymys toimii parametrina, metodi palauttaa käyttäjän antaman vastauksen 
        return (String) JOptionPane.showInputDialog(null, kysymys, "Pääset Highscoreen!", JOptionPane.INFORMATION_MESSAGE, kirjaus, null, "");
    }

    //kysyTieto jakajan kuvalla
    public String kysyPelissa(String kysymys) {
        // kysymys toimii parametrina, metodi palauttaa käyttäjän antaman vastauksen 
        return (String) JOptionPane.showInputDialog(null, kysymys, "Blackjakc pöydässä", JOptionPane.INFORMATION_MESSAGE, jakaja, null, "");
    }

    public String kysyKassa(String kysymys) {
        // kysymys toimii parametrina, metodi palauttaa käyttäjän antaman vastauksen 
        return (String) JOptionPane.showInputDialog(null, kysymys, "Kassalla", JOptionPane.INFORMATION_MESSAGE, kassakone, null, "");
    }

    public int kassalla(String jotain) {
        Object[] napit = {"Euroja chipeiksi", "Chippejä euroiksi"};

        return JOptionPane.showOptionDialog(null,
                jotain,
                "Kassalla", //yläpalkin teksti
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                kassakone, //liittyy kuvaan/ikoniin
                napit, //napit
                napit[0]);
    }

    public int otatkoKortin(String viesti) {
        Object[] napit = {"Ota kortti", "Päätä vuorosi"};

        return JOptionPane.showOptionDialog(null,
                viesti,
                "Blackjack pöydässä", //tähän mitä yläpalkis lukee
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                jakaja, //tää liittyy kuvaan/ikoniin
                napit, //napit
                napit[0]);
    }

    public void rekisteroiOhjain(Kontrolleri ohjain) {
        // näyttö saa tiedon kontrollerista, jolle se välittää pyyntöjä
        this.kontrolleri = ohjain;
    }

}
