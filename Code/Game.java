import pkg_game.UserInterface;
import pkg_game.GameEngine;

/**
 *  Classe principale du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 *  Pour jouer au jeu, crée une instance de cette classe.
 * 
 *  Cette classe implémente/instancie les objets nécessaires au démarrage du jeu et démarre et stop le jeu.
 * 
 * @author  Petit Alloys
 * @version 3.0
 */

public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Crée le jeu et initialise la map des "salles".
     */
    public Game() 
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface(aEngine);
        this.aEngine.setGUI(aGui);
    }
    
    
    public static void main(String[] args){
        Game BackToThePast = new Game();
    }
    
}
