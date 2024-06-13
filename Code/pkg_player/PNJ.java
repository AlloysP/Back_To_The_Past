package pkg_player;

import pkg_room.Room;
import java.util.HashMap;

/**
 * 
 * 
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 *
 * Classe du PNJ, c'est là que se trouve tout ce qui concerne le PNJ
 * (ex: salle du PNJ ou nom du joueur)
 * 
 * Il y a des méthodes pour que ce PNJ interagisse avec son environnement dans le jeu.
 * 
 * 
 * @author Alloys Petit
 * @version 3.0
 */
public class PNJ
{
    private Room aCurrentRoom;
    private ItemList aItemPNJ;
    private String aTexte;
    private String aNomPNJ;

    /**
     * Constructeur de la classe qui permet de créée un PNJ
     */
    public PNJ(final String pNomPNJ)
    {
        this.aNomPNJ = pNomPNJ;
        this.aItemPNJ= new ItemList();
    }

    /**
     * Change la salle actuelle où le PNJ se trouve
     */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }

    /**
     * Retourne la salle actuelle du joueur
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;

    }

    /**
     * Ajoute un item dans l'inventaire du PNJ
     */
    public void ajoutItemPNJ(final String pNomItem, final Item pItem){
        aItemPNJ.mettreItem(pNomItem, pItem);
    }

    //     /**
    //      * Retourne une liste de tous les items présents dans l'inventaire du PNJ
    //      */
    //     public String inventaire()
    //     {
    //         return("ItemsPNJ: "+aItemPNJ.getItemsStringListe());
    //     }

    /**
     * Retourne la HashMap des items du PNJ
     */
    public ItemList getAllItemsPNJ(){
        return this.aItemPNJ;
    }

    /**
     * Retourne le texte du PNJ
     */
    public String getTexte(){
        return aTexte;
    }

    /**
     * Modifie le texte du PNJ
     */
    public void setTexte(final String pTexte){
        aTexte = pTexte;
    }

}
