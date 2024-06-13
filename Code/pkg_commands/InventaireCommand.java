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
public class InventaireCommand extends Command
{
    /**
     * Constructor for objects of class RegarderCommand
     */
    public InventaireCommand()
    {

    }

    /** 
     * Affiche l'inventaire du joueur
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        if (!pCommand.hasSecondWord()){
            pGameEngine.getGui().println(pJoueur.inventaire());
            return;
        }
        String vNom = pCommand.getSecondWord();

        
        if (pGameEngine.getListePNJRooms().containsKey(vNom)){

            if (!( pGameEngine.getListePNJRooms().get(vNom) == pGameEngine.getJoueur().getCurrentRoom() )){
                pGameEngine.getGui().println( vNom + " n'est pas dans cette salle");
                return;
            }

            pGameEngine.getGui().println("items" + vNom + ": " + pGameEngine.getListePNJ().get(vNom).getAllItemsPNJ().getItemsStringListe());
            return;
        }

        if (pGameEngine.getListePNJMovingRooms().containsKey(vNom)){

            if (!( pGameEngine.getListePNJMovingRooms().get(vNom) == pGameEngine.getJoueur().getCurrentRoom() )){
                pGameEngine.getGui().println(vNom + " n'est pas dans cette salle");
                return;
            }

            pGameEngine.getGui().println(pGameEngine.getListePNJMoving().get(vNom).getAllItemsPNJ().getItemsStringListe());
            return;
        }

        pGameEngine.getGui().println("Impossible d'accéder à l'inventaire de " + vNom);

    }

}
