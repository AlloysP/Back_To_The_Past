package pkg_commands;

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
public class RetourCommand extends Command
{
        /** 
     *  Fais retourner le personnage dans la salle précédente, c'est-à-dire la salle dont il vient.
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
          if (!pJoueur.verifStack() ){
              pGameEngine.setCompteur( pGameEngine.getCompteur() + 1);
            pJoueur.setCurrentRoom( pJoueur.retireStack());
            
            
            pGameEngine.getGui().println(pJoueur.getCurrentRoom().getLongDescription());
            if(pJoueur.getCurrentRoom().getImageName() != null)
                pGameEngine.getGui().showImage(pJoueur.getCurrentRoom().getImageName());
            }
            else
            pGameEngine.getGui().println("Pas de salle précédente");
    }
    
}
