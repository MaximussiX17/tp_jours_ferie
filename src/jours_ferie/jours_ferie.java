package jours_ferie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class jours_ferie {
	
	private ArrayList<String> date = new ArrayList();
	private ArrayList<String> annee = new ArrayList();
	private ArrayList<String> zone = new ArrayList();
	private ArrayList<String> nom_jour = new ArrayList();
	
	public jours_ferie() {
		readCsv();
		
	}
	
	public boolean afficheJour(int anneeChoisi) {
		if(anneeChoisi> 1999 && anneeChoisi<2026) {
			String strAnneeChoisi = Integer.toString(anneeChoisi);
			for(int i=0; i<this.date.size(); i++) {
				String a = this.date.get(i).split("-")[0];
				if(a.equals(strAnneeChoisi)) {
					System.out.println(this.date.get(i)+" "+this.nom_jour.get(i));
				}
			}
			// comme la fonction est un simple affichage pour les tests il est plus evident de retourner un boolean.
			// C'est aussi plus évident aussi par rapport au temps que l'on dispose.
			return true; 
		}else {
			System.out.println("mauvaise année pas de traitement");
			return false;
		}
	}
	
	public boolean jourFeriePasLeWeekEnd(int anneeChoisi) throws ParseException {
		if(anneeChoisi> 1999 && anneeChoisi<2026) {
			
			Calendar c = Calendar.getInstance();
			String strAnneeChoisi = Integer.toString(anneeChoisi);
			
			for(int i=0; i<this.date.size(); i++) {
				
				String a = this.date.get(i).split("-")[0];
				if(a.equals(strAnneeChoisi)) {
					Date d = new SimpleDateFormat("yyyy-MM-dd").parse(this.date.get(i));
					c.setTime(d);
					int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
					if(dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
						System.out.println(dayOfWeek+" : "+this.date.get(i)+" "+this.nom_jour.get(i));
					}
				}
			}
			return true;
		}else {
			System.out.println("mauvaise année pas de traitement");
			return false;
		}
	}
	
	
	public boolean nbJourOuvreEntre2dates(LocalDate start, LocalDate end) {
		System.out.println("AAAAAA : "+start.getYear() + " BBBBBB : "+ end.getYear());
		if (start.isAfter(end)) {
			System.out.println("ERROR : la date de début est après la date de fin");
			return false;
		}else if(start.getYear() <= 1999  || start.getYear() >= 2026) {
			System.out.println("ERROR : l'année de date de début n'est pas dans l'intervalle [2000; 2025] ");
			return false;
		}else if(end.getYear() <= 1999  || end.getYear() >= 2026) {
			System.out.println("ERROR : l'année de date de fin n'est pas dans l'intervalle [2000; 2025] ");
			return false;
		}else {
			
			int jourOuvre = 0;
			LocalDate d = start;
		    while (d.isBefore(end)) {
		      DayOfWeek dw = d.getDayOfWeek();
		      if (!this.date.contains(d) && dw != DayOfWeek.SATURDAY && dw != DayOfWeek.SUNDAY) {
		    	  jourOuvre++;
		      }
		      d = d.plusDays(1);
		    }
		    System.out.println("nombre de jours ouvre entre "+start+" et "+end+"  : "+jourOuvre+"");
			return true;
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
