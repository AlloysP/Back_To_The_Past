package pkg_player;

import pkg_room.Room;
import java.util.Stack;
import java.util.HashMap;


/**
 * 
 * 
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 *
 * Classe du joueur, c'est là que se trouve tout ce qui concerne le joueur
 * (ex: salle du joueur ou nom du joueur)
 * 
 * Il y a des méthodes pour que ce joueur interagisse avec son environnement dans le jeu.
 * 
 * 
 * @author Alloys Petit
 * @version 3.0
 */
public class Player
{
    private Room aCurrentRoom;
    private double aPoidsInventaire;
    private Stack <Room> aPreviousRoomBis;
    private ItemList aItemJoueur;
    private String aNomJoueur;

    /**
     * Constructeur de la classe
     */
    public Player(final String pNomJoueur, final double pPoidsInventaite)
    {
      this.setPoidsInventaire(pPoidsInventaite);
      this.aPreviousRoomBis = new Stack <Room>();
//       this.aItemJoueur= new HashMap<String,Item>();
          this.aItemJoueur = new ItemList();
          this.aNomJoueur = pNomJoueur;
    }

    
            /**
     * Change la salle actuelle où le joueur se trouve
     */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
      this.aCurrentRoom = pCurrentRoom;
//        this.aCurrentRoom.getExit(pStringCurrentRoom);
    }
    
    
//      public UserInterface getUserInterface(){
//          return 
//         }
    
    
        /**
     * Change la salle actuelle où le joueur se trouve
     */
    public void setCurrentRoomBis(final String pStringCurrentRoom)
    {
//       this.aCurrentRoom = vCurrentRoom;
       this.aCurrentRoom.getExit(pStringCurrentRoom);
    }
    
//                 /**
//      * Change la salle actuelle où le joueur se trouve
//      */
//     public void marcher(final Room pCurrentRoom)
//     {
//       this.aCurrentRoom = pCurrentRoom;
//                 System.out.println(this.getCurrentRoom().getLongDescription());
//                      if(this.getCurrentRoom().getImageName() != null)
//                        aGui.showImage(this.getCurrentRoom().getImageName());
//     }
    
    
//     /**
//      * Change la salle actuelle où le joueur se trouve
//      */
//     public void setCurrentRoom(final Room pCurrentRoom)
//     {
//       Room nextRoom = currentRoom.getExit(direction);
//       
//        if (nextRoom == null) {
//             System.out.println("Il n'y a pas de salle dans cette direction");
//             return;
//         }
//       
//        setCurrentRoom(nextRoom);
// 
//     }
    
    
        /**
     * Retourne la salle actuelle du joueur
     */
    public Room getCurrentRoom()
    {
      return this.aCurrentRoom;

    }
    
   
    
    
    /**
     * Change le poids maximale de l'inventaire
     */
    public void setPoidsInventaire(final double pPoidsInventaire)
    {
      this.aPoidsInventaire = pPoidsInventaire;

    }
    
    
        /**
     * Retourne le poids maximal de l'inventaire
     */
    public double getPoidsInventaire()
    {
      return this.aPoidsInventaire;

    }
    
    
    
    

  /**
  * Vérifie si la Stack est vide
  */
  public boolean verifStack()
  {
   return this.aPreviousRoomBis.empty();
  }




  /**
  * Commande qui met le paramètre en haut de la pile
  */
  public void rangementStack(final Room pRoom)
  {
   this.aPreviousRoomBis.push(pRoom);
  }


  /**
  * Retourne le haut de la stack
  */
  public Room retireStack()
  {
   return this.aPreviousRoomBis.pop();
  }


  
    /**
  * Crée une nouvelle Stack afin de supprimer la précèdente
  */
  public void nouvelleStack()
  {
   aPreviousRoomBis = new Stack <Room>();
  }
  
  
  
      	    /**
     * Ajoute un item dans l'inventaire du joueur
     */
  public void ajoutItemJoueur(final String pNomItem, final Item pItem){
    aItemJoueur.mettreItem(pNomItem, pItem);
  }
    
  
    	    /**
     * Retourne une liste de tous les items présents dans l'inventaire du joueur
     */
    public String inventaire()
   {
         return("ItemsJoueur: "+aItemJoueur.getItemsStringListe() + "     Place restante: " + aPoidsInventaire);
         }


    
    	    /**
     * Retourne la HashMap des items du joueur
     */
    public ItemList getAllItemsJoueur(){
        return this.aItemJoueur;
    }



}
