package JOptionPaneBlackJack;

public class Chipit {
    
    private int saldo;

    public Chipit (int saldo) {
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
