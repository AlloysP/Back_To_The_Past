package pkg_room;

import pkg_player.ItemList;
import pkg_player.Item;
/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * La classe LockedDoor a pour but de créer des portes entre les rooms pour faire office d'exits
 * à la différence près que celles-ci peuvent se vérouiller et vice-versa grâce à la bonne clef.
 * 
 * @author Petit Alloys
 * @version 3.0
 */
public class LockedDoor
{
    private boolean aPorteOuverte;
    private String aPorteExitFr;
    private String aPorteExitEn;
    private ItemList aClefs;

    /**
     * Constructeur pour instancier une porte pouvant être ouverte ou fermée avec une clef
     */
    public LockedDoor(final boolean pPorteOuverte, final String pPorteExitFr, final String pPorteExitEn)
    {
        this.aPorteOuverte = pPorteOuverte;
        this.aClefs = new ItemList();
        this.aPorteExitFr = pPorteExitFr;
        this.aPorteExitEn = pPorteExitEn;
    }

        /**
     * Retourne l'etat de la porte: ouvert ou fermé
     */
    public boolean getPorteOuverte(){
        return aPorteOuverte;
    }

            /**
     *  Permet de fermer ou d'ouvrir la porte
     */
    public void setPorteOuverte(final boolean pPorteOuverte){
        aPorteOuverte = pPorteOuverte;
    }

            /**
     *  Retourne la liste des clefs pouvant ouvrir la porte
     */
    public ItemList getClefs(){
        return aClefs;
    }

            /**
     *  Définit une clef pouvant ouvrir la porte
     */
    public void setClef(final String pNomClef, final Item pItemClef){
        aClefs.mettreItem(pNomClef, pItemClef);
    }

            /**
     * Retourne la sortie en francais de la porte
     */
    public String getPorteExitFr(){
        return aPorteExitFr;
    }

            /**
     * Retourne la sortie en anglais de la porte
     */
    public String getPorteExitEn(){
        return aPorteExitEn;
    }

}
