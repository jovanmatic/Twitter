package com.twitter.poruke;
/**
 * Ovo je javna klasa TwitterPoruka. Sadrzi podatke o korisniku i poruci!
 * @author Asus
 * @version 1.0
 */
public class TwitterPoruka {
	/**
	 * Ovo je privatni atribut korisnik, tipa String.
	 */
	private String korisnik;
	/**
	 * Ovo je privatni atribut poruka, tipa String.
	 */
	private String poruka;
	/**
	 * Javna metoda getKorisnik vraca vrednost atributa korisnik.
	 * @return korisnik Ovo je povratna vrednost metode getKorisnik.
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Javna metoda setKorisnik kojom se dodeljuje odredjena vrednost atributu korisnik.
	 * @param korisnik Ovo je ulazni parametar.
	 * @throws java.lang.RuntimeException Ako je uneti korisnik:
	 * <ul>
	 * 	<li>null,</li>
	 * 	<li>prazan String.</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "") {
			throw new RuntimeException("Ime korisnika mora biti uneto");
		}
		this.korisnik = korisnik;
	}
	/**
	 * Javna metoda getPoruka koja vraca vrednost atributa poruka.
	 * @return poruka Ovo je povratna vrednost metode getPoruka.
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Javna metoda setPoruka kojom se dodeljuje odredjena vrednost atributu poruka.
	 * @param poruka Ulazni parametar ove metode.
	 * @throws java.lang.RuntimeException Ako je uneta poruka:
	 * <ul>
	 * 	<li>null,</li>
	 * 	<li>duza od 140 karaktera.</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140) {
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		}
		this.poruka = poruka;
	}
	/**
	 * Javna metoda toString vraca ime korisnika i sadrzaj poruke!
	 */
	public String toString(){
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
