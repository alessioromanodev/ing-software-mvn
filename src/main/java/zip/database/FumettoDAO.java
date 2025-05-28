package zip.database;

import zip.entity.Fumetto;
import java.sql.*;
import java.util.*;

public class FumettoDAO {

    public List<Fumetto> findAll() throws SQLException {
        String sql = "SELECT id, titolo, autore FROM fumetti";
        List<Fumetto> list = new ArrayList<>();
        try (Connection c = DBManager.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                Fumetto f = new Fumetto();
                f.setId(rs.getInt("id"));
                f.setTitolo(rs.getString("titolo"));
                f.setAutore(rs.getString("autore"));
                list.add(f);
            }
        }
        return list;
    }

    public void createFumetto(Fumetto f) throws SQLException {
        String sql = "INSERT INTO fumetti(titolo, autore) VALUES(?, ?)";
        try (Connection c = DBManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, f.getTitolo());
            ps.setString(2, f.getAutore());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    f.setId(keys.getInt(1));
                }
            }
        }
    }
}
