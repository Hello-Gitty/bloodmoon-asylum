//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.09 at 11:16:02 AM CEST 
//


package org.calafie.old;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for competences complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="competences">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baratin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="combatMainsNues" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="combatContact" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="combatDistance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="commerce" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="demolition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="discretion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="eloquence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="falsification" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="foi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="informatique" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="medecine" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="observation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="organisation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pouvoir" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="seduction" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="survie" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="vol" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "competences", namespace = "calafie/builder/fiche", propOrder = {
    "baratin",
    "combatMainsNues",
    "combatContact",
    "combatDistance",
    "commerce",
    "demolition",
    "discretion",
    "eloquence",
    "falsification",
    "foi",
    "informatique",
    "medecine",
    "observation",
    "organisation",
    "pouvoir",
    "seduction",
    "survie",
    "vol"
})
public class Competences {

    protected int baratin;
    protected int combatMainsNues;
    protected int combatContact;
    protected int combatDistance;
    protected int commerce;
    protected int demolition;
    protected int discretion;
    protected int eloquence;
    protected int falsification;
    protected int foi;
    protected int informatique;
    protected int medecine;
    protected int observation;
    protected int organisation;
    protected int pouvoir;
    protected int seduction;
    protected int survie;
    protected int vol;

    /**
     * Gets the value of the baratin property.
     * 
     */
    public int getBaratin() {
        return baratin;
    }

    /**
     * Sets the value of the baratin property.
     * 
     */
    public void setBaratin(int value) {
        this.baratin = value;
    }

    /**
     * Gets the value of the combatMainsNues property.
     * 
     */
    public int getCombatMainsNues() {
        return combatMainsNues;
    }

    /**
     * Sets the value of the combatMainsNues property.
     * 
     */
    public void setCombatMainsNues(int value) {
        this.combatMainsNues = value;
    }

    /**
     * Gets the value of the combatContact0020 property.
     * 
     */
    public int getCombatContact() {
        return combatContact;
    }

    /**
     * Sets the value of the combatContact0020 property.
     * 
     */
    public void setCombatContact(int value) {
        this.combatContact = value;
    }

    /**
     * Gets the value of the combatDistance property.
     * 
     */
    public int getCombatDistance() {
        return combatDistance;
    }

    /**
     * Sets the value of the combatDistance property.
     * 
     */
    public void setCombatDistance(int value) {
        this.combatDistance = value;
    }

    /**
     * Gets the value of the commerce property.
     * 
     */
    public int getCommerce() {
        return commerce;
    }

    /**
     * Sets the value of the commerce property.
     * 
     */
    public void setCommerce(int value) {
        this.commerce = value;
    }

    /**
     * Gets the value of the demolition property.
     * 
     */
    public int getDemolition() {
        return demolition;
    }

    /**
     * Sets the value of the demolition property.
     * 
     */
    public void setDemolition(int value) {
        this.demolition = value;
    }

    /**
     * Gets the value of the discretion property.
     * 
     */
    public int getDiscretion() {
        return discretion;
    }

    /**
     * Sets the value of the discretion property.
     * 
     */
    public void setDiscretion(int value) {
        this.discretion = value;
    }

    /**
     * Gets the value of the eloquence property.
     * 
     */
    public int getEloquence() {
        return eloquence;
    }

    /**
     * Sets the value of the eloquence property.
     * 
     */
    public void setEloquence(int value) {
        this.eloquence = value;
    }

    /**
     * Gets the value of the falsification property.
     * 
     */
    public int getFalsification() {
        return falsification;
    }

    /**
     * Sets the value of the falsification property.
     * 
     */
    public void setFalsification(int value) {
        this.falsification = value;
    }

    /**
     * Gets the value of the foi property.
     * 
     */
    public int getFoi() {
        return foi;
    }

    /**
     * Sets the value of the foi property.
     * 
     */
    public void setFoi(int value) {
        this.foi = value;
    }

    /**
     * Gets the value of the informatique property.
     * 
     */
    public int getInformatique() {
        return informatique;
    }

    /**
     * Sets the value of the informatique property.
     * 
     */
    public void setInformatique(int value) {
        this.informatique = value;
    }

    /**
     * Gets the value of the medecine property.
     * 
     */
    public int getMedecine() {
        return medecine;
    }

    /**
     * Sets the value of the medecine property.
     * 
     */
    public void setMedecine(int value) {
        this.medecine = value;
    }

    /**
     * Gets the value of the observation property.
     * 
     */
    public int getObservation() {
        return observation;
    }

    /**
     * Sets the value of the observation property.
     * 
     */
    public void setObservation(int value) {
        this.observation = value;
    }

    /**
     * Gets the value of the organisation property.
     * 
     */
    public int getOrganisation() {
        return organisation;
    }

    /**
     * Sets the value of the organisation property.
     * 
     */
    public void setOrganisation(int value) {
        this.organisation = value;
    }

    /**
     * Gets the value of the pouvoir property.
     * 
     */
    public int getPouvoir() {
        return pouvoir;
    }

    /**
     * Sets the value of the pouvoir property.
     * 
     */
    public void setPouvoir(int value) {
        this.pouvoir = value;
    }

    /**
     * Gets the value of the seduction property.
     * 
     */
    public int getSeduction() {
        return seduction;
    }

    /**
     * Sets the value of the seduction property.
     * 
     */
    public void setSeduction(int value) {
        this.seduction = value;
    }

    /**
     * Gets the value of the survie property.
     * 
     */
    public int getSurvie() {
        return survie;
    }

    /**
     * Sets the value of the survie property.
     * 
     */
    public void setSurvie(int value) {
        this.survie = value;
    }

    /**
     * Gets the value of the vol property.
     * 
     */
    public int getVol() {
        return vol;
    }

    /**
     * Sets the value of the vol property.
     * 
     */
    public void setVol(int value) {
        this.vol = value;
    }

}
