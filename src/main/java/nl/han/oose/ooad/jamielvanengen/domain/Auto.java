package nl.han.oose.ooad.jamielvanengen.domain;

public class Auto {

	private String kenteken;

	private String standplaats;

	private AutoTypes type;

    public Auto(String kenteken, String standplaats, AutoTypes type) {
        this.kenteken = kenteken;
        this.standplaats = standplaats;
        this.type = type;
    }

    public AutoTypes getAutoType() {
		return type;
	}

}
