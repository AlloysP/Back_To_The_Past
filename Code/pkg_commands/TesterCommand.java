package pkg_commands;

import java.util.Scanner;
import java.io.File;

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
public class TesterCommand extends Command
{

    /** 
     * Test les différentes commandes présentes dans le fichier .txt donné
     */
    @Override public void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand)
    {

        pGameEngine.setTestActivé(true);
        pGameEngine.getGui().println("  ");
        pGameEngine.getGui().println("Mode Test activé");
        pGameEngine.getGui().println("Commande 'Tester off' pour sortir du mode");
        pGameEngine.getGui().println("  ");
        if (!pCommand.hasSecondWord()){
            pGameEngine.getGui().println("Tester quoi ?");
            return;
        }
        String vTextCommand = pCommand.getSecondWord();

        if(vTextCommand.equals("off")) {
            pGameEngine.setTestActivé(false);
            pGameEngine.getGui().println("Mode Test désactivé");
            return;
        }

        Scanner vScan;
        vScan = new Scanner(vTextCommand);
        try {
            vScan = new Scanner(new File("./"+vTextCommand+".txt"));
        }
        catch (java.io.FileNotFoundException pException) 
        {
            pGameEngine.getGui().println("Pas de fichier de ce nom");
        }

        while ( vScan.hasNextLine() ) {
            String pText = vScan.nextLine();
            pGameEngine.interpretCommand(pText);
        }
        if(vScan ==null){
            vScan.close();
        }

    }

}
