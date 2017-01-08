package nas.xoledas.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import nas.xoledas.beans.SpeedTest;

public class NasUtils {
	
	SimpleDateFormat df1 = new SimpleDateFormat("dd/MM");
	
	public HashMap<String,Object> formatListSpeedTest(List<SpeedTest> listST) {
		//Map de travail contenant toutes les données
		HashMap<String,Object> workMap = new HashMap<String,Object>();
		//Sous liste contenant la liste des pings, upload et download
		ArrayList<Integer> pingList = new ArrayList<Integer>();
		ArrayList<Integer> uploadList = new ArrayList<Integer>();
		ArrayList<Integer> downloadList = new ArrayList<Integer>();
		ArrayList<String> dateList = new ArrayList<String>();
		
		//trie de la liste de la date la plus ancienne à la plus récente
		Collections.sort(listST, new Comparator<SpeedTest>() {
			  public int compare(SpeedTest o1, SpeedTest o2) {
			      return o1.getDateTest().compareTo(o2.getDateTest());
			  }
			});
		
		//Boucle sur la liste des speedtests pour leur affectation dans la liste adequat
		for (SpeedTest st : listST) {
			pingList.add(st.getPing());
			uploadList.add(st.getUpload());
			downloadList.add(st.getDownload());
			dateList.add("'"+df1.format(st.getDateTest())+"'");
		}
		
		//on ajoute tout dans la map générale
		workMap.put("lping", pingList);
		workMap.put("lupload", uploadList);
		workMap.put("ldownload", downloadList);
		workMap.put("ldate", dateList);
		
		return workMap;
	}

}
