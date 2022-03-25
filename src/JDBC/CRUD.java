package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

	// CRUD
	// C : CREATE(����)
	// R : READ(��ȸ)
	// U : UPDATE(����)
	// D : DELETE(����)

	Connection con = null;
	// DB�� �����ϱ� ���� ��ü

	Statement stmt = null;
	// SQL���� ����ϱ� ���� ��ü
	
	ResultSet rs = null;
	// SQL�� ��ȸ�� ������ �����ϴ� ��ü

	public void insert1() {

		try {
			// �غ�ܰ�
			con = DBConnection.DBconnect();
			stmt = con.createStatement();

			// SQL�� �ۼ�
			String sql = "INSERT INTO JAVASQL VALUES('JAVA3', 'SQL3')";

			// SQL�� ����
			int result = stmt.executeUpdate(sql);

			// ������ Ȯ��
			System.out.println("��� : " + result);

			if (result > 0) {
				System.out.println("insert success!");
			} else {
				System.out.println("insert fail!");
			}

			// stmt���� DB���� ����
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// NAVER ȸ������ �����ϱ�
	public void insert() {
		// ȸ������ DB�� insert�ϱ�!
		// n_insert() �޼ҵ� ���� �� JdbcMainŬ���� �����ϱ�
		// TESTCRUD or SQLDeveloper���� NAVER���̺� ��ȸ�غ���!
		
		try {
			con = DBConnection.DBconnect();
			stmt = con.createStatement();

			// SQL�� �ۼ�
			String sql = "INSERT INTO NAVER VALUES('���̵�2', '�н�����', '�̸�', 30, '��', 'EMAIL@NAVER.COM', '010-1234-5678')";

			// SQL�� ����
			int result = stmt.executeUpdate(sql);

			// ������ Ȯ��
			System.out.println("��� : " + result);

			if (result > 0) {
				System.out.println("���̹� ȸ������ ����!");
			} else {
				System.out.println("ȸ������ ����!");
			}

			// stmt���� DB���� ����
			stmt.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	// ȸ������ ��ȸ SELECT
	public void select() {
		
		try {
			con = DBConnection.DBconnect();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM NAVER";
			
			// ��ȸ�� ������ rs��ü�� ��´�.
			rs = stmt.executeQuery(sql);
			
			// Ʃ��(������ ���ڵ�) ���� ��ŭ �ݺ���
			while(rs.next()) {
				// rs.next() : ������ Ÿ���� boolean
				// ���ڵ尡 ������ ��� true, 
				// �� �̻� �������� ���� ��� false, �ݺ����� ����
				System.out.println("���̵� : " + 		rs.getString(1));
				System.out.println("�н����� : " + 	rs.getString(2));
				System.out.println("�̸� : " + 		rs.getString(3));
				System.out.println("���� : " + 		rs.getInt(4));
				System.out.println("���� : " + 		rs.getString(5));
				System.out.println("�̸��� : " + 		rs.getString(6));
				System.out.println("��ȭ��ȣ : " + 	rs.getString(7));
				System.out.println();
						
			}
			
			stmt.close();
			con.close();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// ȸ������ ���� UPDATE
	public void update() {
		
		try {	// ������ ������ try�� ����, catch�� ����x
			
			con = DBConnection.DBconnect();
			stmt = con.createStatement();
			
			String sql = "UPDATE NAVER SET NAGE=15 WHERE NID='���̵�2'";
			
			int result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("update success!");
			} else {
				System.out.println("update fail!");
			}
			
			
		} catch (SQLException e) {	// ������ ����� try�� ����x, catch�� ����
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		// ������ ����� , ������ ������ �ʰ�, ������ ����
			
		}
		
	}	// end update()
	
	// ȸ������ ���� delete()
	public void delete() {
		
		// [1] �غ�ܰ� : con(����), stmt(����) => try, catch��
		// [2] �ۼ��ܰ� : sql
		// [3] ����ܰ� : execute : 
		//				CUD(intŸ�� executeUpdate), R(ResultSetŸ�� executeQuery)
		// [4] Ȯ�δܰ� : while, if
		// [5] �����ܰ� : close
		
		
		try {
			con = DBConnection.DBconnect();
			stmt = con.createStatement();
			
			String sql = "DELETE FROM NAVER WHERE NID='���̵�2'";
			
			int result = stmt.executeUpdate(sql);
			
			System.out.println("��� : " + result);
			
			if(result>0) {
				System.out.println("DELETE SUCCESS!");
			} else {
				System.out.println("DELETE FAIL!");
			}
			
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}








