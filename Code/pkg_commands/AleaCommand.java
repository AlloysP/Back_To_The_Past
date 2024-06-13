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
public class AleaCommand extends Command
{
    /**
     * Constructor for objects of class RegarderCommand
     */
    public AleaCommand()
    {
    
    }
    
        /** 
     * Si le mode test est activé la méthode donne à la transportRoom la salle vers laquelle il faut aller et quand
     *  il n'y a pas de second mot ça remet le téléporteur en mode aléatoire
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
             if (!pGameEngine.getTestActivé()){
             pGameEngine.getGui().println("Commande non disponible, utilise d'abord la commande tester pour activer le mode test");
              return;
            }
            
            String vNomRoom = pCommand.getSecondWord();
            
                                        if (pCommand.hasSecondWord()){
                                            
           if (pGameEngine.getHashMapRooms().containsKey(vNomRoom)) {
            pGameEngine.getIniStatic().setStringTestRandomizer(vNomRoom);
            pGameEngine.getGui().println("téléporteur initialisé");
            }
            else
            pGameEngine.getGui().println(vNomRoom + " n'est pas une salle existante");
          

        }
          else{
                        pGameEngine.getIniStatic().setStringTestRandomizer(null);
                        pGameEngine.getGui().println("téléporteur réinitialisé");
        }
        
        
        
    }
    
}
