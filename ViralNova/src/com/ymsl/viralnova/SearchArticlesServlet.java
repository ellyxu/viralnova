package com.ymsl.viralnova;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.alibaba.fastjson.JSON;

public class SearchArticlesServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		ArrayList<Article> articles = searchArticles();
		String jsonString = JSON.toJSONString(articles);
		
//		jsonString = new String(jsonString.getBytes("GB2312"), "8859_1");
		
		OutputStream out = res.getOutputStream();
		out.write(jsonString.getBytes("GB2312"));
		
		out.close();
		
	}

	private ArrayList<Article> searchArticles() {
		ArrayList<Article> articles = new ArrayList<Article>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select title,url,date,category,imageUrl,entryContent,content from articles order by id desc");
			while (rs.next()) {
				Article article = new Article();
				article.setTitle(rs.getString("title"));
				article.setUrl(rs.getString("url"));
				article.setDate(rs.getString("date"));
				article.setCategory(rs.getString("category"));
				article.setImageUrl(rs.getString("imageUrl"));
				article.setEntryContent(rs.getString("entryContent"));
				article.setContent(rs.getString("content"));
				articles.add(article);
			}
		} catch (Exception e) {
			throw new RuntimeException("获取数据库连接失败。");
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}

		return articles;
	}

}
