package JDBC;

import java.util.Scanner;

public class JdbcMain {

	public static void main(String[] args) {
//		DBConnection conn = new DBConnection();
//		conn.DBconnect();
		
		CRUD crud = new CRUD();
		
		// crud.insert();
		// crud.select();
		// crud.update();
		// crud.delete();
		
		System.out.println("================================");
		System.out.println("       ���̹� ȸ������ ������         ");
		
		
		boolean run = true;
		
		while(run) {
			System.out.println("================================");
			System.out.println();
			System.out.println("1.����  2.��ȸ  3.����   4.����  5.����");
			System.out.print("���� >> ");
			
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				crud.insert();
				break;
			case 2:
				crud.select();
				break;
			case 3:
				crud.update();
				break;
			case 4:
				crud.delete();
				break;
			case 5:
				run = false;
				System.out.println("���α׷� ����!");
				break;
			default:
				System.out.println("�ٽ� �Է����ּ���!");
				break;
			}
		}
	}

}
