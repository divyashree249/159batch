package com.mphasis.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mphasis.training.dao.FuserDao;
import com.mphasis.training.exception.BuissnessException;
import com.mphasis.training.pojos.Fuser;
import com.mphasis.training.util.DbUtil;

public class FuserDaoImpl implements FuserDao {
	Connection con;
	 public FuserDaoImpl() {
	con=DbUtil.getConnection();
	 }
	
	@Override
	public boolean login(String email, String password) {
		boolean status=false;
		try {
			String sql="select email,pass from fuser where email=? and pass=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
					
		}catch (Exception e) {
		e.printStackTrace();
		}
		return status;
	}

	@Override
	public int register(Fuser fuser) {
		int i=0;
		try {
			String sql="insert into fuser values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, fuser.getEmail());
			ps.setString(2, fuser.getPass());
			ps.setString(3, fuser.getGender());
			ps.setString(4, fuser.getCity());
			ps.setString(5, fuser.getDob());
			i=ps.executeUpdate();
	
		}catch (Exception e) {
		e.printStackTrace();
		}
		return i;
	}

	@Override
	public Fuser profile(String email) throws BuissnessException {
		Fuser fuser=new Fuser();
		try {	
			String sql="select * from fuser where email=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				fuser.setEmail(rs.getString(1));
				fuser.setPass(rs.getString(2));
				fuser.setGender(rs.getString(3));
				fuser.setCity(rs.getString(4));
				fuser.setDob(rs.getString(5));
			}
			throw new BuissnessException("user does not exist");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fuser;
	}
}
