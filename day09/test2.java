package com.offcn.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo2 {
	Connection conn;
	Statement st;
	@Before
	public void before() throws Exception {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接
		conn = DriverManager.getConnection("jdbc:mysql:///day09", "root", "1234");
		//3、获取发送sql语句的对象
		 st = conn.createStatement();
	}
	//添加数据
	@Test
	public void testAdd() throws Exception {
		
		String sql = "insert into user values(null,'白骨精', '77777','吃唐僧肉')";
		//4、执行sql并返回结果
		int i = st.executeUpdate(sql);
		//5、处理结果
		if(i > 0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		
	}
	
	@After
	public void after() throws SQLException {
		//6、释放资源
			st.close();
			conn.close();
	}
	//修改数据（将uid为6的用户名修改为玉兔精）
	@Test
	public void testUpdate() throws Exception {
		String sql = "update user set username = '玉兔精'  where uid = 7";
		//4、执行sql并返回结果
		int i = st.executeUpdate(sql);
		//5、处理结果
		if(i > 0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	//删除数据
	@Test
	public void testDelete() throws Exception {
		//1、注册驱动
		String sql = "delete  from user where uid = 7";
		//4、执行sql并返回结果
		int i = st.executeUpdate(sql);
		//5、处理结果
		if(i > 0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	
	//查询uid为5的用户
	@Test
	public void testFindByUid() throws Exception {
		String sql = "select * from user where uid = 5";
		//4、执行sql并返回结果
		ResultSet rs = st.executeQuery(sql);//快捷键：alt+shift+l
		//5、处理结果
		if(rs.next()) {
			System.out.println("用户名为："+rs.getString("username"));
		}
	}
	
	@Test
	public void testFengzhuang() throws Exception {
		String sql = "select * from user";
		//4、执行sql并返回结果
		ResultSet rs = st.executeQuery(sql);
		//5、处理结果
		List<User> ulist = new ArrayList<User>();
		while(rs.next()) {
		 //1、从数据库中获取数据
			//获取用户id
			int uid = rs.getInt(1);
			//获取用户名
			String username = rs.getString(2);
			//获取密码
			String password = rs.getString(3);
			//获取爱好
			String hobby = rs.getString(4);
		//2、创建User对象
			User user = new User();
		//3、将获取的数据封装到user对象中
			user.setUid(uid);
			user.setUsername(username);
			user.setPassword(password);
			user.setHobby(hobby);
		//4、将user对象添加到list集合中
			ulist.add(user);
		}
		//打印ulist
		System.out.println(ulist);
	}
	
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	

}
