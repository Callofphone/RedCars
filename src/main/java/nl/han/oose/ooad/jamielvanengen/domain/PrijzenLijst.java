package nl.han.oose.ooad.jamielvanengen.domain;

public class PrijzenLijst {
    private float perUur, perDag, perWeekend, perWeek, perKm;

    public PrijzenLijst(float perUur, float perDag, float perWeekend, float perWeek, float perKm) {
        this.perUur = perUur;
        this.perDag = perDag;
        this.perWeekend = perWeekend;
        this.perWeek = perWeek;
        this.perKm = perKm;
    }

    public float getPerUur() {
        return perUur;
    }

    public float getPerDag() {
        return perDag;
    }

    public float getPerWeekend() {
        return perWeekend;
    }

    public float getPerWeek() {
        return perWeek;
    }

    public float getPerKm() {
        return perKm;
    }
}
