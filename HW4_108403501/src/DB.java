//�B�X�� 108403501 ��ޤTA
import java.sql.*;

//DB��Ʈw���O
//DB���O�t��ProductTable���~��ƪ����O�A�z�L���~��ƪ����O�i�s�貣�~��ƪ����O��
public class DB {
	private String result = "";
	//isJDBC�O���O�_��JDBC�X�ʵ{��
	public boolean isJDBC=false;
	//DB��Ʈw���O�غc��
	public DB() {	
        try
        {
           //���JJDBC�X�ʵ{��
     	   Class.forName("com.mysql.jdbc.Driver");
     	   isJDBC=true;	//��JDBC�X�ʵ{��
        }
        catch(ClassNotFoundException ce)
        {
           //�LJDBC�X�ʵ{���A�Y��ܴ��ܰT��
     	   System.out.println("JDBC�S���X�ʵ{��" + ce.getMessage());
     	   isJDBC=false;	//�LJDBC�X�ʵ{��
        }
        try{
			Connection cn=DriverManager.getConnection ("jdbc:mysql://localhost/product","advjava2021","advjava2021");
			Statement sm = cn.createStatement();
			ResultSet rs = sm.executeQuery("SELECT * FROM ���~");
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1; i<=rsmd.getColumnCount(); i++){
				result += rsmd.getColumnName(i) + "\t";
			}
			System.out.println("��Ʈw�s�����\");
			
			result += "\n";
			
			while(rs.next()) {
				String temp;
				temp = rs.getString(1) + "\t" +
						rs.getString(2) + "\t" +
						rs.getInt(3) + "\t" +
						rs.getInt(4) + "\n";
				result += temp;
			}
		}catch(SQLException e){
	        System.out.println("��Ʈw�s������\n" + e.getMessage());
	    }
	}
	
	public String getRS() {
		return result;
	}
}