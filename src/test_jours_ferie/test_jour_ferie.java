package test_jours_ferie;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

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
		// test annee inf
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
		// test annee inf
		assertFalse(j.jourFeriePasLeWeekEnd(invalidLimitSup));
		assertFalse(j.jourFeriePasLeWeekEnd(invalidSup));
	}

}
