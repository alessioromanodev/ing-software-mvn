package zip.control;

import zip.entity.Fumetto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FumettoController {
    private static final String URL = "jdbc:h2:./fumetteriaZIP;INIT=RUNSCRIPT FROM 'src/main/resources/init.sql'";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public List<Fumetto> findAll() {
        List<Fumetto> lista = new ArrayList<>();
        String sql = "SELECT * FROM fumetto";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Fumetto f = new Fumetto();
                f.setId(rs.getInt("id"));
                f.setNomeSerie(rs.getString("nome_serie"));
                f.setAnnoSerie(rs.getString("anno_serie"));
                f.setAutore(rs.getString("autore"));
                f.setNumeroVolume(rs.getInt("numero_volume"));
                f.setTitolo(rs.getString("titolo"));
                f.setGenere(rs.getString("genere"));
                f.setCasaEditrice(rs.getString("casa_editrice"));
                f.setDescrizione(rs.getString("descrizione"));
                f.setPrezzo(rs.getDouble("prezzo"));
                f.setQuantitaDisponibile(rs.getInt("quantita_disponibile"));
                // f.setImmagineCopertina(rs.getBytes("immagine_copertina")); // opzionale
                lista.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean insert(Fumetto f) {
        String sql = "INSERT INTO fumetto (nome_serie, anno_serie, autore, numero_volume, titolo, genere, casa_editrice, descrizione, prezzo, quantita_disponibile) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getNomeSerie());
            ps.setString(2, f.getAnnoSerie());
            ps.setString(3, f.getAutore());
            ps.setInt(4, f.getNumeroVolume());
            ps.setString(5, f.getTitolo());
            ps.setString(6, f.getGenere());
            ps.setString(7, f.getCasaEditrice());
            ps.setString(8, f.getDescrizione());
            ps.setDouble(9, f.getPrezzo());
            ps.setInt(10, f.getQuantitaDisponibile());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM fumetto WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Fumetto f) {
        String sql = "UPDATE fumetto SET nome_serie = ?, anno_serie = ?, autore = ?, numero_volume = ?, titolo = ?, genere = ?, casa_editrice = ?, descrizione = ?, prezzo = ?, quantita_disponibile = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getNomeSerie());
            ps.setString(2, f.getAnnoSerie());
            ps.setString(3, f.getAutore());
            ps.setInt(4, f.getNumeroVolume());
            ps.setString(5, f.getTitolo());
            ps.setString(6, f.getGenere());
            ps.setString(7, f.getCasaEditrice());
            ps.setString(8, f.getDescrizione());
            ps.setDouble(9, f.getPrezzo());
            ps.setInt(10, f.getQuantitaDisponibile());
            ps.setInt(11, f.getId());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
