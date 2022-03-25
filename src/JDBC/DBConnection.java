package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection DBconnect() {
		// DB�� �������� ������ ���� ConnectionŬ������ ��ü con����
		Connection con = null;

		// DB�� ������ ��������
		String user = "CHENYIN";
		String password = "1111";

		// DB�� ������ �ּ�����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// String url = "jdbc:oracle:thin:@192.168.0.44:1521:XE";
		// String url = "jdbc:oracle:thin:@121.65.47.77:1522:XE";

		try {
			// (1) ����Ŭ �����ͺ��̽� ����̹�
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// (2) ����Ŭ �����ͺ��̽� ��������
			con = DriverManager.getConnection(url, user, password);

			System.out.println("DB���� ����!");
		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB���� ���� : ����̹� �ε� ����");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("DB���� ���� : ���� ���� ����");
		}

		return con;
	}

}
