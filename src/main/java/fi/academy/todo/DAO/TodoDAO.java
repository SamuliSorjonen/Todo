package fi.academy.todo.DAO;

import fi.academy.todo.Tehtava;
import fi.academy.todo.TodonDAO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoDAO implements TodonDAO {

    private Connection con;

    public TodoDAO() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/todo", "postgres", "academy");
    }


    @Override
    public List<Tehtava> haeKaikki() {
        String sql = "SELECT * FROM todot";
        List<Tehtava> haetut = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            for (ResultSet rs = pstmt.executeQuery(); rs.next(); ) {
                haetut.add(new Tehtava(rs.getInt("id"), rs.getString("tehtava")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return haetut;
    }

    @Override
    public int lisaa(Tehtava uusitehtava) {
        String tehtava = uusitehtava.getTehtava();
        String sql = "INSERT INTO todot (tehtava) VALUES (?)";

        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, tehtava);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void poista(int id) {

        String sql = "DELETE FROM todot WHERE(id=?)";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
