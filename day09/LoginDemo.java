package com.offcn.demo1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.offcn.utils.JdbcUtils;

public class LoginDemo {
	
	public static void main(String[] args) throws SQLException {
		//创建Scanner对象
		Scanner sc = new Scanner(System.in);
		//接收输入的用户名
		System.out.println("请输入用户名：");
		String username = sc.nextLine();
		//接收输入的密码
		System.out.println("请输入密码：");
		String password = sc.nextLine();
	 
		//使用用户名密码进行登录
		   //获取连接对象
		   Connection conn = JdbcUtils.getConnection();
		   //获取Statement
		   Statement st = conn.createStatement();
		   String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
		   //执行sql返回结果
		   ResultSet rs = st.executeQuery(sql);
		   //判断结果
		   if(rs.next()) {
			   System.out.println("欢迎您："+rs.getString("username"));
		   }else {
			   System.out.println("您输入的用户名或者密码不正确！！！");
		   }
		   
	}

}
