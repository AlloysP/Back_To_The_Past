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
public class MangerCommand extends Command
{
    /**
     * Constructor for objects of class RegarderCommand
     */
    public MangerCommand()
    {
    
    }
    
        /** 
     * Permet de manger afin de ne plus avoir faim ou poru pouvoir porter plus d'item grâce à un Cookie magique
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {

        
                if (!pCommand.hasSecondWord()) {
          pGameEngine.getGui().println("Tu as mangé et maintenant tu n'as plus faim");
        }
        else{
            String vNourriture = pCommand.getSecondWord();
             if (vNourriture.equals( "MagicCookie" )) {    //Condition qui pourra par la suite être enlevé si ajout d'autres objets mangeables
                
                  if (pJoueur.getAllItemsJoueur().VerifItem(vNourriture)){
                   pJoueur.getAllItemsJoueur().removeItem(vNourriture);
                   
                   pJoueur.setPoidsInventaire(pJoueur.getPoidsInventaire() + 5.5);
                   
                   pGameEngine.getGui().println("Tu as mangé un MagicCookie, tu as maintenant 5 places suplémentaires dans ton inventaire");
                 }
                 else {
                    pGameEngine.getGui().println("Il n'y a pas de " + vNourriture + " dans ton inventaire");
                 }
            
             }
             else{
              pGameEngine.getGui().println("Tu ne peux pas manger l'item " + vNourriture);
            }
            
        }
        
        
    }
    
}
