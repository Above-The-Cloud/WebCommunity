package wang.yiwangchunyu.community;

import java.sql.*;

public class SQLHelper {
 
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    public static final String DB_URL = SQLConfig.DB_URL;
 
    // 数据库的用户名与密码，需要根据自己的设置
    public static final String USER = SQLConfig.DB_USER;
    public static final String PASS = SQLConfig.DB_PASS;
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;
    
	public ResultSet query(String sql){
        
            // 注册 JDBC 驱动
            try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
            // 打开链接
            System.out.println("连接数据库...");
            try {
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				
				System.out.println("执行完查询语句....");
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