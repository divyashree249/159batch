package com.mphasis.training.boimpl;

import java.util.Date;
import java.util.List;

import com.mphasis.training.bo.PlayerBO;
import com.mphasis.training.dao.PlayerDao;
import com.mphasis.training.daoimpl.PlayerDaoImpl;
import com.mphasis.training.exceptions.BuissnesException;
import com.mphasis.training.pojo.Player;

public class PlayerBOImpl implements PlayerBO {
	PlayerDao playerDao=null;
	
	public PlayerBOImpl() {
	playerDao=new PlayerDaoImpl();
	}
	
	@Override
	public Player getPlayerById(int id) throws BuissnesException {
		Player player = null;
		if (id > 1 && id < 11) {
			// code for DAO
			
			player = playerDao.getPlayerById(id);
		} else {
			throw new BuissnesException("Entered ID is invalid");
		}

		return player;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BuissnesException {
		List<Player> playerList = null;
		if (gender != null && gender.matches("[mMfF]{1}")) {
			// code for dao
			playerList = playerDao.getPlayerByGender(gender);
		} else {
			throw new BuissnesException("Enter gender " + gender + " is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BuissnesException {
		List<Player> playerList = null;
		// code for dao
		if (age > 21 && age < 58) {
			playerList = playerDao.getPlayerByAge(age);
		} else {
			throw new BuissnesException("Entered age " + age + " is invalid");
		}
		return playerList;
	}

	@Override
	public Player getPlayerByEmail(String email) throws BuissnesException {
		Player player = null;
		if (email != null && email.matches("[a-zA-Z0-9]{4,15}@gmail.com")) {
			// code for dao
			
			player = playerDao.getPlayerByEmail(email);
		} else {
			throw new BuissnesException("Entered email " + email + " is invalid");
		}
		return player;
	}

	@Override
	public Player getPlayerByNumber(Long contact) throws BuissnesException {
		Player player = null;
		if (contact >1L) {
			// code for DAO
			
			player = playerDao.getPlayerByContact(contact);
		} else {
			throw new BuissnesException("Entered number is invalid");
		}

		return player;
	}

	@Override
	public List<Player> getPlayersByTeamname(String teamname) throws BuissnesException {
		List<Player> playerList = null;
		if (teamname != null && teamname.matches("[a-zA-Z]{2,9}")) {
			
			playerList = playerDao.getPlayerByTeamname(teamname);
		} else {
			throw new BuissnesException("Entered Teamname " + teamname + " is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByName(String name) throws BuissnesException {
		List<Player> playerList = null;
		if (name != null && name.matches("[a-zA-Z]{1,}")) {
			
			playerList = playerDao.getPlayerByName(name);
		} else {
			throw new BuissnesException("Entered Name " + name + " is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByDob(Date dob) throws BuissnesException {
		List<Player> playerList = null;
		if (dob != null) {
			playerList = playerDao.getPlayerByDob(dob);
		} else {
			throw new BuissnesException("Entered Name " + dob + " is invalid");
		}
		return playerList;
	}

	@Override
	public void addPlayer(Player p) {
		// TODO Auto-generated method stub
		playerDao.addPlayer(p);
	}

	@Override
	public int deletePlayer(int id) {
		// TODO Auto-generated method stub
		return playerDao.deletePlayer(id);
	}

	@Override
	public int updateScore(int id, long score) {
		// TODO Auto-generated method stub
		return playerDao.updateScore(id, score);
	}

	@Override
	public List<Player> getAllPlayers() throws BuissnesException {
		// TODO Auto-generated method stub
		return playerDao.getAllPlayers();
	}

}
