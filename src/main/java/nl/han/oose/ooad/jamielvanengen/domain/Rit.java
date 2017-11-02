package nl.han.oose.ooad.jamielvanengen.domain;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Rit {

	private Calendar starttijd;

	private Calendar eindtijd;

	private float aantalKm;

	public Rit(Calendar starttijd, Calendar eindtijd, float aantalKm) {
		this.starttijd = starttijd;
		this.eindtijd = eindtijd;
		this.aantalKm = aantalKm;
	}

	public Calendar getEindtijd() {
	    return this.eindtijd;
	}

	public long getReistijd() {
	    return eindtijd.getTime().getTime() - starttijd.getTime().getTime();
    }

    public long amountOfHours() {
	    return TimeUnit.MILLISECONDS.toDays(getReistijd());
    }

    public long amountOfDays() {
        return TimeUnit.MILLISECONDS.toDays(getReistijd());
    }

    public long amountOfWeeks() {
        return TimeUnit.MILLISECONDS.toDays(getReistijd());
    }

    public boolean isRitInTheWeekend() {
	    if (starttijd.get(Calendar.DAY_OF_WEEK) == 6 && eindtijd.get(Calendar.DAY_OF_WEEK) == 7) {
	        Calendar dayAfterStarttijd = starttijd;
	        dayAfterStarttijd.add(Calendar.DATE, 1);
	        if (dayAfterStarttijd.getTime() == eindtijd.getTime()) {
	            return true;
            }
        }
        return false;
    }
}
