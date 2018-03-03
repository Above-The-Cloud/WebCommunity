package wang.yiwangchunyu.community;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
 
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Login(){
        super();
    }
     
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// 使用 GBK 设置中文正常显示
	    response.setCharacterEncoding("GBK");
	    response.getWriter().write("Login..." );
	    String ip = request.getRemoteAddr().toString();
	    System.out.println(ip);
		response.getWriter().append("Served at: ").append(request.getContextPath());
    }
 
     
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String ip = request.getRemoteAddr().toString();
	    System.out.println(ip);
	    String user_id = request.getParameter("user_id");
	    System.out.println(user_id);
	    String user_password = request.getParameter("user_password");
	    System.out.println(user_password);
	    
	    String sql  = "SELECT * FROM user_info WHERE user_id = '" + user_id + "' user_password = '" + user_password + "';";
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

    	
         
    }
    public void httpPrinter(HttpServletRequest request) throws ServletException, IOException{
    	InputStream inStream = request.getInputStream(); 
        ObjectInputStream objInStream = new ObjectInputStream(inStream); 
        Object obj = null;
		try {
			obj = objInStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map m = (Map) obj;
        String username = m.get("username").toString();
        String password = m.get("password").toString();
        System.out.println("---------------------------------------------------------");
        System.out.println("�û�����"+username);
        System.out.println("���룺"+password);
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
          String key = (String) headerNames.nextElement();
          String value = request.getHeader(key);
          System.out.println(key + " = " + value);
        }
        Map map=request.getParameterMap();
        Set keSet=map.entrySet();
        for(Iterator itr=keSet.iterator();itr.hasNext();){
            Map.Entry me=(Map.Entry)itr.next();
            Object ok=me.getKey();
            Object ov=me.getValue();
            String[] value=new String[1];
            if(ov instanceof String[]){
                value=(String[])ov;
            }else{
                value[0]=ov.toString();
            }

            for(int k=0;k<value.length;k++){
                System.out.println(ok+"="+value[k]);
            }
         }
    }
 
}
