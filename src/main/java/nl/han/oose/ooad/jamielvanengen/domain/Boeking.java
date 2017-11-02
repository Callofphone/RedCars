package nl.han.oose.ooad.jamielvanengen.domain;

import nl.han.oose.ooad.jamielvanengen.domain.abbonement.Abonnement;

import java.util.Calendar;
import java.util.Date;

public class Boeking {

	private Calendar begintijd;
	private Calendar eindtijd;
	private Auto auto;
	private RitRepository ritRepository;
    PrijzenCalculator calculator;

    public Boeking() {
	}

    public Boeking(Calendar begintijd, Calendar eindtijd, Auto auto) {
        this.begintijd = begintijd;
        this.eindtijd = eindtijd;
        this.auto = auto;
        ritRepository = new RitRepository();
        calculator = new PrijzenCalculator();
    }

    public Calendar getBegintijd() {
        return begintijd;
    }

    public Calendar getEindtijd() {
        return eindtijd;
    }

    public float berekenPrijs(Calendar ritStartTijd, Calendar ritEindtijd, float aantalKilometers, Abonnement abonnement) {
		AutoTypes type =  auto.getAutoType();
		Rit rit = new Rit(ritStartTijd, ritEindtijd, aantalKilometers);
		ritRepository.addRit(rit);
		return calculator.berekenPrijs(rit, eindtijd, type, abonnement, aantalKilometers);
	}

	private Auto getAuto() {
		return null;
	}

}
