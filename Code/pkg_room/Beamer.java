package pkg_room;

import pkg_player.Item;
/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * La classe beamer a pour but d'instancier des beamers, c'est à dire des téléporteurs.
 * 
 * @author Petit Alloys
 * @version 3.0
 */
public class Beamer extends Item
{
     private Room aBeamerRoom;

//          /**
//      * 
//      */
//     public Beamer()
//     {
//      super("beamerTemp", "beamerTemp", 0.0);
//     }
    
    
    
    /**
     * Constructeur de la classe, il instancie le beamer en créant un "item" (ou plutot une sorte d'item) 
     * possédant un attribut room.
     */
    public Beamer(final String pNomBeamer, final String pDescriptionBeamer, final double pPoidsBeamer)
    {
     super(pNomBeamer, pDescriptionBeamer, pPoidsBeamer);
     this.aBeamerRoom = null;
    }

    
    /**
     * geteur pour aBeamerRoom
     */
     public Room getBeamerRoom(){
         return aBeamerRoom;
         

        }
        
        
            /**
     * seteur pour aBeamerRoom
     */
     public void setBeamerRoom(final Room pBeamerRoom){
         
         aBeamerRoom = pBeamerRoom;

        }
        
    
}
