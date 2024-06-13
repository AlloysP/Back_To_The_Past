package pkg_room;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * Cette classe a pour but de retourner une Room aléatoire parmi la liste des rooms existantes.
 * 
 * @author Petit Alloys
 * @version 3.0
 */
public class RoomRandomizer
{
    private static HashMap<String, Room> aHashMapDesRooms;
    private static Room[] aListeRooms;
    private static int aNbRoom;
    private static String aStringTest;

    // private boolean aTestRandomRoom;

    /**
     * Constructeur ayant pour but d'initialiser les attributs static.
     */
    public RoomRandomizer(final Room[] pListeRooms, final int pNbRoom, final HashMap<String, Room> pHashMapDesRooms)
    {
        this.aNbRoom = pNbRoom;
        this.aListeRooms = pListeRooms;
        this.aHashMapDesRooms = pHashMapDesRooms;
    }

    /**
     *  Sert à obtenir la liste des rooms.
     */
    public void setListeRooms(final Room[] pListeRoom) {
        aListeRooms = pListeRoom;
    }

    /**
     *  Définit le nombre de Rooms présentes dans la liste des Rooms.
     */
    public void setNbRoom(final int pNbRoom) {
        aNbRoom = pNbRoom;
    }

    /**
     * Renvoie une des Rooms de la liste choisie au hasard, sauf si commande alea utilisée
     */
    public static Room findRandomRoom()
    {
        Random vRandomRoom = new Random();
        int vNbRandom = vRandomRoom.nextInt(aNbRoom);
        if (aStringTest == null) {
            return aListeRooms[vNbRandom];
        }
        else {
            ArrayList<String> vArrayList = new ArrayList<String>();

            for (String vString : aHashMapDesRooms.keySet()) {

                vArrayList.add(vString);

            }
            Collections.sort(vArrayList);

            vNbRandom = vArrayList.indexOf(aStringTest);

            return aListeRooms[vNbRandom];

        }

    }

    public void setStringTest(final String pStringTest){
        aStringTest = pStringTest;
    }

}
