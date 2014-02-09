package calafie.builder;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import calafie.builder.jaxb.Vocation;

public class ComparatorVocation implements Comparator<Vocation>{

    public int compare(Vocation o1, Vocation o2) {
        return Collator.getInstance(Locale.FRENCH).compare(o1.getNom(), o2.getNom());
    }


}

