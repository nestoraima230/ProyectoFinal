package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InstructorModel {

    public InstructorModel() {

    }

    public List<List<String>> get() throws SQLException, ClassNotFoundException {

        List<List<String>> data = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio", "freedb_nestor_arce", "uwDrTJ7Xw!a8v!r");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM INSTRUCTOR");

            while (rs.next()) {
                List<String> instructor = new ArrayList<>();
                instructor.add(rs.getString(2));
                instructor.add(rs.getString(3));
                instructor.add(rs.getString(4));
                instructor.add(rs.getString(5));
                data.add(instructor);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return data;
    }
}
