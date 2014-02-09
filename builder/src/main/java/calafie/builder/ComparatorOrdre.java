package calafie.builder;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import calafie.builder.jaxb.Ordre;

public class ComparatorOrdre implements Comparator<Ordre>{

    public int compare(Ordre o1, Ordre o2) {
         return Collator.getInstance(Locale.FRENCH).compare(o1.getNom(), o2.getNom());
    }


}
