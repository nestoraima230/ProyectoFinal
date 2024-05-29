package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorDetailsModel {
    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";

    public List<String> getInstructorDetails(int instructorId) {
        List<String> classHistory = new ArrayList<>();
        String query = "SELECT * FROM CLASE WHERE INSTRUCTOR_ID = ?";

        try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, instructorId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    classHistory.add(rs.getString("CLASE_ID"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classHistory;
    }
}
