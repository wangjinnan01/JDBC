package com.offcn.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.offcn.utils.JdbcUtils;

public class PreDemo1 {
	
	@Test
	public void testAdd() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into user values(null,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		//为占位符赋值
		ps.setString(1, "白骨精");
		ps.setString(2, "88888");
		ps.setString(3, "吃唐僧肉");
		//执行sql并返回结果
		int i  = ps.executeUpdate();
		System.out.println(i);
		
		JdbcUtils.close(null, ps, conn);
	}
	
	//修改
	@Test
	public void testUpdate() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update user set username = ? where uid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		//为占位符赋值
		ps.setString(1, "玉兔精");
		ps.setInt(2, 8);
		//执行sql并返回结果
		int i  = ps.executeUpdate();
		System.out.println(i);
		
		JdbcUtils.close(null, ps, conn);
	}
	//删除
	@Test
	public void testDelete() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from user  where uid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		//为占位符赋值
		ps.setInt(1, 8);
		//执行sql并返回结果
		int i  = ps.executeUpdate();
		System.out.println(i);
		
		JdbcUtils.close(null, ps, conn);
	}
	//根据id查询
	@Test
	public void testFindByUid() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from user  where uid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		//为占位符赋值
		ps.setInt(1, 5);
		//执行sql并返回结果
	
		ResultSet rs = ps.executeQuery();
	
		if(rs.next()) {
			System.out.println(rs.getString("username"));
		}
		JdbcUtils.close(null, ps, conn);
	}

}
