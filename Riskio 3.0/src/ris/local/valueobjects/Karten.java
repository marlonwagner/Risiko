package ris.local.valueobjects;

import core.SpielbrettVerwaltung;

public class Karten {

	public enum Name {
		AUFTRAG1, AUFTRAG2, AUFTRAG3, AUFTRAG4, AUFTRAG5, AUFTRAG6, AUFTRAG7, AUFTRAG8, AUFTRAG9, AUFTRAG10, AUFTRAG11, AUFTRAG12, AUFTRAGWELT
	}

	private Name name;

	public Karten(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public boolean zielErreicht(int spielerNr, SpielbrettVerwaltung sw) {
		switch (name) {
		case AUFTRAG1:
			// Erobern Sie Europa, Australien und einen 3. Kontinent Ihrer Wahl
			return auftrag1bis3("Europa", "Australien", sw, spielerNr);

		case AUFTRAG2:

			// Erobern Sie Europa, Südamerika und einen 3. Kontinent Ihrer Wahl
			return auftrag1bis3("Europa", "Südamerika", sw, spielerNr);

		case AUFTRAG3:
			// Erobern Sie Europa, Afrika und einen 3. Kontinent Ihrer Wahl
			return auftrag1bis3("Europa", "Afrika", sw, spielerNr);

		case AUFTRAG4:
			// Erobern Sie Asien und Afrika
			return auftrag4bis6("Asien", "Afrika", sw, spielerNr);

		case AUFTRAG5:
			// Erobern Sie Nordamerika und Australien
			return auftrag4bis6("Nordamerika", "Australien", sw, spielerNr);

		case AUFTRAG6:
			// Erobern Sie Nordamerika und Afrika
			return auftrag4bis6("Nordamerika", "Afrika", sw, spielerNr);

		case AUFTRAG7:
			// Erobern Sie 24 Länder Ihrer Wahl
			return checkLaenderErobert(24, sw, spielerNr);

		case AUFTRAG8:
			// Erobern Sie 18 Länder Ihrer Wahl und besetzen sie jedes dieser
			// Länder mit mind. 2 Armeen
			return auftrag8(sw, spielerNr);

		case AUFTRAG9:
			// Vernichten Sie die Spieler 1 Armeen. Sind sie selber Spieler 1,
			// erobern Sie 24 Länder Ihrer Wahl
			return auftrag9bis13(1, sw, spielerNr);

		case AUFTRAG10:
			// Vernichten Sie alle Spieler 2 Armeen. Sind sie selber die Spieler 2,
			// erobern Sie 24 Länder Ihrer Wahl
			return auftrag9bis13(2, sw, spielerNr);

		case AUFTRAG11:
			// Vernichten Sie alle Spieler 3 Armeen. Sind sie selber die Spieler 3,
			// erobern Sie 24 Länder Ihrer Wah
			return auftrag9bis13(3, sw, spielerNr);

		case AUFTRAG12:
			// Vernichten Sie alle Spieler 4 Armeen. Sind sie selber die Spieler 4,
			// erobern Sie 24 Länder Ihrer Wahl
			return auftrag9bis13(4, sw, spielerNr);

		case AUFTRAGWELT:
			// Erobern Sie die gesamte Welt
			return checkLaenderErobert(42, sw, spielerNr);

		}
		return false;
	}

	public boolean auftrag1bis3(String kontinentN1, String kontinentN2, SpielbrettVerwaltung sw, int spielerNr) {
		Kontinent kontinent1 = sw.getKontinentArray()[0];
		Kontinent kontinent2 = sw.getKontinentArray()[0];
		for (Kontinent kontinent : sw.getKontinentArray()) {
			if (kontinent.getName().equals(kontinentN1)) {
				kontinent1 = kontinent;
			}
			if (kontinent.getName().equals(kontinentN2)) {
				kontinent2 = kontinent;
			}
		}
		for (Laender land : kontinent1.getLaenderArray()) {
			if (land.getBelegt() != spielerNr) {
				return false;
			}
		}
		for (Laender land : kontinent2.getLaenderArray()) {
			if (land.getBelegt() != spielerNr) {
				return false;
			}
		}
		for (Kontinent kontinent : sw.getKontinentArray()) {
			if (kontinent.getName().equals(kontinentN1) || kontinent.getName().equals(kontinentN2)) {
				continue;
			}

			for (Laender land : kontinent.getLaenderArray()) {
				if (land.getBelegt() == spielerNr) {
					continue;

				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean auftrag4bis6(String kontinentN1, String kontinentN2, SpielbrettVerwaltung sw, int spielerNr) {
		Kontinent kontinent1 = sw.getKontinentArray()[0];
		Kontinent kontinent2 = sw.getKontinentArray()[0];
		for (Kontinent kontinent : sw.getKontinentArray()) {
			if (kontinent.getName().equals(kontinentN1)) {
				kontinent1 = kontinent;
			}
			if (kontinent.getName().equals(kontinentN2)) {
				kontinent2 = kontinent;
			}
		}
		for (Laender land : kontinent1.getLaenderArray()) {
			if (land.getBelegt() != spielerNr) {
				return false;
			}
		}
		for (Laender land : kontinent2.getLaenderArray()) {
			if (land.getBelegt() != spielerNr) {
				return false;
			}
		}
		return true;
	}

	public boolean checkLaenderErobert(int laenderAnzahl, SpielbrettVerwaltung sw, int spielerNr) {
		int counter = 0;
		for (Kontinent kontinent : sw.getKontinentArray()) {
			for (Laender land : kontinent.getLaenderArray()) {
				if (land.getBelegt() == spielerNr) {
					counter++;
					if (counter == laenderAnzahl) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean auftrag8(SpielbrettVerwaltung sw, int spielerNr) {
		if (checkLaenderErobert(18, sw, spielerNr)) {
			for (Kontinent kontinent : sw.getKontinentArray()) {
				for (Laender land : kontinent.getLaenderArray()) {
					if (land.getBelegt() == spielerNr) {
						if (land.getEinheiten() > 1) {
							continue;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public boolean auftrag9bis13(int zielNr, SpielbrettVerwaltung sw, int spielerNr){
		if(spielerNr == zielNr){
			return checkLaenderErobert(24,sw,spielerNr);
		}
		for(Kontinent kontinent : sw.getKontinentArray()){
			for(Laender land : kontinent.getLaenderArray()){
				if(land.getBelegt() == zielNr){
					return false;
				}
			}
		} return true;
	}

	
}