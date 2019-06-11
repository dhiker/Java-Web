package service;

import dao.DaoTest;
import vo.Account;

public class Check {
	public boolean checkAccount(String id, String pw) {
		DaoTest dao= new DaoTest();
		Account a= new Account();
		
		if(id.isEmpty() || pw.isEmpty()){
			return false;
		}else {
			a= dao.getQuery(id);
			
			if(a.getId().equals(id) && a.getPw().equals(pw))
					return true;
			
			return false;
		}
	}
}
