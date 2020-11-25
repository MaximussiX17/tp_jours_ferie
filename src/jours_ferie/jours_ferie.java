package jours_ferie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class jours_ferie {
	
	private ArrayList<String> date = new ArrayList();
	private ArrayList<String> annee = new ArrayList();
	private ArrayList<String> zone = new ArrayList();
	private ArrayList<String> nom_jour = new ArrayList();
	
	public jours_ferie() {
		readCsv();
		
	}
	
	public void afficheJour(int anneeChoisi) {
		if(anneeChoisi> 1999 && anneeChoisi<2026) {
			String strAnneeChoisi = Integer.toString(anneeChoisi);
			for(int i=0; i<this.date.size(); i++) {
				String a = this.date.get(i).split("-")[0];
				//System.out.println(a);
				if(a.equals(strAnneeChoisi)) {
					System.out.println(this.date.get(i)+" "+this.nom_jour.get(i));
				}
				
			}
		}else {
			System.out.println("mauvaise année pas de traitement");
		}
	}
	
	public void readCsv()  {
		String csvFile = "jours_feries_metropole.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[]jours = line.split(cvsSplitBy);

                //System.out.println("jour ferier [date= " + jours[0]+ " , annee=" + jours[1]+ ", zone= "+jours[2]+", nom jour= "+jours[3]+"]");
                this.date.add(jours[0]);
                this.annee.add(jours[1]);
                this.zone.add(jours[2]);
                this.nom_jour.add(jours[3]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
}
