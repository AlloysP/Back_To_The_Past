package pkg_commands;
import pkg_player.Player;
import pkg_game.GameEngine;
import pkg_game.Parser;

/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  
 * L'utilisateur peut voyager dans le temps en changeant d'images à chaque nouvelle "pièce". 
 *
 *
 *
 *Cette classe traite des informations à propos d'une commande qui vient de l'utilisateur.
 *Une commande consiste en deux String: une mot de commande et un second mot.
 *
 *La façon de faire: Les commandes sont déjà vérifiées comme étant une commande valide.
 *Si le joueur entre une commande invalide alors le mot de commande est <null>.
 *
 *Si la commande a seulement un mot alors le second mot est <null>
 *
 *
 * 
 * @author  Petit Alloys
 * @version 3.0
 */

public abstract class Command
{
    private CommandWord aCommandWord;
    private String aSecondWord;

    /**
     * 
     * Crée un objet command. Le premier et le second mots doivent etre appliqués, mais un ou les deux peuvent etre null. 
     * La commande devrait alors etre null pour indiquer que c'était une commande non reconnue du jeu.
     */
    public Command()
    {
        this.aCommandWord = null;
        this.aSecondWord = null;
    }

    
    /**
     * Return le premier mot de cette commande. Si la commande n'est pas comprise, le résultat est null.
     */
    public CommandWord getCommandWord()
    {
        return aCommandWord;
    }

    
        /**
     * 
     */
    public void setCommandWord(final CommandWord pCommandWord)
    {
        aCommandWord = pCommandWord;
    }
    
    
    /**
     * Return le second mot de la commande. Returns null s'il n'y a pas de second mot.
     */
    public String getSecondWord()
    {
        return aSecondWord;
    }
    
    
        /**
     * 
     */
    public void setSecondWord(final String secondWord)
    {
        this.aSecondWord = secondWord;
    }

    
    /**
     * Vérifie si la commande a été comprise.
     */
    public boolean isUnknown()
    {
        return (aCommandWord == CommandWord.INCONNUE);
    }


    
    /**
     * Return true si la commande a un second mot.
     */
    public boolean hasSecondWord()
    {
        return (aSecondWord != null);
    }
    
    
        /**
         * Méthode sans corps qui sert à obliger toutes les nouvelles classes d'overide cette méthode qui remplacera
         * le corps des différentes méthodes qui étaient présentent dans GameEngine.
         * Il y a 4 paramètres afin que les méthodes ayent un accès facil à tous les objets nécessaires
         * à leur fonctionnement.
         */
    public abstract void execute(final Player pJoueur, final GameEngine pGameEngine, final Parser pParser, final Command pCommand);
    
    
}