package wang.yiwangchunyu.community;

import java.sql.*;

public class SQLHelper {
 
    // JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    public static final String DB_URL = SQLConfig.DB_URL;
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    public static final String USER = SQLConfig.DB_USER;
    public static final String PASS = SQLConfig.DB_PASS;
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;
    
	public ResultSet query(String sql){
        
            // ע�� JDBC ����
            try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
            // ������
            System.out.println("�������ݿ�...");
            try {
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				
				System.out.println("ִ�����ѯ���....");
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return rs;
    }
	public void close() throws SQLException
	{
		  rs.close();
          stmt.close();
          conn.close();
	}
}