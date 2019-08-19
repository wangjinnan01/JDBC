package com.offcn.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo1 {
	
	//添加数据
	@Test
	public void testAdd() throws Exception {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///day09", "root", "1234");
		//3、获取发送sql语句的对象
		Statement st = conn.createStatement();
		String sql = "insert into user values(null,'白骨精', '77777','吃唐僧肉')";
		//4、执行sql并返回结果
		int i = st.executeUpdate(sql);
		//5、处理结果
		if(i > 0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		//6、释放资源
		st.close();
		conn.close();
	}
	//修改数据（将uid为6的用户名修改为玉兔精）
	@Test
	public void testUpdate() throws Exception {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///day09", "root", "1234");
		//3、获取发送sql语句的对象
		Statement st = conn.createStatement();
		String sql = "update user set username = '玉兔精'  where uid = 6";
		//4、执行sql并返回结果
		int i = st.executeUpdate(sql);
		//5、处理结果
		if(i > 0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		//6、释放资源
		st.close();
		conn.close();
	}
	//删除数据
	@Test
	public void testDelete() throws Exception {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///day09", "root", "1234");
		//3、获取发送sql语句的对象
		Statement st = conn.createStatement();
		String sql = "delete  from user where uid = 6";
		//4、执行sql并返回结果
		int i = st.executeUpdate(sql);
		//5、处理结果
		if(i > 0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		//6、释放资源
		st.close();
		conn.close();
	}
	
	//查询uid为5的用户
	@Test
	public void testFindByUid() throws Exception {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///day09", "root", "1234");
		//3、获取发送sql语句的对象
		Statement st = conn.createStatement();
		String sql = "select * from user where uid = 5";
		//4、执行sql并返回结果
		ResultSet rs = st.executeQuery(sql);//快捷键：alt+shift+l
		//5、处理结果
		if(rs.next()) {
			System.out.println("用户名为："+rs.getString("username"));
		}
		//6、释放资源
		st.close();
		conn.close();
	}
	
	@Before
	public void before() {
		System.out.println("before");
	}
	@Test
	public void test2() {
		System.out.println("test2");
	}
	@After
	public void after() {
		System.out.println("after");
	}
	

}
