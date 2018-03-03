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
            System.out.println("");
            try {
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				
				System.out.println("查询执行完毕....");
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return rs;
    }
	public int update(String sql){
        
        // ע�� JDBC ����
		int state =0 ;
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
        // ������
        System.out.println("");
        try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			stmt = conn.createStatement();
			
			state = stmt.executeUpdate(sql);
			System.out.println("更新执行完毕....");
			return state;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return state;
}
	public void close() throws SQLException
	{
		if(rs!=null) {
			 rs.close();
	         stmt.close();
	         conn.close();
		}else {
			
		}
		 
	}
}