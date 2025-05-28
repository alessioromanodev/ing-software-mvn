package zip.entity;

public class RigaOrdine {
    private int quantita;
    private double prezzoUnitario;
    private Fumetto fumetto;

    public int getQuantita() { return quantita; }
    public void setQuantita(int quantita) { this.quantita = quantita; }

    public double getPrezzoUnitario() { return prezzoUnitario; }
    public void setPrezzoUnitario(double prezzoUnitario) { this.prezzoUnitario = prezzoUnitario; }

    public Fumetto getFumetto() { return fumetto; }
    public void setFumetto(Fumetto fumetto) { this.fumetto = fumetto; }
}
