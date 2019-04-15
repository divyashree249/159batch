package com.mphasis.training.dao;

import com.mphasis.training.exception.BuissnessException;
import com.mphasis.training.pojos.Fuser;

public interface FuserDao {
	public boolean login(String email,String password);
	public int register(Fuser fuser) ;
	public Fuser profile(String email)throws BuissnessException;
}
