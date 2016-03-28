package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TwitterPorukaTest {
	private TwitterPoruka tPoruka;
	@Before
	public void setUp() throws Exception {
		tPoruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tPoruka = null;
	}

	@Test
	public void testSetKorisnikSveJeOk() {
		String korisnik = "Jovan Matic";
		tPoruka.setKorisnik(korisnik);
		assertEquals(korisnik, tPoruka.getKorisnik());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tPoruka.setKorisnik(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tPoruka.setKorisnik("");
	}

	@Test
	public void testSetPorukaSveJeOk() {
		String poruka = "Danas je bio lep i suncan dan. Bio sam na fakultetu od 2 do 6. Sada odmaram, a posle cu da ucim.";
		tPoruka.setPoruka(poruka);
		assertEquals(poruka, tPoruka.getPoruka());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tPoruka.setPoruka(null);;
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzaOd140() {
		tPoruka.setPoruka("Holandija je parlamentarna demokratija i ustavotvorna monarhija. Kralj je vladar drzave i on predstavlja drzavu u svetu. Izvrsnu vlast ima Savet ministara Kraljevine Holandije. Sudsku vlast ima vrhovni sud. Holandija ima dvodomni parlament (gornji dom ima 75, a donji 150 clanova)!");;
	}
	
	@Test
	public void testToStringSveJeOk() {
		String korisnik = "Jovan Matic";
		String poruka = "Ovo je nova Twitter poruka";
		tPoruka.setKorisnik(korisnik);
		tPoruka.setPoruka(poruka);
		assertEquals("KORISNIK:" + korisnik + " PORUKA:" + poruka, tPoruka.toString());
	}
}
