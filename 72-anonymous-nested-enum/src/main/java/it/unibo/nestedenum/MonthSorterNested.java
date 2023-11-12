package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {

            @Override
            public int compare(final String o1, final String o2) {
                return Month.fromString(o1).giorni - Month.fromString(o2).giorni;
            }
            
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {

            @Override
            public int compare(final String o1, final String o2) {
                return Month.fromString(o1).ordinal() - Month.fromString(o2).ordinal();
            }
            
        };
    }

    private static enum Month{
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int giorni;
        
        Month(final int gg){
            this.giorni = 
            gg;
        }

        private static Month fromString(String text){
            text = text.toUpperCase();
            List<Month> matching = new ArrayList<>();
            for (Month m : Month.values()) {
                if (m.toString().startsWith(text)) {
                    matching.add(m);
                }
            }
            if (matching.size() == 0) {
                throw new IllegalArgumentException("string provided does not match any month");
            } else if (matching.size() > 1) {
                throw new IllegalArgumentException("ambiguous string provided");
            } else {
                return matching.get(0);
            }
        }

    }
}
