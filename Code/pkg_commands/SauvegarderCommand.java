package pkg_commands;

import java.io.PrintWriter;
import java.io.FileWriter;
import pkg_game.GameEngine;
import pkg_player.Player;
import pkg_room.Room;
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
public class SauvegarderCommand extends Command
{

    /** 
     *  Sauvegarde le jeu dans le fichier texte Sauvegarde.txt situé à la racine du jeu
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        if(!pCommand.hasSecondWord()) {
            pGameEngine.getGui().println("Sauvegarder où ?");
            return;
        }
        String vFichier = pCommand.getSecondWord();

        Item vItem;
        try{
            PrintWriter ecri = new PrintWriter(new FileWriter(vFichier +".txt" ));
            ecri.print(pJoueur.getCurrentRoom().getNomRoom() + System.getProperty("line.separator" ));
            ecri.print(pJoueur.getAllItemsJoueur().getHashMapItemList().size() + System.getProperty("line.separator" ));
            for ( String vS : pJoueur.getAllItemsJoueur().getHashMapItemList().keySet() ){
                vItem = pJoueur.getAllItemsJoueur().retirerItem(vS);
                ecri.print(vItem.getNom() + System.getProperty("line.separator" ));
                ecri.print(vItem.getDescription() + System.getProperty("line.separator" ));
                ecri.print(vItem.getPoids() + System.getProperty("line.separator" ));
            }

            for ( Room vR : pGameEngine.getTabRoom() ){
                ecri.print(vR.getNomRoom() + System.getProperty("line.separator" ));
                ecri.print(vR.getAllItems().getHashMapItemList().size() + System.getProperty("line.separator" ));

                for ( String vS : vR.getAllItems().getHashMapItemList().keySet() ){
                    vItem = vR.getAllItems().retirerItem(vS);
                    ecri.print(vItem.getNom() + System.getProperty("line.separator" ));
                    ecri.print(vItem.getDescription() + System.getProperty("line.separator" ));
                    ecri.print(vItem.getPoids() + System.getProperty("line.separator" ));
                }

            }

            ecri.flush();
            ecri.close();
            pGameEngine.getGui().println("Jeu sauvegardé");
        }
        catch (java.io.IOException pE) {pE.printStackTrace();}

    }
}
    