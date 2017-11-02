package nl.han.oose.ooad.jamielvanengen.domain;

import nl.han.oose.ooad.jamielvanengen.domain.abbonement.Abonnement;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class PrijzenCalculator {

    private PrijzenLijstFactory prijzenLijstFactory;

    public PrijzenCalculator() {
        prijzenLijstFactory = new PrijzenLijstFactory();
    }

	public float berekenPrijs(Rit rit, Calendar boekingEindTijd,  AutoTypes autoType, Abonnement abonnement, float aantalKilometers) {
        PrijzenLijst prijzenLijst = prijzenLijstFactory.buildPrijzenLijst(abonnement, autoType);
        float prijs = getKostenPerTypeAutoEnAbonnement(rit, prijzenLijst);
        if (rit.getEindtijd().getTime().getTime() > boekingEindTijd.getTime().getTime()) {
            long overschrijdingTijd = boekingEindTijd.getTime().getTime() - rit.getEindtijd().getTime().getTime();
            long extraUren = TimeUnit.MILLISECONDS.toHours(overschrijdingTijd);
            prijs += extraUren * prijzenLijst.getPerUur();
        }
        prijs += prijzenLijst.getPerKm() * (aantalKilometers > abonnement.getKmVrij() ? aantalKilometers - abonnement.getKmVrij() : 0);
        return prijs;
	}

	private float getKostenPerTypeAutoEnAbonnement(Rit rit,PrijzenLijst prijzenLijst) {

        long reisTijd = rit.getReistijd();
        if (rit.isRitInTheWeekend()) {
            return prijzenLijst.getPerWeekend();
        }
        else if (TimeUnit.MILLISECONDS.toDays(reisTijd) > 7) {
            return rit.amountOfWeeks() * prijzenLijst.getPerWeek();
        }
        else if (TimeUnit.MILLISECONDS.toDays(reisTijd) > 1) {
            return rit.amountOfDays() * prijzenLijst.getPerDag();
        }
        else {
            return rit.amountOfHours() * prijzenLijst.getPerUur();
        }
    }
}
