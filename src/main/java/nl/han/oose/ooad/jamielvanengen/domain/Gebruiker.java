package nl.han.oose.ooad.jamielvanengen.domain;

import nl.han.oose.ooad.jamielvanengen.domain.abbonement.Abonnement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gebruiker {

    private int pasnummer;
	private String naam;
	private String adres;
	private String woonplaats;
	private String email;
	private String rekeningnummer;
	private Abonnement abonnement;
	private ArrayList<Boeking> boekingen;

    public Gebruiker(int pasnummer, String naam, String adres, String woonplaats, String email, String rekeningnummer, Abonnement abonnement) {
        this.pasnummer = pasnummer;
        this.naam = naam;
        this.adres = adres;
        this.woonplaats = woonplaats;
        this.email = email;
        this.rekeningnummer = rekeningnummer;
        this.abonnement = abonnement;
        boekingen = new ArrayList<Boeking>();
        initBoekingen();
    }

    public float getPrijsRit(Calendar ritStartTijd, Calendar ritEindTijd, float aantalKilometers) {
		Boeking boeking = getBoeking(ritStartTijd);
		return boeking.berekenPrijs(ritStartTijd, ritEindTijd, aantalKilometers, abonnement);
	}

	private Boeking getBoeking(Calendar ritStartTijd) {
		return boekingen.stream().filter(boeking -> ritStartTijd.after(boeking.getBegintijd())).findAny().orElse(null);
	}

	private void initBoekingen() {
        boekingen.add(
                new Boeking(
                        new GregorianCalendar(2017, Calendar.OCTOBER, 28),
                        new GregorianCalendar(2017, Calendar.NOVEMBER, 2),
                        new Auto("ABC-42-123", new Plaats("Arnhem"), AutoTypes.Personenauto)));
    }


    public int getPasnummer() {
        return pasnummer;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public void reserveer(Boeking boeking) {
        if (!this.doesBoekingOverlap(boeking)) {
            addBoeking(boeking);
        }
    }

    private boolean doesBoekingOverlap(Boeking boeking) {
        boolean overlaps = false;
        for (Boeking boekingInArrayList : boekingen) {
            overlaps = !boeking.getBegintijd().after(boekingInArrayList.getEindtijd()) && !boekingInArrayList.getBegintijd().after(boeking.getEindtijd());
        }
        return overlaps;
    }

    public void addBoeking(Boeking boeking) {
        boekingen.add(boeking);
    }
}
