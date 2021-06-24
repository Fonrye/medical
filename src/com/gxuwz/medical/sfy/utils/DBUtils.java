package com.gxuwz.medical.sfy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DBUtils {

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/medical?characterEncoding=utf-8";
			String user = "root";
			String password = "123456";
			
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//封装增加删除修改的通用工具方法
		/**
		 * sql SQL语句
		 * objs	SQL语句占位符实参，如果没有参数则传入null
		 * 返回增删改的结果，类型为int
		 */
		public static int executeDML(String sql,Object...objs){
			//声明jdbc变量
			   Connection conn = null;
			   PreparedStatement ps = null;
			   int i = -1;
			   try{
				   //获取连接对象
				    conn = DBUtils.getConnection();
				   //开启事务管理
				    conn.setAutoCommit(false);
				    //创建sql命令行
				    ps = (PreparedStatement) conn.prepareStatement(sql);
				    //给占位符赋值
				    if(objs!=null){
				    	for(int j=0;j<objs.length;j++){
				    		ps.setObject(j+1, objs[j]);
				    	}
				    }
				    //执行sql
				    i = ps.executeUpdate();
				    conn.commit();
			   }catch(Exception e){
				   try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				   e.printStackTrace();
			   }finally{
				   DBUtils.close(conn, ps, null);
			   }
			   return i;
		}

	
	public static boolean saveOrUpdate(String sql, Object[]params) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			if(params != null && params.length>0) {
				for(int i=0; i<params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * 封装一个查询通用的方法
	 * @param sql
	 * @param objs
	 * @return
	 */
	public static ResultSet query(String sql, Object... objs) {
		//声明变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = -1;
		try {
			//获取连接对象
			conn = DBUtils.getConnection();
			//开启事物管理
			conn.setAutoCommit(false);
			//创建sql命令
			ps = (PreparedStatement) conn.prepareStatement(sql);
			//给占位符
			if(objs != null) {
				for(int j=0;j<objs.length;j++) {
					ps.setObject(j+1, objs[j]);
				}
			}
			//执行sql
			rs = ps.executeQuery();
			//提交事物
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void close(Connection conn, PreparedStatement ps) {
		try {
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void close(Connection conn, PreparedStatement ps,ResultSet re) {

		try {
			re.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
