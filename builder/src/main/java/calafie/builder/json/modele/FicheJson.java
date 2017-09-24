package calafie.builder.json.modele;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class FicheJson {

    @SerializedName(value="nom")
    private String nom;
    @SerializedName(value="pdv")
    private int pdv;
    @SerializedName(value="PA")
    private int PA; 
    @SerializedName(value="vocations")
    private Map<String, Object[]> vocations;
    @SerializedName(value="caracteristiques")
    private Map<String, Integer> caracteristiques;
    @SerializedName(value="competences")
    private Map<String, Integer> competences;
    @SerializedName(value="notes")
    private String notes;
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Map<String, Object[]> getVocations() {
        return vocations;
    }
    public void setVocations(Map<String, Object[]> vocations) {
        this.vocations = vocations;
    }
    public Map<String, Integer> getCaracteristiques() {
        return caracteristiques;
    }
    public void setCaracteristiques(Map<String, Integer> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }
    public Map<String, Integer> getCompetences() {
        return competences;
    }
    public void setCompetences(Map<String, Integer> competences) {
        this.competences = competences;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public int getPdv() {
        return pdv;
    }
    public void setPdv(int pdv) {
        this.pdv = pdv;
    }
    public int getPA() {
        return PA;
    }
    public void setPA(int pA) {
        PA = pA;
    }

}
