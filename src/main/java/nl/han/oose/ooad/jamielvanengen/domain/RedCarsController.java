package nl.han.oose.ooad.jamielvanengen.domain;

import java.util.Calendar;
import java.util.Date;

public class RedCarsController {
    private GebruikerRepository gebruikerRepository;
    private Betaalmodule betaalmodule;

    public RedCarsController() {
        gebruikerRepository = new GebruikerRepository();
        betaalmodule = new Betaalmodule();
    }

	public void checkout(int kaartnummer, Calendar ritStartTijd, Calendar ritEindTijd, float aantalKilimeters) {
		Gebruiker gebruiker = gebruikerRepository.getGebruikerBijKaartnummer(kaartnummer);
		float prijs = gebruiker.getPrijsRit(ritStartTijd, ritEindTijd, aantalKilimeters);
		System.out.println("De prijs voor de rit is: " + prijs);
        betaalmodule.betalen(gebruiker.getRekeningnummer(), prijs);
	}

}
