package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		tp1.setKorisnik("Petar Petrovic");
		tp1.setPoruka("Dobar dan!");
		tp2.setKorisnik("Nikola Nikolic");
		tp2.setPoruka("Laku noc!");
		
		t.unesi("Petar Petrovic", "Dobar dan!");
		t.unesi("Nikola Nikolic", "Laku noc!");
		
		assertEquals(tp1.getKorisnik(), t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals(tp1.getPoruka(), t.vratiSvePoruke().get(0).getPoruka());
		assertEquals(tp2.getKorisnik(), t.vratiSvePoruke().get(1).getKorisnik());
		assertEquals(tp2.getPoruka(), t.vratiSvePoruke().get(1).getPoruka());
	}

	@Test
	public void testUnesi() {
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Petar Petrovic");
		tp1.setPoruka("Dobar dan!");
		
		t.unesi("Petar Petrovic", "Dobar dan!");
		assertEquals(tp1.getKorisnik(), t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals(tp1.getPoruka(), t.vratiSvePoruke().get(0).getPoruka());
	}

	@Test
	public void testVratiPorukeSveJeOk() {
		t.unesi("Petar Petrovic", "Dobar dan!");
		t.unesi("Nikola Nikolic", "Laku noc!");
		t.unesi("Jovan Jovanovic", "Ja se zovem Jovan.");
		t.unesi("Marko Markovic", "Dobar dan.");
		
		TwitterPoruka[] tPoruka = new TwitterPoruka[2];
		tPoruka[0] = new TwitterPoruka();
		tPoruka[1] = new TwitterPoruka();
		tPoruka[0].setKorisnik("Petar Petrovic");
		tPoruka[0].setPoruka("Dobar dan!");
		tPoruka[1].setKorisnik("Marko Markovic");
		tPoruka[1].setPoruka("Dobar dan.");
		//Koristimo assertArrayEquals zato sto hocemo da uporedimo 2 niza!
		assertArrayEquals(tPoruka, t.vratiPoruke(2, "Dobar"));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(3, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(3, "");
	}
}
