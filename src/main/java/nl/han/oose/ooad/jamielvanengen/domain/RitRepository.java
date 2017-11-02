package nl.han.oose.ooad.jamielvanengen.domain;

import java.util.ArrayList;

public class RitRepository {
    private ArrayList<Rit> ritten = new ArrayList<>();

    public void addRit(Rit rit) {
        ritten.add(rit);
    }
}
