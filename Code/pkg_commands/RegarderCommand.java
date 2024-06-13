package pkg_commands;

import pkg_game.GameEngine;
import pkg_player.Player;
import pkg_player.Item;
import pkg_game.Parser;
/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * @author  Petit Alloys
 * @version 3.0
 */
public class RegarderCommand extends Command
{
    
    /** 
     * Permet de regarder la salle actuelle ou quand il y a un second mot l'item voulu 
     * ou quand le mode test est activé de regarder l'emplacement des PNJMoving
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        if (!pCommand.hasSecondWord()){
            pGameEngine.getGui().println(pJoueur.getCurrentRoom().getLongDescription());
            return;
        }
         String vSM = pCommand.getSecondWord();
        
        if (vSM.equals("PNJ") && pGameEngine.getTestActivé()){
            for ( String vS : pGameEngine.getListePNJMoving().keySet() ){
                pGameEngine.getGui().println(pGameEngine.getListePNJMoving().get(vS).getCurrentRoom().getShortDescription());
            }
            return;
        }
        
                if (pJoueur.getAllItemsJoueur().VerifItem(vSM)){
            Item vItem = pJoueur.getAllItemsJoueur().retirerItem(vSM);
            pGameEngine.getGui().println(vItem.toString());
            return;
        }
        
        if (pJoueur.getCurrentRoom().getAllItems().VerifItem(vSM)){
            Item vItem = pJoueur.getCurrentRoom().getAllItems().retirerItem(vSM);
            pGameEngine.getGui().println(vItem.toString());
            return;
        }
            pGameEngine.getGui().println("regarder quoi ? ");
    }
}
