package org.calafie.old;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ordre", namespace="calafie/builder/ordre", propOrder={"pv", "argent", "difficulte", "automatique", "nom", "type", "competence", "caracteristique", "oposition", "legal", "politique", "gravite", "description"})
public class Ordre
{
  protected float pv;
  protected double argent;
  protected Integer difficulte;
  protected boolean automatique;
  @XmlElement(required=true)
  protected String nom;
  @XmlElement(required=true)
  protected String type;
  protected String competence;
  protected String caracteristique;
  protected String oposition;
  protected boolean legal;
  protected Boolean politique;
  protected String gravite;
  @XmlElement(required=true)
  protected String description;
  
  public float getPv()
  {
    return this.pv;
  }
  
  public void setPv(float value)
  {
    this.pv = value;
  }
  
  public double getArgent()
  {
    return this.argent;
  }
  
  public void setArgent(double value)
  {
    this.argent = value;
  }
  
  public Integer getDifficulte()
  {
    return this.difficulte;
  }
  
  public void setDifficulte(Integer value)
  {
    this.difficulte = value;
  }
  
  public boolean isAutomatique()
  {
    return this.automatique;
  }
  
  public void setAutomatique(boolean value)
  {
    this.automatique = value;
  }
  
  public String getNom()
  {
    return this.nom;
  }
  
  public void setNom(String value)
  {
    this.nom = value;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setType(String value)
  {
    this.type = value;
  }
  
  public String getCompetence()
  {
    return this.competence;
  }
  
  public void setCompetence(String value)
  {
    this.competence = value;
  }
  
  public String getCaracteristique()
  {
    return this.caracteristique;
  }
  
  public void setCaracteristique(String value)
  {
    this.caracteristique = value;
  }
  
  public String getOposition()
  {
    return this.oposition;
  }
  
  public void setOposition(String value)
  {
    this.oposition = value;
  }
  
  public boolean isLegal()
  {
    return this.legal;
  }
  
  public void setLegal(boolean value)
  {
    this.legal = value;
  }
  
  public Boolean isPolitique()
  {
    return this.politique;
  }
  
  public void setPolitique(Boolean value)
  {
    this.politique = value;
  }
  
  public String getGravite()
  {
    return this.gravite;
  }
  
  public void setGravite(String value)
  {
    this.gravite = value;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String value)
  {
    this.description = value;
  }
}
