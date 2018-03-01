package blackjack;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/*
Tämä on missa kokeleetan kortit grafiika homat
 */

 /*
 *@author nk
 */
public class Kortit {

  private Maa maa;
  private Arvo arvo;
  private BufferedImage img;

  public void createKortti(Maa maa, Arvo arvo) {
    // switch();
  }

  public void LoadImageApp() {
    try {
      img = ImageIO.read(new File("as.gif"));
    } catch (IOException e) {
    }

  }

  
    
}
