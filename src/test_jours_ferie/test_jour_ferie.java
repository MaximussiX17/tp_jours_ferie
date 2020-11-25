package test_jours_ferie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jours_ferie.jours_ferie;

class test_jour_ferie {

	@Test
	void testAfficheJour() {
		jours_ferie j = new jours_ferie();
		j.afficheJour(2020);
	}

}
