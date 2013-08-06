//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.14 at 02:07:25 AM CEST 
//


package calafie.builder.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fiche complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fiche">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pointDeVie" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="carriere" type="{calafie/builder/fiche}vocationType"/>
 *         &lt;element name="type" type="{calafie/builder/fiche}vocationType"/>
 *         &lt;element name="politique" type="{calafie/builder/fiche}vocationType"/>
 *         &lt;element name="combat" type="{calafie/builder/fiche}vocationType"/>
 *         &lt;element name="pouvoir" type="{calafie/builder/fiche}vocationType"/>
 *         &lt;element name="caracteristiques" type="{calafie/builder/fiche}caracteristiques"/>
 *         &lt;element name="competences" type="{calafie/builder/fiche}competences"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fiche", propOrder = {
    "nom",
    "pointDeVie",
    "carriere",
    "type",
    "politique",
    "combat",
    "pouvoir",
    "caracteristiques",
    "competences",
    "note"
})
public class Fiche {

    @XmlElement(required = true)
    protected String nom;
    protected int pointDeVie;
    @XmlElement(required = true)
    protected VocationType carriere;
    @XmlElement(required = true)
    protected VocationType type;
    @XmlElement(required = true)
    protected VocationType politique;
    @XmlElement(required = true)
    protected VocationType combat;
    @XmlElement(required = true)
    protected VocationType pouvoir;
    @XmlElement(required = true)
    protected Caracteristiques caracteristiques;
    @XmlElement(required = true)
    protected Competences competences;
    @XmlElement(required = true)
    protected String note;

    /**
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Gets the value of the pointDeVie property.
     * 
     */
    public int getPointDeVie() {
        return pointDeVie;
    }

    /**
     * Sets the value of the pointDeVie property.
     * 
     */
    public void setPointDeVie(int value) {
        this.pointDeVie = value;
    }

    /**
     * Gets the value of the carriere property.
     * 
     * @return
     *     possible object is
     *     {@link VocationType }
     *     
     */
    public VocationType getCarriere() {
        return carriere;
    }

    /**
     * Sets the value of the carriere property.
     * 
     * @param value
     *     allowed object is
     *     {@link VocationType }
     *     
     */
    public void setCarriere(VocationType value) {
        this.carriere = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link VocationType }
     *     
     */
    public VocationType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link VocationType }
     *     
     */
    public void setType(VocationType value) {
        this.type = value;
    }

    /**
     * Gets the value of the politique property.
     * 
     * @return
     *     possible object is
     *     {@link VocationType }
     *     
     */
    public VocationType getPolitique() {
        return politique;
    }

    /**
     * Sets the value of the politique property.
     * 
     * @param value
     *     allowed object is
     *     {@link VocationType }
     *     
     */
    public void setPolitique(VocationType value) {
        this.politique = value;
    }

    /**
     * Gets the value of the combat property.
     * 
     * @return
     *     possible object is
     *     {@link VocationType }
     *     
     */
    public VocationType getCombat() {
        return combat;
    }

    /**
     * Sets the value of the combat property.
     * 
     * @param value
     *     allowed object is
     *     {@link VocationType }
     *     
     */
    public void setCombat(VocationType value) {
        this.combat = value;
    }

    /**
     * Gets the value of the pouvoir property.
     * 
     * @return
     *     possible object is
     *     {@link VocationType }
     *     
     */
    public VocationType getPouvoir() {
        return pouvoir;
    }

    /**
     * Sets the value of the pouvoir property.
     * 
     * @param value
     *     allowed object is
     *     {@link VocationType }
     *     
     */
    public void setPouvoir(VocationType value) {
        this.pouvoir = value;
    }

    /**
     * Gets the value of the caracteristiques property.
     * 
     * @return
     *     possible object is
     *     {@link Caracteristiques }
     *     
     */
    public Caracteristiques getCaracteristiques() {
        return caracteristiques;
    }

    /**
     * Sets the value of the caracteristiques property.
     * 
     * @param value
     *     allowed object is
     *     {@link Caracteristiques }
     *     
     */
    public void setCaracteristiques(Caracteristiques value) {
        this.caracteristiques = value;
    }

    /**
     * Gets the value of the competences property.
     * 
     * @return
     *     possible object is
     *     {@link Competences }
     *     
     */
    public Competences getCompetences() {
        return competences;
    }

    /**
     * Sets the value of the competences property.
     * 
     * @param value
     *     allowed object is
     *     {@link Competences }
     *     
     */
    public void setCompetences(Competences value) {
        this.competences = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

}
