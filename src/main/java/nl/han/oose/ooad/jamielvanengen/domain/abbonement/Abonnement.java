package nl.han.oose.ooad.jamielvanengen.domain.abbonement;

import nl.han.oose.ooad.jamielvanengen.domain.PrijzenCalculator;

public class Abonnement {

    private int kmVrij;
	private AbonnementType type;

    public Abonnement(int kmVrij, AbonnementType type) {
        this.kmVrij = kmVrij;
        this.type = type;
    }

    public int getKmVrij() {
        return kmVrij;
    }

    public AbonnementType getType() {
        return type;
    }
}
