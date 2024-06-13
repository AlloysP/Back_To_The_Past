package pkg_player;

import java.util.HashMap;


/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * Cette classe sert à stocker et à gérer tous les items du jeu.
 * 
 * @author Petit Alloys 
 * @version 3.0
 */
public class ItemList
{
    private HashMap<String,Item> aListeItem;

    /**
     * Constructeur de la classe ItemList, initialise entre autre la HashMap contenant tous les objets du jeu
     */
    public ItemList()
    {
        aListeItem= new HashMap<String,Item>();
        
    }

    
        /**
     * Rajoute l'item passé en paramètre dans la liste des items.
     */
    public void mettreItem (final String pNomItem, final Item pItem){
     aListeItem.put(pNomItem, pItem);
        
     
    }
    
            /**
     * Retourne l'item voulu.
     */
        public Item retirerItem (final String pNomItem){
     return(aListeItem.get(pNomItem));
        
    }
    
    
        	    /**
     * Retourne une liste de tous les items présents dans la itemList
     */
    public String getItemsStringListe()
   {
         StringBuilder vReturnString = new StringBuilder();
        for ( String vS : aListeItem.keySet() )
            vReturnString.append( " " + vS );
        return vReturnString.toString();
         }
         
         
         
                 	    /**
     * Vérifie si la key passée en paramètre est présente dans la HashMap
     */
     public boolean VerifItem (final String pNomItem){
     return(aListeItem.containsKey(pNomItem));
    }
    
    
    
            	    /**
     * Enlève l'item voulu de la liste des items
     */
    public void removeItem (final String pNomItem) {
        aListeItem.remove(pNomItem);
        
    }
    
            	    /**
     * Retourne la HashMap de ItemList
     */
    public HashMap<String,Item> getHashMapItemList () {
        return aListeItem;
        
    }
    
         /**
     * Recrée l'ItemList
     */
    public void removeItemList (){
      aListeItem = aListeItem= new HashMap<String,Item>();
    }
    
}
