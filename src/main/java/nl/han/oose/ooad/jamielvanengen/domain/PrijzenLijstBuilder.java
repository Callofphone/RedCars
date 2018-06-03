package nl.han.oose.ooad.jamielvanengen.domain;

import nl.han.oose.ooad.jamielvanengen.domain.abbonement.Abonnement;

public class PrijzenLijstBuilder {
    public PrijzenLijst buildPrijzenLijst(Abonnement abonnement, AutoTypes autoType) {
        switch (abonnement.getType()) {
            case Gratis:
                return getGratisPrijzen(autoType);
            default:
                return getBetaaldePrijzen(autoType);
        }
    }

    private PrijzenLijst getGratisPrijzen(AutoTypes autoTypes) {
        switch (autoTypes) {
            case Stationwagen:
                return  new PrijzenLijst(7.50f, 60f, 90f, 180f, 0.35f);
            default:
                return new PrijzenLijst(6.00f, 50f, 70f, 150f, 0.30f);

        }
    }

    private PrijzenLijst getBetaaldePrijzen(AutoTypes autoTypes) {
        switch (autoTypes) {
            case Stationwagen:
                return  new PrijzenLijst(5.50f, 50f, 80f, 170f, 0.30f);
            default:
                return new PrijzenLijst(4.00f, 40f, 60f, 140f, 0.25f);

        }
    }
}
