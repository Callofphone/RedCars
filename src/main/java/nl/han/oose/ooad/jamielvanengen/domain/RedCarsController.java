package nl.han.oose.ooad.jamielvanengen.domain;

import java.util.Calendar;
import java.util.Date;

public class RedCarsController {
    private GebruikerRepository gebruikerRepository;
    private AutoRepository autoRepository;
    private Betaalmodule betaalmodule;
    private BoekingFactory boekingFactory;

    public RedCarsController() {
        gebruikerRepository = new GebruikerRepository();
        autoRepository = new AutoRepository();
        betaalmodule = new Betaalmodule();
        boekingFactory = new BoekingFactory();
    }

	public void checkout(int kaartnummer, Calendar ritStartTijd, Calendar ritEindTijd, float aantalKilimeters) {
		Gebruiker gebruiker = gebruikerRepository.getGebruikerBijKaartnummer(kaartnummer);
		float prijs = gebruiker.getPrijsRit(ritStartTijd, ritEindTijd, aantalKilimeters);
		System.out.println("De prijs voor de rit is: " + prijs);
        betaalmodule.betalen(gebruiker.getRekeningnummer(), prijs);
	}

	public void reserveer(int kaartnummer, String kenteken, Calendar begintijd, Calendar eindtijd) {
        Gebruiker gebruiker = gebruikerRepository.getGebruikerBijKaartnummer(kaartnummer);
        Auto auto = autoRepository.getAutoByKenteken(kenteken);
        Boeking boeking = boekingFactory.createBoeking(begintijd, eindtijd, auto);
        gebruiker.reserveer(boeking);
    }
}
