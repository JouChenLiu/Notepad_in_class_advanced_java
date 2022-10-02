//劉柔辰 108403501 資管三A
import java.sql.*;

//DB資料庫類別
//DB類別含有ProductTable產品資料表類別，透過產品資料表類別可編輯產品資料表中的記錄
public class DB {
	private String result = "";
	//isJDBC記錄是否有JDBC驅動程式
	public boolean isJDBC=false;
	//DB資料庫類別建構式
	public DB() {	
        try
        {
           //載入JDBC驅動程式
     	   Class.forName("com.mysql.jdbc.Driver");
     	   isJDBC=true;	//有JDBC驅動程式
        }
        catch(ClassNotFoundException ce)
        {
           //無JDBC驅動程式，即顯示提示訊息
     	   System.out.println("JDBC沒有驅動程式" + ce.getMessage());
     	   isJDBC=false;	//無JDBC驅動程式
        }
        try{
			Connection cn=DriverManager.getConnection ("jdbc:mysql://localhost/product","advjava2021","advjava2021");
			Statement sm = cn.createStatement();
			ResultSet rs = sm.executeQuery("SELECT * FROM 產品");
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1; i<=rsmd.getColumnCount(); i++){
				result += rsmd.getColumnName(i) + "\t";
			}
			System.out.println("資料庫連結成功");
			
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
	        System.out.println("資料庫連接失敗\n" + e.getMessage());
	    }
	}
	
	public String getRS() {
		return result;
	}
}