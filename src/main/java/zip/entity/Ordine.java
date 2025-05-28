package zip.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Ordine {
    private int idOrdine;
    private LocalDateTime dataOrdine;
    private double importoTotale;
    private String metodoConsegna;
    private String statoOrdine;
    private String qrCode;
    private List<RigaOrdine> righeOrdini;

    public int getIdOrdine() { return idOrdine; }
    public void setIdOrdine(int idOrdine) { this.idOrdine = idOrdine; }

    public LocalDateTime getDataOrdine() { return dataOrdine; }
    public void setDataOrdine(LocalDateTime dataOrdine) { this.dataOrdine = dataOrdine; }

    public double getImportoTotale() { return importoTotale; }
    public void setImportoTotale(double importoTotale) { this.importoTotale = importoTotale; }

    public String getMetodoConsegna() { return metodoConsegna; }
    public void setMetodoConsegna(String metodoConsegna) { this.metodoConsegna = metodoConsegna; }

    public String getStatoOrdine() { return statoOrdine; }
    public void setStatoOrdine(String statoOrdine) { this.statoOrdine = statoOrdine; }

    public String getQrCode() { return qrCode; }
    public void setQrCode(String qrCode) { this.qrCode = qrCode; }

    public List<RigaOrdine> getRigheOrdini() { return righeOrdini; }
    public void setRigheOrdini(List<RigaOrdine> righeOrdini) { this.righeOrdini = righeOrdini; }
}