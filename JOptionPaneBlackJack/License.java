package JOptionPaneBlackJack;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/*
 *@author Vladimir,Merja,Ville,Nicolas
 */
public class License {

  public void LicenseInfo() {

    /*JOptionPane.showMessageDialog(null, "This game is a first year school project "
            + "\ndone in spring 2018\nThe code is released under GPL v3\nMade by Ville K, Vladimir G, Merja L & Nicolas K");
     */
    ImageIcon iconC = new ImageIcon(Naytto.class.getResource("zz.jpg"));

    String msg = "<html>Tämä peli on ensimmäisen lukuvuoden kouluprojekti, se on tehty keväällä 2018.<br>"
            + "Koodi on julkaistu <font color=#330080>GPL v3 lisenssillä.</font><br>"
            + "Tekijöina <b>Ville Kerri,  Nicolas Kyejo,  Vladimir Gavrilov ja  Merja Leisti</b></BODY ></html>";

    JLabel message = new JLabel(msg);
    message.setFont(new Font("monospace", Font.PLAIN, 18));
    message.setForeground(new Color(0x2F2D2D));
    JOptionPane.showMessageDialog(null, message, "Lisenssi", JOptionPane.INFORMATION_MESSAGE, iconC);
    //JOptionPane.showMessageDialog(null, "Tämä peli on ensimmäisen lukuvuoden kouluprojekti, se on tehty keväällä 2018.\nKoodi on julkaistu "
    //      + "GPL v3 lisenssillä.\nTekijöina Ville Kerri,  Nicolas Kyejo,  Vladimir Gavrilov ja  Merja Leisti.", "Lisenssi", JOptionPane.INFORMATION_MESSAGE);

  }
}
