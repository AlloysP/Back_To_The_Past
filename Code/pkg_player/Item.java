package pkg_player;


/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * Cette classe s'occupe de tout ce qui concerne les items, elle en crée des instances.
 * Les différentes méthodes ont pour but de gérer les items en modifiant ceux-ci
 * ou en les retournants/ajoutants.
 * 
 * @author Alloys Petit
 * @version 3.0
 */
public class Item
{
    private String aDescription;
    private double aPoids;
    private String aNom;



    /**
     * Constructeur par défaut, instancie les items
     */
    public Item(final String pNom, final String pDescription, final double pPoids)
    {
        this.setPoids(pPoids);
        this.setDescription(pDescription);
        this.setNom(pNom);

    } //Items()
    
    
        /**
     * Change le poids de l'item
     */
    public void setPoids(final double pPoids){
     aPoids = pPoids;
    }
        
                /**
     * Retourne le poids de l'item
     */
    public double getPoids(){
     return aPoids;
    }
        
    
            /**
     * Change la description de l'item
     */
    public void setDescription(final String pDescription){
      aDescription = pDescription;
    }
    
    
                /**
     * Retourne la description de l'item
     */
    public String getDescription(){
      return aDescription;
    }
    
    
                /**
     * Change le nom de l'item
     */
    public void setNom(final String pNom){
      aNom = pNom;
    }
    
    
                /**
     * Retourne le nom de l'item
     */
    public String getNom(){
      return aNom;
    }
    
    
                /**
     * Retourne la description complète d'un item
     */
    @Override public String toString()
       {
     return this.aNom + "     "+ this.aDescription + " de " + this.aPoids + " kg";
       }
    
    
       
       
       
       
} // Items

