package calafie.builder.ihm.modele;

public class ChoixVocation extends Element{


    public static String VOCACTION_VIDE = "AUCUN";
    

    
    public ChoixVocation() {
        
    }
    
    private String vocation;


    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

}
