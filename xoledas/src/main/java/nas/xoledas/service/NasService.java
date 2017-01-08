package nas.xoledas.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
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
        
        SpeedTest st = new SpeedTest(ping,up,down,new Date());
        Long id = (Long) session.save(st);
      
        session.getTransaction().commit();

        success = (id != 0) ? true : false;
        
        session.close();
		
		return success;
	}
	
	public List<SpeedTest> getSpeedtestList() {
		List<SpeedTest> listST = new ArrayList<SpeedTest>();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy/dd");
		
		Session sess = HibernateUtils.getSessionFactory().openSession();
        sess.beginTransaction();
        
		Criteria crit = sess.createCriteria(SpeedTest.class);
		crit.setMaxResults(50);
		listST = crit.list();
		
		for (SpeedTest st : listST) {
			
		}
		
		return listST;
	}

}
