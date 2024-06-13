package pkg_room;

import java.util.HashMap;

/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * Cette classe instancie une salle qui téléporte le joueur dans une room au hasard.
 * 
 * @author Petit Alloys
 * @version 3.0
 */
public class TransporterRoom extends Room
{
    private RoomRandomizer aRoomRandomizer;

    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(final String pNomTransporterRoom, final String pDescription, final String pImage)
    {
        super(pNomTransporterRoom, pDescription, pImage);
    }

    /**
     * redéfinition de la méthode getExit pour faire appel à la méthode findRandomRoom quand le
     * joueur veut quitter la room.
     */
    @Override public Room getExit(final String pDirection)
    {
        return RoomRandomizer.findRandomRoom();
    }

    /**
     *  méthode qui permet d'inialiser les attributs static de la classe RoomRandomizer
     */
    public void setRoomRandomizer(final Room[] pListeRoom, final HashMap<String, Room> pHashMapDesRooms){
        aRoomRandomizer = new RoomRandomizer(pListeRoom, pListeRoom.length, pHashMapDesRooms);
    }

    /**
     *  Donne une valeur à l'attribut aStringTest de la classe RoomRandomizer
     */
    public void setStringTestRandomizer(final String pStringTest){
        aRoomRandomizer.setStringTest(pStringTest);
    }

    
}
