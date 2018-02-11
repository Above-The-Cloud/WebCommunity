package wang.yiwangchunyu.community;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Login(){
        super();
    }
     
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("---------------------------------------------------------");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
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
        
        if ("123".equals(username)&&"123".equals(password)) {
            System.out.println("登录成功");
            response.getOutputStream().write("success".getBytes("utf-8"));       
        }else {
            System.out.println("登录失败");
            response.getOutputStream().write("fail".getBytes("utf-8"));    
        }
    }
 
     
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
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
        
        if ("123".equals(username)&&"123".equals(password)) {
            System.out.println("登录成功");
            response.getOutputStream().write("success".getBytes("utf-8"));       
        }else {
            System.out.println("登录失败");
            response.getOutputStream().write("fail".getBytes("utf-8"));    
        }
         
    }
 
}
