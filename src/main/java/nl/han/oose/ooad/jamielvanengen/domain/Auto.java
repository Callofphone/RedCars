package nl.han.oose.ooad.jamielvanengen.domain;

public class Auto {

	private String kenteken;

	private Plaats standplaats;

	private AutoTypes type;

    public Auto(String kenteken, Plaats standplaats, AutoTypes type) {
        this.kenteken = kenteken;
        this.standplaats = standplaats;
        this.type = type;
    }

    public AutoTypes getAutoType() {
		return type;
	}

}
