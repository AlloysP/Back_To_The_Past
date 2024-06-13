package pkg_commands;

import pkg_room.Room;
import pkg_game.GameEngine;
import pkg_player.Player;
import pkg_player.PNJ;
import pkg_game.Parser;

/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * @author  Petit Alloys
 * @version 3.0
 */
public class GoCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public GoCommand()
    {

    }

    /** 
     * Fonctionne avec la commande go, c'est pour aller dans une direction voulue qui sera écrite dans la deuxième commande.
     * S'il y a une pièce dans la direction voule on change de pièce et sinon affiche un message d'erreur. 
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {
        if(!pCommand.hasSecondWord()) {
            pGameEngine.getGui().println("Aller où ?");
        }

        String vDirection = pCommand.getSecondWord();
        Room vNextRoom = pJoueur.getCurrentRoom().getExit(vDirection);

        if (vNextRoom == null)
            pGameEngine.getGui().println("Il n'y a pas de salle dans cette direction!");

        else {

            for ( String vS : pGameEngine.getJoueur().getCurrentRoom().getListePortes().keySet()){
                if (pGameEngine.getJoueur().getCurrentRoom().getListePortes().get(vS).getPorteExitFr().equals(vDirection) || pGameEngine.getJoueur().getCurrentRoom().getListePortes().get(vS).getPorteExitEn().equals(vDirection)){
                    if (pGameEngine.getJoueur().getCurrentRoom().getListePortes().get(vS).getPorteOuverte() == false){
                        pGameEngine.getGui().println("Cette Porte est verouillée");
                        return;
                    }
                }
            }

            pGameEngine.getPNJRooms();
            pGameEngine.getPNJMovingRooms();

            pJoueur.rangementStack(pJoueur.getCurrentRoom());

            if (vNextRoom == pGameEngine.getTabRoom()[2]) {
                if (vDirection.equals("nord") || vDirection.equals("north"))
                    pJoueur.nouvelleStack();
            }

            pGameEngine.setCompteur(pGameEngine.getCompteur() + 1);

            //             Situation gagnante
            if (vNextRoom == pGameEngine.getTabRoom()[5]) {
                if (pJoueur.getAllItemsJoueur().VerifItem("Nourriture++")){
                    if (pJoueur.getAllItemsJoueur().VerifItem("PotionDeResurection")){
                      pGameEngine.getGui().println("Tu as gagné!");
                      pGameEngine.getGui().println("Grâce à la nourriture illimité la terre est sauvée");
                      pGameEngine.getGui().println("et tu peux sauver ta femme avec la potion de résurection !");
                      pGameEngine.endGame();
                    }
                } 
            }

            
            pJoueur.setCurrentRoom( vNextRoom );
            pGameEngine.getGui().println(pJoueur.getCurrentRoom().getLongDescription());
            if(pJoueur.getCurrentRoom().getImageName() != null)
                pGameEngine.getGui().showImage(pJoueur.getCurrentRoom().getImageName());

            if (pGameEngine.getListePNJRooms().containsValue(vNextRoom)){

                for ( String vS : pGameEngine.getListePNJ().keySet() ){
                    if (pGameEngine.getListePNJ().get(vS).getCurrentRoom() == vNextRoom){

                        pGameEngine.getGui().println(pGameEngine.getListePNJ().get(vS).getTexte()); 
                    }
                }
            }

            if (pGameEngine.getCompteur()%3 == 1){
                for ( String vS : pGameEngine.getListePNJMoving().keySet() ){
                    pGameEngine.getListePNJMoving().get(vS).setCurrentRoom(pGameEngine.getIniStatic().getExit("hgdbr"));
                }
            }

            if (pGameEngine.getListePNJMovingRooms().containsValue(vNextRoom)){

                for ( String vS : pGameEngine.getListePNJMoving().keySet() ){

                    if (pGameEngine.getListePNJMoving().get(vS).getCurrentRoom() == vNextRoom){
                        pGameEngine.getGui().println(pGameEngine.getListePNJMoving().get(vS).getTexte()); 
                    }
                }
            }

        }

    }
}
