package nas.xoledas.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import nas.xoledas.beans.SpeedTest;
import nas.xoledas.hibernate.HibernateUtils;
import nas.xoledas.utils.NasUtils;

public class NasService {
	
	/** Constructeur privé */
	private NasService() {}
	
	/** Log4j **/
	final static Logger log = Logger.getLogger(NasService.class);
 
	/** Instance unique préinitialisée */
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
		SpeedTest st = null;
		
		log.info("Entrée dans la fonction d'enregistrement");
		
		try {
			//ouverture session hibernate
			Session session = HibernateUtils.getSessionFactory().openSession(); 
	        session.beginTransaction();
	        
	        //création de l'objet speed test pour enregistrer en bdd les données du test effectué
	        st = new SpeedTest(ping,up,down,new Date());
	        Long id = (Long) session.save(st);
	      
	        session.getTransaction().commit();
	
	        //paramétrage de la variable de réussite, pour le retour vers le script shell
	        success = (id != 0) ? true : false;
	        
	        session.close();
        
		} catch (Exception e) {
			log.error("Erreur lors de la création ou l'enregistrement de l'objet. Erreur : " + e.getMessage());
		}
		
		log.info("Fin de l'enregistrement d'un test en base de données. ST : " + st.toString());
		
		return success;
	}
	
	public HashMap<String,Object> getSpeedtestList(String dateD,String dateF) {
		//Liste contenant les speed tests récupérés deluis la bdd
		List<SpeedTest> listST = new ArrayList<SpeedTest>();
		//map de retour final des objets bien formatés
		HashMap<String,Object> formattedReturnMap = null;
		//date début et fin, si présentes
		Date dated = null;
		Date datef = null;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		log.info("Début de traitement récupération & formattage liste speedtest");
		
		try {
			//ouverture session hibernate
			Session sess = HibernateUtils.getSessionFactory().openSession();
	        sess.beginTransaction();
	        
	        //traitement des paramètres de dates
	        if (dateD != null && dateD != "") {
	        	System.out.println("date d :"+dateD);
	        	dated = df.parse(dateD);
	        }
	        if (dateF != null && dateF != "") {
	        	System.out.println("date f :"+dateF);
	        	datef = df.parse(dateF);
	        }
	        
	        //requête pour récupérer les speedtests (tous depuis 1 mois, ou si paramètres en fonction des paramètres)
			Criteria crit = sess.createCriteria(SpeedTest.class);
			crit.setMaxResults(50);
			if (dated != null) {
				crit.add(Restrictions.ge("dateTest", dated));
			}
			if (datef != null) {
				crit.add(Restrictions.le("dateTest", datef));
			}
			listST = crit.list();
			
			sess.close();
			
		} catch (Exception e) {
			log.error("Erreur lors de la récupération des tests en bdd. Error : " + e.getMessage());
		}
		
		try {
			//appel de la classe utilitaire qui va transformer les objets speedtest en une map avec
			//valeurs séparées pour bien être intégrées au graphique chart.js
			if (listST != null && listST.size() > 0) {
				NasUtils utils = new NasUtils();
				formattedReturnMap = utils.formatListSpeedTest(listST);
			}
		} catch (Exception e) {
			log.error("Erreur lors du traitement de formattage des speedtests. Error : " + e.getMessage());
		}
		
		log.info("Fin récupération et traitement liste speed test. Liste : " + formattedReturnMap.toString() );
		
		return formattedReturnMap;
	}

}
