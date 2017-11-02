package nl.han.oose.ooad.jamielvanengen;

import nl.han.oose.ooad.jamielvanengen.domain.RedCarsController;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RedCarsController redCars = new RedCarsController();

        redCars.checkout(1, new GregorianCalendar(2017, Calendar.OCTOBER, 29),
                new GregorianCalendar(2017, Calendar.NOVEMBER, 1),
                500);
    }
}
