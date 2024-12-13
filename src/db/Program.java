package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		LocalDateTime dateTime = LocalDateTime.of(2024, 12, 03, 0, 0);

		try {

			conn = DB.getConnection();
			st = conn.prepareStatement("INSERT INTO seller" + "(name, email, birthdate, basesalary, departmentid)"
					+ "VALUES" + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, "Victor");
			st.setString(2, "victor@gmail.com");
			st.setTimestamp(3, Timestamp.valueOf(dateTime));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
				
			} else {
				System.out.println("No row affected");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
			
		}

	}

}
