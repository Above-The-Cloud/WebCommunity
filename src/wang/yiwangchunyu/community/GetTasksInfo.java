package wang.yiwangchunyu.community;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import wang.yiwangchunyu.community.dataStructures.HttpResponse;
import wang.yiwangchunyu.community.dataStructures.TasksArrayList;
import wang.yiwangchunyu.community.dataStructures.TasksShowOnIndex;

/**
 * Servlet implementation class GetTasksInfo
 */
@WebServlet("/GetTasksInfo")
public class GetTasksInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTasksInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("GBK");
	    response.getWriter().write("GetTasksInfo..." );
	    String ip = request.getRemoteAddr().toString();
	    System.out.println(ip);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpResponse hr = new HttpResponse();
		hr.setRet("1");
		hr.setMsg("服务器错误");
		String sql = "select * from task_publish_info,user_info where user_info.user_id=task_publish_info.user_id order by publish_id desc LIMIT 10; ";
		SQLHelper helper = new SQLHelper();
		ResultSet res = helper.query(sql);
		ArrayList<TasksShowOnIndex> tasksArr = new ArrayList<TasksShowOnIndex>();
		try {
			while(res.next()) {
				TasksShowOnIndex task = new TasksShowOnIndex();
				task.setPublishId(res.getString("publish_id"));
				task.setUserId(res.getString("user_id"));
				task.setUserName(res.getString("user_name"));
				task.setTitle(res.getString("title"));
				task.setRestriction(res.getString("restriction"));
				task.setCategory(res.getString("category"));
				task.setCommission(res.getInt("price"));
				task.setContent(res.getString("content"));
				task.setViewed(res.getInt("viewed"));
				task.setLiked(res.getInt("liked"));
				task.setTime(res.getString("submission_time"));
				ArrayList<String> imagesUrl = new ArrayList<String>();
				String sql_image = "select * from task_publish_image where publish_id="+res.getString("publish_id")+"; ";
				SQLHelper helper_image = new SQLHelper();
				ResultSet res_image = helper_image.query(sql_image);
				if(res_image.next()) {
					imagesUrl.add(res_image.getString("image_path"));
				}
				task.setImagesUrl(imagesUrl);
				tasksArr.add(task);     
				helper_image.close();
			}
			helper.close();
			hr.setRet("0");
			hr.setMsg("success");
			hr.setData(tasksArr);
			
			Gson gson = new Gson();
			String resp = gson.toJson(hr);
			response.getOutputStream().write(resp.getBytes("utf-8"));
			System.out.println(resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    
		}
		
	}

}
