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
public class RamasserCommand extends Command
{
    /**
     * Constructor for objects of class RegarderCommand
     */
    public RamasserCommand()
    {

    }

    /** 
     *  Le joueur ramasse un objet présent dans la room
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {

        if (!pCommand.hasSecondWord()){
            pGameEngine.getGui().println("Prendre quoi ?");
            return;
        }
        String vNomItem = pCommand.getSecondWord();
        if (pGameEngine.getJoueur().getCurrentRoom().getAllItems().VerifItem(vNomItem)) {

            if (!(pGameEngine.getJoueur().getPoidsInventaire() <= pGameEngine.getJoueur().getCurrentRoom().getAllItems().retirerItem(vNomItem).getPoids())) {

                pGameEngine.getJoueur().setPoidsInventaire(pGameEngine.getJoueur().getPoidsInventaire() - pGameEngine.getJoueur().getCurrentRoom().getAllItems().retirerItem(vNomItem).getPoids());

                Item vItem = pGameEngine.getJoueur().getCurrentRoom().getAllItems().retirerItem(vNomItem);
                pGameEngine.getJoueur().ajoutItemJoueur(vNomItem, vItem);
                pGameEngine.getGui().println("Tu viens de ramasser:  "+vNomItem);

                pGameEngine.getJoueur().getCurrentRoom().getAllItems().removeItem(vNomItem);
            }
            else {
                pGameEngine.getGui().println("L'item "+vNomItem+" est bien trop lourd!");

            }

        }
        else{
            pGameEngine.getGui().println("Pas d'item  '"+ vNomItem + "'");

        }

    }

}
