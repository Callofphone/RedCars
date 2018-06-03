package nl.han.oose.ooad.jamielvanengen.domain;

import java.util.Calendar;

public class BoekingFactory {
    public Boeking createBoeking(Calendar begintijd, Calendar eindtijd, Auto auto) {
        return new Boeking(begintijd, eindtijd, auto);
    }
}
