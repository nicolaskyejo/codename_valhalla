package JOptionPaneBlackJack;

public class Rahat {
    
    private int saldo;

    public Rahat(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }
    
    public void lisaa(int määrä) {
        this.saldo += määrä;
    }
    public void vahenna(int määrä) {
        this.saldo -= määrä;
    }
    
}
