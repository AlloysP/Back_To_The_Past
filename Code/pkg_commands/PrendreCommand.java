package pkg_commands;

import java.io.IOException;
import pkg_player.Item;
import pkg_game.GameEngine;
import pkg_player.Player;
import pkg_game.Parser;
/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * @author  Petit Alloys
 * @version 3.0
 */
public class PrendreCommand extends Command
{

    /** 
     *  Prend l'item passé en paramètre dans l'inventaire du PNJ sélectionné
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        if (!pCommand.hasSecondWord()){
            pGameEngine.getGui().println("Prendre quoi ?");
            return;
        }
        String vNomItem = pCommand.getSecondWord();

        if (!( pGameEngine.getListePNJ().containsKey(pGameEngine.getSelection()) || pGameEngine.getListePNJMoving().containsKey(pGameEngine.getSelection()) )){
            pGameEngine.getGui().println("Il n'y a pas de PNJ " + pGameEngine.getSelection());
            return;
        }

        if (!( pGameEngine.getListePNJRooms().get(pGameEngine.getSelection()) == pGameEngine.getJoueur().getCurrentRoom()  ||  pGameEngine.getListePNJMovingRooms().get(pGameEngine.getSelection()) == pGameEngine.getJoueur().getCurrentRoom() )){
            pGameEngine.getGui().println( pGameEngine.getSelection() + " n'est pas dans cette salle");
            return;
        }

                if (!( pGameEngine.getListePNJ().containsKey(pGameEngine.getSelection()) || pGameEngine.getListePNJMoving().containsKey(pGameEngine.getSelection()) )){
            pGameEngine.getGui().println("Il n'y a pas de PNJ " + pGameEngine.getSelection());
            return;
        }
        try{
            if (pGameEngine.getListePNJ().get(pGameEngine.getSelection()).getAllItemsPNJ().VerifItem(vNomItem)) {

                if (!(pGameEngine.getJoueur().getPoidsInventaire() <= pGameEngine.getListePNJ().get(pGameEngine.getSelection()).getAllItemsPNJ().retirerItem(vNomItem).getPoids())) {

                    pGameEngine.getJoueur().setPoidsInventaire(pGameEngine.getJoueur().getPoidsInventaire() - pGameEngine.getListePNJ().get(pGameEngine.getSelection()).getAllItemsPNJ().retirerItem(vNomItem).getPoids());

                    Item vItem = pGameEngine.getListePNJ().get(pGameEngine.getSelection()).getAllItemsPNJ().retirerItem(vNomItem);
                    pGameEngine.getJoueur().ajoutItemJoueur(vNomItem, vItem);
                    pGameEngine.getGui().println("Tu viens de prendre:  "+vNomItem);

                    pGameEngine.getListePNJ().get(pGameEngine.getSelection()).getAllItemsPNJ().removeItem(vNomItem);
                }
                else {
                    pGameEngine.getGui().println("L'item "+vNomItem+" est bien trop lourd!");

                }

            }
            else{
                pGameEngine.getGui().println("Pas d'item  '"+ vNomItem + "' dans l'invantaire de " + pGameEngine.getSelection());

            }
        }
            catch (NullPointerException pE)
            {
                pGameEngine.getGui().println(pE.getMessage());

            }
            
            if (pGameEngine.getListePNJMoving().get(pGameEngine.getSelection()).getAllItemsPNJ().VerifItem(vNomItem)) {

                if (!(pGameEngine.getJoueur().getPoidsInventaire() <= pGameEngine.getListePNJMoving().get(pGameEngine.getSelection()).getAllItemsPNJ().retirerItem(vNomItem).getPoids())) {

                    pGameEngine.getJoueur().setPoidsInventaire(pGameEngine.getJoueur().getPoidsInventaire() - pGameEngine.getListePNJMoving().get(pGameEngine.getSelection()).getAllItemsPNJ().retirerItem(vNomItem).getPoids());

                    Item vItem = pGameEngine.getListePNJMoving().get(pGameEngine.getSelection()).getAllItemsPNJ().retirerItem(vNomItem);
                    pGameEngine.getJoueur().ajoutItemJoueur(vNomItem, vItem);
                    pGameEngine.getGui().println("Tu viens de prendre:  "+vNomItem);

                    pGameEngine.getListePNJMoving().get(pGameEngine.getSelection()).getAllItemsPNJ().removeItem(vNomItem);
                }
                else {
                    pGameEngine.getGui().println("L'item "+vNomItem+" est bien trop lourd!");

                }

            }
            else{
                pGameEngine.getGui().println("Pas d'item  '"+ vNomItem + "' dans l'invantaire de " + pGameEngine.getSelection());

            }
    }
}