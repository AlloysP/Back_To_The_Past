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
public class SelectionnerCommand extends Command
{
    /** 
     * Sélectionne grace à une String des PNJ ou autre afin d'utiliser certaines commandes.
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        if (!pCommand.hasSecondWord()){
            pGameEngine.getGui().println("sélectionner quoi ?");
            return;
        }
        String vSelection = pCommand.getSecondWord();

        pGameEngine.setSelection(vSelection);

        pGameEngine.getGui().println(vSelection + " sélectionné");
    }

}