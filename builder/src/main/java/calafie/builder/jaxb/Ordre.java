//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.31 at 01:50:14 PM CEST 
//


package calafie.builder.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ordre complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ordre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pv" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="argent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="difficulte" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="automatique" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="competence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caracteristique" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oposition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="legal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="eventuel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="critique" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="politique" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="gravite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ordre", propOrder = {
    "pv",
    "argent",
    "difficulte",
    "automatique",
    "nom",
    "type",
    "competence",
    "caracteristique",
    "oposition",
    "eventuel",
    "critique",
    "legal",
    "politique",
    "gravite",
    "description"
})
public class Ordre {

    protected float pv;
    protected double argent;
    protected Integer difficulte;
    protected boolean automatique;
    @XmlElement(required = true)
    protected String nom;
    @XmlElement(required = true)
    protected String type;
    protected String competence;
    protected String caracteristique;
    protected String oposition;
    protected boolean legal;
    protected boolean eventuel;
    protected boolean critique;
    protected Boolean politique;
    protected String gravite;
    @XmlElement(required = true)
    protected String description;

    /**
     * Gets the value of the pv property.
     * 
     */
    public float getPv() {
        return pv;
    }

    @Override
	public String toString() {
		return "Ordre [pv=" + pv + ", argent=" + argent + ", difficulte=" + difficulte + ", automatique=" + automatique
				+ ", nom=" + nom + ", type=" + type + ", competence=" + competence + ", caracteristique="
				+ caracteristique + ", oposition=" + oposition + ", legal=" + legal + ", eventuel=" + eventuel
				+ ", critique=" + critique + ", politique=" + politique + ", gravite=" + gravite + ", description="
				+ description + "]";
	}

	/**
     * Sets the value of the pv property.
     * 
     */
    public void setPv(float value) {
        this.pv = value;
    }

    /**
     * Gets the value of the argent property.
     * 
     */
    public double getArgent() {
        return argent;
    }

    /**
     * Sets the value of the argent property.
     * 
     */
    public void setArgent(double value) {
        this.argent = value;
    }

    /**
     * Gets the value of the difficulte property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDifficulte() {
        return difficulte;
    }

    /**
     * Sets the value of the difficulte property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDifficulte(Integer value) {
        this.difficulte = value;
    }

    /**
     * Gets the value of the automatique property.
     * 
     */
    public boolean isAutomatique() {
        return automatique;
    }

    /**
     * Sets the value of the automatique property.
     * 
     */
    public void setAutomatique(boolean value) {
        this.automatique = value;
    }

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the competence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompetence() {
        return competence;
    }

    /**
     * Sets the value of the competence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompetence(String value) {
        this.competence = value;
    }

    /**
     * Gets the value of the caracteristique property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaracteristique() {
        return caracteristique;
    }

    /**
     * Sets the value of the caracteristique property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaracteristique(String value) {
        this.caracteristique = value;
    }

    /**
     * Gets the value of the oposition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOposition() {
        return oposition;
    }

    /**
     * Sets the value of the oposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOposition(String value) {
        this.oposition = value;
    }

    /**
     * Gets the value of the legal property.
     * 
     */
    public boolean isLegal() {
        return legal;
    }

    /**
     * Sets the value of the legal property.
     * 
     */
    public void setLegal(boolean value) {
        this.legal = value;
    }

    /**
     * Gets the value of the eventuel property.
     * 
     */
    public boolean isEventuel() {
        return eventuel;
    }

    /**
     * Sets the value of the eventuel property.
     * 
     */
    public void setEventuel(boolean value) {
        this.eventuel = value;
    }

    /**
     * Gets the value of the critique property.
     * 
     */
    public boolean isCritique() {
        return critique;
    }

    /**
     * Sets the value of the critique property.
     * 
     */
    public void setCritique(boolean value) {
        this.critique = value;
    }

    /**
     * Gets the value of the politique property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPolitique() {
        return politique;
    }

    /**
     * Sets the value of the politique property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPolitique(Boolean value) {
        this.politique = value;
    }

    /**
     * Gets the value of the gravite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGravite() {
        return gravite;
    }

    /**
     * Sets the value of the gravite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGravite(String value) {
        this.gravite = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
