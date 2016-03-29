package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;
/**
 * Ovo je javna klasa Twitter, u okviru paketa com.twitter! 
 * @author Jovan Matic 124/14
 * @version 1.0
 */
public class Twitter {
	/**
	 * Ovaj atribut je lista objekata klase TwitterPoruka.
	 */
	private LinkedList <TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Metoda koja vraca listu objekata klase TwitterPoruka!
	 * @return poruke Povratna vrednost ove metode je lista objekata klase TwitterPoruka.
	 */
	public LinkedList <TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Ovo je metoda koja kreira novi objekat klase TwitterPoruka, popunjava njegove atribute
	 * i smesta objekat na poslednje mesto u listi!
	 * @param korisnik Ulazni parametar ove metode. Novi korisnik.
	 * @param poruka Ulazni parametar ove metode. Nova poruka.
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda koja pretrazuje listu, na osnovu taga koji je tipa String i predstavlja
	 * ulazni parametar. Metoda zatim puni kreirani niz, porukama koje sadrze prosledjeni tag,
	 * sve do maxBroja. Na kraju, metoda vraca tako popunjen niz.
	 * @param maxBroj Ulazni parametar. Maksimalan broj objekata u nizu.
	 * @param tag Ulazni parametar. Pocetni tag, koji odredjuje koje poruke se ubacuju u niz.
	 * @return rezultat Niz koji sadrzi sve objekte, cije poruke sadrze pocetni tag.
	 * @throws java.lang.RuntimeException Ako je uneti tag:
	 * <ul>
	 *  <li>null,</li>
	 *  <li>prazan String.</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "") {
			throw new RuntimeException("Morate uneti tag");
		}
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0) {
			maxBroj = 100;
		}
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++) {
			if (poruke.get(i).getPoruka().indexOf(tag) != -1) {
				if (brojac < maxBroj){
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else break;
			}
		}
		return rezultat;
	}
}
