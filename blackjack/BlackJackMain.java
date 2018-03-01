/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import javax.swing.JOptionPane;

/**
 *
 * @author vladi
 */
public class BlackJackMain {
    
    public static void main(String[] args) {
        
        String vastaus; //käytäjän vastaus
        Pakka peliPakka = new Pakka();
        peliPakka.taysPakka();
        peliPakka.sekoita();
        
        //System.out.println(peliPakka);
        
        Pakka pelaaja = new Pakka();
        
        pelaaja.hit(peliPakka);
        pelaaja.hit(peliPakka);
        
        
        
        
        Pakka jakaja = new Pakka();
        
        jakaja.hit(peliPakka);
        
        
        
        System.out.println();
        JOptionPane.showMessageDialog(null, "Pelaajan käsi: " + pelaaja.toString()
                    + "\n" + "Korttien arvo: " + pelaaja.korttienPisteet() +
                "\n" + "Jakajan käsi: " + jakaja.toString() +
                "\n" + "Korttien arvo: " + jakaja.korttienPisteet());
        
        
        
        do {
            vastaus = "yes"; 
            
                if (pelaaja.korttienPisteet() <= 21) {
                     
                    
                    vastaus = JOptionPane.showInputDialog("Haluatko lisää kortti?");
                    
                    if (vastaus.equals("yes")) {
                        pelaaja.hit(peliPakka);
                        
                        JOptionPane.showMessageDialog(null, "Pelaajan käsi: " + pelaaja.toString()
                    + "\n" + "Korttien arvo: " + pelaaja.korttienPisteet() +
                "\n" + "Jakajan käsi: " + jakaja.toString() +
                "\n" + "Korttien arvo: " + jakaja.korttienPisteet());
                        
                        
                    } /**else if (jakaja.korttienPisteet() < pelaaja.korttienPisteet()               
                            && jakaja.korttienPisteet() < 21) {
                        do { 
                            jakaja.hit(peliPakka);
                        } while (jakaja.korttienPisteet() < pelaaja.korttienPisteet() );
                    
                     if ((jakaja.korttienPisteet() > 21 )) {
                        JOptionPane.showMessageDialog(null, "Pelaajan käsi: " + pelaaja.toString()
                    + "\n" + "Korttien arvo: " + pelaaja.korttienPisteet() +
                "\n" + "Jakajan käsi: " + jakaja.toString() +
                "\n" + "Korttien arvo: " + jakaja.korttienPisteet() +
                                "\n" + "PELAAJA VOITAA!!!");
                     vastaus = "no";
                     } else if ((jakaja.korttienPisteet() == pelaaja.korttienPisteet() )) {
                        JOptionPane.showMessageDialog(null, "Pelaajan käsi: " + pelaaja.toString()
                    + "\n" + "Korttien arvo: " + pelaaja.korttienPisteet() +
                "\n" + "Jakajan käsi: " + jakaja.toString() +
                "\n" + "Korttien arvo: " + jakaja.korttienPisteet() +
                                "\n" + "Arvot sama"); 
                     } else {
                         JOptionPane.showMessageDialog(null, "Pelaajan käsi: " + pelaaja.toString()
                    + "\n" + "Korttien arvo: " + pelaaja.korttienPisteet() +
                "\n" + "Jakajan käsi: " + jakaja.toString() +
                "\n" + "Korttien arvo: " + jakaja.korttienPisteet() +
                                "\n" + "Pelaaja häviää");
                     }
                    vastaus = "no";
                    
                    } **/else if (vastaus.equals("no")) {
                    
                    if (jakaja.korttienPisteet() <= pelaaja.korttienPisteet()               
                            && jakaja.korttienPisteet() < 21) {
                        do { 
                            jakaja.hit(peliPakka);
                        } while (jakaja.korttienPisteet() < pelaaja.korttienPisteet() );
                    
                     if ((jakaja.korttienPisteet() > 21 )) {
                        JOptionPane.showMessageDialog(null, "Pelaajan käsi: " + pelaaja.toString()
                    + "\n" + "Korttien arvo: " + pelaaja.korttienPisteet() +
                "\n" + "Jakajan käsi: " + jakaja.toString() +
                "\n" + "Korttien arvo: " + jakaja.korttienPisteet() +
                                "\n" + "PELAAJA VOITAA!!!");
                     } else if ((jakaja.korttienPisteet() == pelaaja.korttienPisteet() )) {
                        JOptionPane.showMessageDialog(null, "Pelaajan käsi: " + pelaaja.toString()
                    + "\n" + "Korttien arvo: " + pelaaja.korttienPisteet() +
                "\n" + "Jakajan käsi: " + jakaja.toString() +
                "\n" + "Korttien arvo: " + jakaja.korttienPisteet() +
                                "\n" + "Arvot sama"); 
                     } else {
                         JOptionPane.showMessageDialog(null, "Pelaajan käsi: " + pelaaja.toString()
                    + "\n" + "Korttien arvo: " + pelaaja.korttienPisteet() +
                "\n" + "Jakajan käsi: " + jakaja.toString() +
                "\n" + "Korttien arvo: " + jakaja.korttienPisteet() +
                                "\n" + "Pelaaja häviää");
                     }
                    }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pelaaja korttien pisteet: "
                            + pelaaja.korttienPisteet() + "\n" + 
                            "Pelaaja häviää");
                    vastaus = "no";
                }
                
                
            } while (vastaus.equals("yes"));
        
        
        
    }
    
}
    

