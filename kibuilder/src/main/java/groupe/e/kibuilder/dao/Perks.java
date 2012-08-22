package groupe.e.kibuilder.dao;

import groupe.e.kibuilder.dao.type.TypePerks;

public class Perks extends Element implements Comparable<Perks>{

    protected String description;
    protected Ordre ordre;
    /**
     * Niveau du perks
     */
    protected Integer niveau;

    protected TypePerks type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ordre getOrdre() {
        return ordre;
    }

    public void setOrdre(Ordre ordre) {
        this.ordre = ordre;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public TypePerks getType() {
        return type;
    }

    public void setType(TypePerks type) {
        this.type = type;
    }

    public int compareTo(Perks p) {
        return niveau.compareTo(p.niveau);
    }

}
