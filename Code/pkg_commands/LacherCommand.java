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
public class LacherCommand extends Command
{
    /**
     * Constructor for objects of class RegarderCommand
     */
    public LacherCommand()
    {

    }

    /** 
     * Le joueur lache un objet présent dans son inventaire
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        if (!pCommand.hasSecondWord()){
            pGameEngine.getGui().println("lacher quoi ?");
            return;
        }
        String vNomItem = pCommand.getSecondWord();
        if (pGameEngine.getJoueur().getAllItemsJoueur().VerifItem(vNomItem)) {

            pGameEngine.getJoueur().setPoidsInventaire(pGameEngine.getJoueur().getPoidsInventaire() + pGameEngine.getJoueur().getAllItemsJoueur().retirerItem(vNomItem).getPoids());

            Item vItem = pGameEngine.getJoueur().getAllItemsJoueur().retirerItem(vNomItem);
            pGameEngine.getJoueur().getCurrentRoom().ajoutItem(vNomItem, vItem);
            pGameEngine.getGui().println("Tu viens de lâcher:  "+vNomItem);

            pGameEngine.getJoueur().getAllItemsJoueur().removeItem(vNomItem);

        }
        else{
            pGameEngine.getGui().println("Pas d'item  '"+ vNomItem + "' dans l'inventaire");

        }
    }

}
