package com.test.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.model.AskListModel;

public class AskServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//声明Connection对象
		Connection con;
		//驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/ask_source?useSSL=false";
		//MySQL配置时的用户名
		String user = "root";
		//MySQL配置时的密码
		String password = "123456";
		// 返回集合
		List<AskListModel> ask_list = new ArrayList<AskListModel>();

		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
			//1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url,user,password);

			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			//2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			//要执行的SQL语句
			int page = Integer.parseInt(req.getParameter("page"));
			int page_start_idx = page *10;
			String sql = String.format("select * from source_list limit %d,%d",page_start_idx,page_start_idx+10);
			//3.ResultSet类，用来存放获取的结果集！！
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()){

				AskListModel model = new AskListModel(
						rs.getString("title"), rs.getString("cover"), rs.getString("date"),
						rs.getString("tag"), rs.getString("href_url"), rs.getString("small_count"),
						rs.getString("upload_user"), rs.getString("read_str"), rs.getString("comments"),
						rs.getString("comments_url"), rs.getString("like_str"), rs.getString("note"));
				//输出结果
				ask_list.add(model);
			}
			rs.close();
			con.close();
		} catch(ClassNotFoundException e) {   
			//数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");   
			e.printStackTrace();   
		} catch(SQLException e) {
			//数据库连接失败异常处理
			e.printStackTrace();  
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
//			System.out.println("数据库数据成功获取！！");
		}


		// 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		Gson gson = new Gson();
		String json = gson.toJson(ask_list);
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print(json);
		out.flush();
	}
}
