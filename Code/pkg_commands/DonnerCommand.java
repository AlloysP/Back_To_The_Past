package pkg_commands;

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
public class DonnerCommand extends Command
{
    /** 
     * Donne l'item passé en paramètre au PNJ sélectionné
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        if (!pCommand.hasSecondWord()){
            pGameEngine.getGui().println("donner quoi ?");
            return;
        }
          String vNomItem = pCommand.getSecondWord();
        
        
           if (pGameEngine.getJoueur().getAllItemsJoueur().VerifItem(vNomItem)) {

            if (!( pGameEngine.getListePNJ().containsKey(pGameEngine.getSelection()) || pGameEngine.getListePNJMoving().containsKey(pGameEngine.getSelection()) )){
            pGameEngine.getGui().println("Il n'y a pas de PNJ " + pGameEngine.getSelection());
            return;
          }
          
          
          if (!( pGameEngine.getListePNJRooms().get(pGameEngine.getSelection()) == pGameEngine.getJoueur().getCurrentRoom()  ||  pGameEngine.getListePNJMovingRooms().get(pGameEngine.getSelection()) == pGameEngine.getJoueur().getCurrentRoom() )){
            pGameEngine.getGui().println( pGameEngine.getSelection() + " n'est pas dans cette salle");
            return;
          }
            
        
            pGameEngine.getJoueur().setPoidsInventaire(pGameEngine.getJoueur().getPoidsInventaire() + pGameEngine.getJoueur().getAllItemsJoueur().retirerItem(vNomItem).getPoids());

            Item vItem = pGameEngine.getJoueur().getAllItemsJoueur().retirerItem(vNomItem);
            
            
            if ( pGameEngine.getListePNJ().containsKey(pGameEngine.getSelection()) )
             pGameEngine.getListePNJ().get(pGameEngine.getSelection()).ajoutItemPNJ(vNomItem, vItem);
             else
             pGameEngine.getListePNJMoving().get(pGameEngine.getSelection()).ajoutItemPNJ(vNomItem, vItem);
             
                       
            pGameEngine.getGui().println("Tu viens de donner:  "+vNomItem);

            pGameEngine.getJoueur().getAllItemsJoueur().removeItem(vNomItem);

        }
        else{
            pGameEngine.getGui().println("Pas d'item  '"+ vNomItem + "' dans l'inventaire");

        }
    }

}