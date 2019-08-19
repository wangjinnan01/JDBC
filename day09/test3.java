package com.offcn.demo1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.offcn.utils.JdbcUtils;

public class Demo3 {
	
	public static void main(String[] args) throws SQLException {
		//添加数据
		Connection conn = JdbcUtils.getConnection();
		Statement st = conn.createStatement();
		String sql = "select * from user";
			//4、发送sql语句并返回结果
		ResultSet rs = st.executeQuery(sql);
			//5、处理结果
		while(rs.next()) {
			int uid = rs.getInt(1);
			String username = rs.getString(2);
			String password = rs.getString(3);
			String hobby = rs.getString(4);
			System.out.println("用户id为："+uid+"，用户名为："+username+"，密码为："+password
					+"，爱好为:"+hobby);
		}
			//6、关闭资源（建议倒序关闭）
		JdbcUtils.close(rs, st, conn);
	}

}
