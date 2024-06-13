package pkg_player;

/**
 * 
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 *
 * Classe du PNJMoving, il s'agit en fait d'une classe PNJ dont seul le nom change 
 * pour respecter les consignes de l'exercice. Néansmoins créer des PNJMOving dans une nouvelle
 * classe permet de plus facilement pouvoir diférencier les PNJ "immobiles" des PNJ pouvants bouger.
 * Cette classe crée des PNJ pouvants se déplacer aléatoirement.
 * 
 * @author Alloys Petit
 * @version 3.0
 */
public class PNJMoving extends PNJ
{
    /**
     * Constructeur par défaut, crée un PNJ pouvant se déplacer aléatoirement.
     */
    public PNJMoving(final String pNomPNJMoving)
    {
        super(pNomPNJMoving);
    }
} // PNJMoving

