package portfolio.dao;

import java.sql.*;
import java.util.*;

import portfolio.pojo.GreenLabel;

public class GreenLabelsDAO implements DataAccess {
	   
	private GreenLabel addLabel(ResultSet rs) {
	      GreenLabel label = new GreenLabel();
	      try {
	         label.setId(rs.getInt("id"));
	         label.setName(rs.getString("name"));
	         label.setDescription(rs.getString("description"));
	      } catch (SQLException ex) {
	      }
	      return label;
	   }
	
	public List<GreenLabel> getLabels() {
	      String sql = "Select * from loanlabels order by name";
	      List<GreenLabel> labelList = new ArrayList<>();
	      try {
	         Class.forName(DRIVER);
	         Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);
	         while (rs.next()) {
	            GreenLabel label = addLabel(rs);
	            labelList.add(label);
	         }
	         rs.close();
	         con.close();
	      } catch (ClassNotFoundException | SQLException ex) {
	      }
	      return labelList;
	   }

	public List<GreenLabel> getLabelByName(String name) {
	      String sql = "Select * from loanlabels where name like '%" + name + "%'";
	      List<GreenLabel> labelList = new ArrayList<>();
	      try {
	         Class.forName(DRIVER);
	         Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);
	         while (rs.next()) {
	            GreenLabel label = addLabel(rs);
	            labelList.add(label);
	         }
	         rs.close();
	         con.close();
	      } catch (ClassNotFoundException | SQLException ex) {
	      }
	      return labelList;
	   }
	}
