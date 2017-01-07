package nas.xoledas.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import nas.xoledas.beans.SpeedTest;
import nas.xoledas.hibernate.HibernateUtils;

public class NasService {
	
	/** Constructeur privé */
	private NasService() {}
	
	/** Log4j **/
	final static Logger log = Logger.getLogger(NasService.class);
 
	/** Instance unique non préinitialisée */
	private static NasService INSTANCE = null;
 
	/** Point d'accès pour l'instance unique du singleton */
	public static NasService getInstance() {			
		if (INSTANCE == null) {
			INSTANCE = new NasService();	
		}
		return INSTANCE;
	}
	
	public boolean insertData(Integer ping, Integer up, Integer down) {
		boolean success = false;
		
		log.info("HLA-passage dans ma classe service");
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        SpeedTest st = new SpeedTest(ping,up,down);
        Long id = (Long) session.save(st);
      
        session.getTransaction().commit();

        success = (id != 0) ? true : false;
        
        session.close();
		
		return success;
	}
	
	public ArrayList<SpeedTest> getSpeedtestList() {
		
		return new ArrayList();
	}

}
