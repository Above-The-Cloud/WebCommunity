package wang.yiwangchunyu.community;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import wang.yiwangchunyu.community.constance.Urlconstance;
import wang.yiwangchunyu.community.dataStructures.HttpResponse;
import wang.yiwangchunyu.community.utils.Utils;

/**
 * Servlet implementation class PublishInfo
 */
@WebServlet("/PublishInfo")
public class PublishInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String publish_id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("GBK");
	    response.getWriter().write("PublishInfo..." );
	    String ip = request.getRemoteAddr().toString();
	    System.out.println(ip);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("publish info....start");
		String ip = request.getRemoteAddr().toString();
	    System.out.println(ip);
	    String user_id = request.getParameter("user_id");
	    System.out.println(user_id);
	    String title = request.getParameter("title");
	    System.out.println(title);
	    String restriction = request.getParameter("restriction");
	    System.out.println(restriction);
	    String content = request.getParameter("content");
	    System.out.println(content);
	    String category = request.getParameter("category");
	    System.out.println(category);
	    String price = request.getParameter("commission");
	    System.out.println(price);
	    String filecount = request.getParameter("filecount");
	    System.out.println(filecount);
	    
	    
	    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    String DB_URL = SQLConfig.DB_URL;
	    String USER = SQLConfig.DB_USER;
	    String PASS = SQLConfig.DB_PASS;
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    HttpResponse hrps= new HttpResponse();
	    hrps.setRet("1"); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
			stmt = conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY,  
			        java.sql.ResultSet.CONCUR_UPDATABLE);
		  
		String sql = "insert into task_publish_info(user_id, title, restriction, content, category, price, viewed, liked, submission_time) values('" 
                	+ user_id + "','" + title + "','" + restriction + "','" + content + "','" + category + "','" + Integer.parseInt(price) + "', 0, 0, current_time());";
		
			stmt.executeUpdate(sql,  
			        Statement.RETURN_GENERATED_KEYS);
		
			rs = stmt.getGeneratedKeys();
		                                  // 获取自增主键！  
	    
			if (rs.next()) {  
			    String id = rs.getString(1); 
			    publish_id = id;
			    hrps.setData(id);
			    hrps.setRet("0");
			    hrps.setMsg("发布成功！");
			    
			}  else {  
			    
			}
			//获取图片
			if(filecount.equals("0")) {
		    	
		    }else {
		    	for(int i=0;i<Integer.parseInt(filecount);i++) {
		    		String imageStr = request.getParameter("image"+String.valueOf(i+1));
		    		//System.out.println("imageStr->"+imageStr);
		    		String url = Utils.imgStr2Image(imageStr, Urlconstance.IMAGE_ROOT+user_id+"/", user_id, publish_id);
		    		String sqlImg = "insert into task_publish_image(publish_id, image_path, submission_time)values ('"+publish_id+"','"+url+"',current_time());";
		    		stmt.execute(sqlImg);
		    	}
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    Gson gson = new Gson();
		String res = gson.toJson(hrps);
		response.getOutputStream().write(res.getBytes("utf-8"));
		System.out.println(res);
		
		try {
			if(rs!=null)
			rs.close();
		
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
