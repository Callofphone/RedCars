package nl.han.oose.ooad.jamielvanengen.domain;

public class AutoRepository {
    public Auto getAutoByKenteken(String Kenteken) {
        //I.p.v. een nieuw object terug te geven zou dit in een echte applicatie een record uit de db geven.
        return new Auto("ABC-42-123", new Plaats("Arnhem"), AutoTypes.Personenauto);
    }
}
