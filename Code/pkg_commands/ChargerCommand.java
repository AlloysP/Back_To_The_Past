package pkg_commands;

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import pkg_room.Beamer;
import pkg_game.GameEngine;
import pkg_player.Item;
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
public class ChargerCommand extends Command
{
    /** 
     * Charge le beamer en lui faisant mémoriser la salle actuelle ou charge une sauvegarde
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        if (!pCommand.hasSecondWord()){
            pGameEngine.getGui().println("charger quoi ?");
            return;
        }

        String vNomItem = pCommand.getSecondWord();
        if (pGameEngine.getJoueur().getAllItemsJoueur().VerifItem(vNomItem)) {
            Beamer vBeamer;
            try{
                vBeamer = (Beamer) pGameEngine.getJoueur().getAllItemsJoueur().retirerItem(vNomItem); }
            catch (java.lang.ClassCastException pE) {
                pGameEngine.getGui().println("impossible de charger " + vNomItem);
                return;
            }

            vBeamer.setBeamerRoom( pGameEngine.getJoueur().getCurrentRoom()  );
            pGameEngine.getGui().println("beamer chargé");
        }
        else {
            String vNom;
            String vDescription;
            Double vPoids = 0.0;
            Integer vInt= 0;
            try {
                BufferedReader lect ;
                lect = new BufferedReader(new FileReader( vNomItem + ".txt")) ;

                pJoueur.setCurrentRoom(pGameEngine.getHashMapRooms().get(lect.readLine()));
                pJoueur.rangementStack(pJoueur.getCurrentRoom());
                pGameEngine.getGui().println(pJoueur.getCurrentRoom().getLongDescription());
                if(pJoueur.getCurrentRoom().getImageName() != null)
                    pGameEngine.getGui().showImage(pJoueur.getCurrentRoom().getImageName());

                vInt = Integer.valueOf(lect.readLine());
                pJoueur.getAllItemsJoueur().removeItemList();
                for (int vI = 0; vI < 	vInt; vI++)
                {
                    vNom =  lect.readLine();
                    vDescription = lect.readLine();
                    vPoids= Double.valueOf(lect.readLine());
                    pJoueur.ajoutItemJoueur(vNom, new Item(vNom, vDescription, vPoids));
                }

                vInt = Integer.valueOf(lect.readLine());
                while (lect.ready()== true)
                {
                    String vStringRoom = lect.readLine();
                    pGameEngine.getHashMapRooms().get(vStringRoom).getAllItems().removeItemList();
                    vInt = Integer.valueOf(lect.readLine());
                    for (int vI = 0; vI < 	vInt; vI++)
                    {
                        vNom =  lect.readLine();
                        vDescription = lect.readLine();
                        vPoids.valueOf(lect.readLine());
                        pGameEngine.getHashMapRooms().get(vStringRoom).getAllItems().mettreItem(vNom, new Item(vNom, vDescription, vPoids));
                    }
                }
            }
            catch (NullPointerException pE)
            {
                pGameEngine.getGui().println(pE.getMessage());

            }
            catch (IOException pE)
            {
                pGameEngine.getGui().println(pE.getMessage());
                return;
            }
        }
    }
}
