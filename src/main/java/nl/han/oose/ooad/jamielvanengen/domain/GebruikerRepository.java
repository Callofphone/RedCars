package nl.han.oose.ooad.jamielvanengen.domain;

import nl.han.oose.ooad.jamielvanengen.domain.abbonement.Abonnement;
import nl.han.oose.ooad.jamielvanengen.domain.abbonement.AbonnementType;

import java.util.ArrayList;

public class GebruikerRepository {
    private ArrayList<Gebruiker> gebruikers;

    public GebruikerRepository() {
        initGebruikers();
    }

    private void initGebruikers() {
        gebruikers = new ArrayList<Gebruiker>();
        gebruikers.add(new Gebruiker(1,
                "Jamiel van Engen",
                "Debussystraat 34",
                "Zevenaar",
                "jamiel.van.engen@gmail.com",
                "1232151232135124",
                new Abonnement(200, AbonnementType.Betaald)));
    }

    public Gebruiker getGebruikerBijKaartnummer(final int kaartnummer) {
        return gebruikers.stream()
                .filter(gebruiker -> gebruiker.getPasnummer() == kaartnummer)
                .findFirst().orElseGet(() -> null);
    }
}
