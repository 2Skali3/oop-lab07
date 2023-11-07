package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }

    private static enum Month{
        GENNAIO(31),
        FEBBRAIO(28),
        MARZO(31),
        APRILE(30),
        MAGGIO(31),
        GIUGNO(30),
        LUGLIO(31),
        AGOSTO(31),
        SETTEMBRE(30),
        OTTOBRE(31),
        NOVEMBRE(30),
        DICEMBRE(31);

        private final int giorni;
        
        Month(final int gg){
            this.giorni = gg;
        }
    }
}
