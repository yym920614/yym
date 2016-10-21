package org.zerock.service;

import java.util.Date;
import org.zerock.persistence.TimeDAO;

public class TimeService {
	
	private TimeDAO dao;
	public TimeService(){
		dao = new TimeDAO();
	}
	
	
	public String getNow()throws Exception{
		
		return dao.getSysdate();
		
	}

}
