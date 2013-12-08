/*
 * Crer une classe heure, qui prend les heures, minutes et secondes.
 * Crer un constructeur qui prend trois arguments.
 * Ecrire les getters & setters
 * Ecrire une mthode qui retour l'heure ˆ la seconde suivante
 */


public class Heure {

	/**
	 * Attributs
	 */
	private int heure;
	private int minute;
	private int seconde;
	
	
	public int getHeure() { return this.heure; }
	public int getMinute() { return this.minute; }
	public int getSeconde() { return this.seconde; }
	
	public void setHeure(int h) {
		if (h < 0 || h > 23) {
			this.heure = 0;
		} else {
			this.heure = h;
		}
	}
	
	public void setMinute(int m) {
		if (m < 0 || m > 59) {
			this.minute = 0;
		} else {
			this.minute = m;
		}
	}
	
	public void setSeconde(int s) {
		if (s < 0 || s > 59) {
			this.seconde = 0;
		} else {
			this.seconde = s;
		}
	}
	
	/**
	 * Constructeur de la classe
	 * @param h les heures
	 * @param m les minutes
	 * @param s les secondes
	 */
	public Heure(int h, int m, int s) {
		this.setHeure(h);
		this.setMinute(m);
		this.setSeconde(s);
	}


	public Heure nextSecond() {
		int heure, minute, seconde;
		
		heure = this.heure;
		minute = this.minute;
		seconde = this.seconde;
		
		if (seconde < 59) {
			seconde++;
		} else if (seconde == 59) {
			seconde = 0;
			if (minute < 59) {
				minute++;
			} else if (minute == 59) {
				minute = 0;
				if (heure < 23) {
					heure++;
				} else if (heure == 23) {
					heure = 0;
				}
			}
		}
		return new Heure(heure, minute, seconde);
	}
	
}
