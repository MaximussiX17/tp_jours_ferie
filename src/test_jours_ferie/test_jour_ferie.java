package test_jours_ferie;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import jours_ferie.jours_ferie;

class test_jour_ferie {

	@Test
	void testAfficheJour() {
		int invalidInf = 1859;
		int invalidLimitInf = 1999;
		int validLimitInf = 2000;
		int valid = 2020;
		int validLimitSup = 2025;
		int invalidLimitSup = 2026;
		int invalidSup = 2059;
		
		jours_ferie j = new jours_ferie();

		//tests annee inf
		assertFalse(j.afficheJour(invalidInf));
		assertFalse(j.afficheJour(invalidLimitInf));
		// test annee valid
		assertTrue(j.afficheJour(validLimitInf));
		assertTrue(j.afficheJour(valid));
		assertTrue(j.afficheJour(validLimitSup));
		// test annee sup
		assertFalse(j.afficheJour(invalidLimitSup));
		assertFalse(j.afficheJour(invalidSup));
	}
	
	@Test
	void testjourFeriePasLeWeekEnd() throws ParseException {
		int invalidInf = 1859;
		int invalidLimitInf = 1999;
		int validLimitInf = 2000;
		int valid = 2020;
		int validLimitSup = 2025;
		int invalidLimitSup = 2026;
		int invalidSup = 2059;
		
		jours_ferie j = new jours_ferie();

		//tests annee inf
		assertFalse(j.jourFeriePasLeWeekEnd(invalidInf));
		assertFalse(j.jourFeriePasLeWeekEnd(invalidLimitInf));
		// test annee valid
		assertTrue(j.jourFeriePasLeWeekEnd(validLimitInf));
		assertTrue(j.jourFeriePasLeWeekEnd(valid));
		assertTrue(j.jourFeriePasLeWeekEnd(validLimitSup));
		// test annee sup
		assertFalse(j.jourFeriePasLeWeekEnd(invalidLimitSup));
		assertFalse(j.jourFeriePasLeWeekEnd(invalidSup));
	}
	
	@Test
	void testnbJourOuvreEntre2dates() {
		
		jours_ferie j = new jours_ferie();
		
		LocalDate startINF = LocalDate.of(1920,Month.NOVEMBER,20);
		LocalDate endINF = LocalDate.of(1925,Month.OCTOBER,22);
		
		LocalDate startLimitINF = LocalDate.of(1999,Month.DECEMBER,30);
		LocalDate endLimitINF = LocalDate.of(1999,Month.DECEMBER,31);
		
		LocalDate start = LocalDate.of(2020,Month.NOVEMBER,20);
		LocalDate end = LocalDate.of(2020,Month.NOVEMBER,26);
		
		LocalDate startLimitSUP = LocalDate.of(2026,Month.JANUARY,01);
		LocalDate endLimitSUP = LocalDate.of(2026,Month.JANUARY,30);
		
		LocalDate startSUP = LocalDate.of(2030,Month.NOVEMBER,20);
		LocalDate endSUP = LocalDate.of(2030,Month.NOVEMBER,26);
		
		// test intervalle start after end
		assertFalse(j.nbJourOuvreEntre2dates(end,start));
		
		//tests intervalle inf
		assertFalse(j.nbJourOuvreEntre2dates(startINF,endINF));
		assertFalse(j.nbJourOuvreEntre2dates(startINF, end));
		
		//tests intervalle inf limit
		assertFalse(j.nbJourOuvreEntre2dates(startLimitINF,endLimitINF));
		
		// test intervalle valid
		assertTrue(j.nbJourOuvreEntre2dates(start,end));
		
		//tests intervalle sup limit
		assertFalse(j.nbJourOuvreEntre2dates(startLimitSUP,endLimitSUP));
		
		//tests intervalle sup
		assertFalse(j.nbJourOuvreEntre2dates(start,endSUP));
		assertFalse(j.nbJourOuvreEntre2dates(startSUP, endSUP));
		
		
	}

}
