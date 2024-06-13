package pkg_commands;

import pkg_room.Beamer;
import pkg_game.GameEngine;
import pkg_player.Player;
import pkg_player.Item;
import pkg_game.Parser;
/**
 * Classe du jeu "Back To The Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * @author  Petit Alloys
 * @version 3.0
 */
public class UtiliserCommand extends Command
{
    /**
     * Constructor for objects of class RegarderCommand
     */
    public UtiliserCommand()
    {

    }

    /** 
     * 
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        
                    if (!pCommand.hasSecondWord()){
      pGameEngine.getGui().println("charger quoi ?");
      return;
     }
     
         String vNomItem = pCommand.getSecondWord();

        if (!pGameEngine.getJoueur().getAllItemsJoueur().VerifItem(vNomItem)){
            pGameEngine.getGui().println( vNomItem + " non présent dans l'inventaire");
            return;
        }

        for ( String vS : pGameEngine.getJoueur().getCurrentRoom().getListePortes().keySet()){
            if(pGameEngine.getJoueur().getCurrentRoom().getListePortes().get(vS).getClefs().VerifItem(vNomItem)){

                if(pGameEngine.getJoueur().getCurrentRoom().getListePortes().get(vS).getPorteOuverte()){
                    pGameEngine.getJoueur().getCurrentRoom().getListePortes().get(vS).setPorteOuverte(false);
                    pGameEngine.getGui().println("Tu viens de fermée la porte " + vS);
                }
                else{
                    pGameEngine.getJoueur().getCurrentRoom().getListePortes().get(vS).setPorteOuverte(true);
                    pGameEngine.getGui().println("Tu viens d'ouvrir la porte " + vS);
                }

                return;
            }
        }

        Beamer vBeamer;
        try{
            vBeamer = (Beamer) pGameEngine.getJoueur().getAllItemsJoueur().retirerItem(vNomItem); }
        catch (java.lang.ClassCastException pE) {
            pGameEngine.getGui().println("impossible d'utiliser cet item");
            return;
        }

        if (vBeamer.getBeamerRoom() == null){
            pGameEngine.getGui().println( vNomItem + " non chargé");
            return;
        }

        pGameEngine.getJoueur().setCurrentRoom(vBeamer.getBeamerRoom());

        pGameEngine.getGui().println(pGameEngine.getJoueur().getCurrentRoom().getLongDescription());
        if(pGameEngine.getJoueur().getCurrentRoom().getImageName() != null)
            pGameEngine.getGui().showImage(pGameEngine.getJoueur().getCurrentRoom().getImageName());

    }

}
