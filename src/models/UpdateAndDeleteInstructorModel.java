package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UpdateAndDeleteInstructorModel {

    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";

    public UpdateAndDeleteInstructorModel() {
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public boolean updateInstructor(List<String> instructor) {
        String query = "UPDATE INSTRUCTOR SET NOMBRE = ?, APELLIDOS = ?, ESPECIALIDAD = ?, EMAIL = ? WHERE INSTRUCTOR_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, instructor.get(1));
            pstmt.setString(2, instructor.get(2));
            pstmt.setString(3, instructor.get(3));
            pstmt.setString(4, instructor.get(4));
            pstmt.setInt(5, Integer.parseInt(instructor.get(0)));
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Instructor updated: " + instructor.get(0) + "," + instructor.get(1) + "," + instructor.get(2) + "," + instructor.get(3));
            }
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteInstructor(int instructorId) {
        String query = "DELETE FROM INSTRUCTOR WHERE INSTRUCTOR_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, instructorId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Instructor deleted: ID = " + instructorId);
            }
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
