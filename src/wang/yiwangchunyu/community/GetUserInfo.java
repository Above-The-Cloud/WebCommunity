package wang.yiwangchunyu.community;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetUserInfo
 */
@WebServlet("/GetUserInfo")
public class GetUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 使用 GBK 设置中文正常显示
	    response.setCharacterEncoding("GBK");
	    response.getWriter().write("GetUserInfo..." );
	    String ip = request.getRemoteAddr().toString();
	    System.out.println(ip);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ip = request.getRemoteAddr().toString();
	    System.out.println(ip);
	    String userid = request.getParameter("userid");
	    System.out.println(userid);
	    
	    String sql  = "SELECT * FROM user_info WHERE user_id = '" + userid + "';";
	    SQLHelper sqlHelper = new SQLHelper();
        ResultSet rs = sqlHelper.query(sql);
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        try {
        	if(rs.next())
        	{		
        			
        			userBaseInfo.setUserid(rs.getString("user_id"));
        			userBaseInfo.setNickname(rs.getString("user_name"));
        			userBaseInfo.setRet("0");
        			userBaseInfo.setRole("0");		
        	}
        	else {
				userBaseInfo.setRet("1");
			}
        	Gson gson = new Gson();
			String userInfoString = gson.toJson(userBaseInfo);
			response.getOutputStream().write(userInfoString.getBytes("utf-8"));
			System.out.println(userInfoString);
			sqlHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//doGet(request, response);
	}

}

