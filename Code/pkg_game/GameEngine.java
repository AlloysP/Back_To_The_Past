package pkg_game;

import pkg_room.Beamer;
import pkg_player.Item;
import pkg_room.TransporterRoom;
import pkg_commands.CommandWords;
import pkg_commands.CommandWord;
import pkg_commands.Command;
import pkg_player.Player;
import pkg_player.PNJ;
import pkg_player.PNJMoving;
import pkg_room.Room;
import java.util.Stack;
import java.io.IOException;
import java.io.File;
import java.util.Scanner; 
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.HashMap;


/**
 *  Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique. L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * Cette classe crée toutes les Rooms, le parser et lance le jeu. 
 * Elle évalue aussi et execute les commandes que le parser retourne.
 *  the parser returns.
 * 
 * @author  Petit Alloys
 * @version 3.0
 */
public class GameEngine
{
    private Parser aParser;
    private UserInterface aGui;
    private Room[] aTabRoom;
    private Player aJoueur;
    private CommandWords aCommand;
    private int aCompteur;
    private TransporterRoom aIniStatic;
    private boolean aTestActivé;
    private HashMap<String, Room> aHashMapRooms;
    private HashMap<String, PNJ> aListePNJ;
    private HashMap<String, Room> aListePNJRooms;
    private HashMap<String, PNJMoving> aListePNJMoving;
    private HashMap<String, Room> aListePNJMovingRooms;
    private String aSelection;

    /**
     * Constructeur par défaut pour les objets de la classe GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aHashMapRooms = new HashMap<String, Room>();
        this.createRooms();
        this.createPlayer();
        this.aCommand = new CommandWords();
        this.aCompteur = 0;
        this.aTestActivé = false;
        //Pour initialiser les attributs static de la classe RoomRandomizer
        this.aIniStatic = new TransporterRoom("aIniStatic", "iniStatic", "Images/Anomalie.gif");
        this.aIniStatic.setRoomRandomizer(aTabRoom, aHashMapRooms);
        this.aListePNJ = new HashMap<String, PNJ>();
        this.aListePNJMoving = new HashMap<String, PNJMoving>();
        this.createPNJ();
        this.createPNJMoving();
        this.createLockedDoors();
        this.aSelection = "SelectionParDefaut";
    }
    

    /**
     * Change la valeur de aGui par la veleur entrée en paramètre puis fais appel à la méthode printWelcome()
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        aGui = pUserInterface;
        printWelcome();
    }

    /**
     * Crée toutes les salles et leurs assorties des sorties, et sélectionne la salle où le jeu commence.
     * Crée également un tableaux contenant toutes les Room. 
     */
    private void createRooms()
    {
        Room vPresent, vFuturProche, vFuturLointain, vTempsModernes, vPrehistoire, v19, vAnomalie, vTeleport;

        vPresent = new Room("vPresent", "Epoque Contemporaine", "Images/Comtemp.gif");
        vFuturProche = new Room("vFuturProche", "22ème siècle", "Images/Futurproche.gif");
        vFuturLointain = new Room("vFuturLointain", "3ème millènaire", "Images/Futurlointain.gif");
        vTempsModernes = new Room("vTempsModernes", "TempsModernes", "Images/TempsM.gif");
        vPrehistoire = new Room("vPrehistoire", "Prehistoire", "Images/prehistoire.gif");
        v19 = new Room("v19", "19ème siècle", "Images/19emeSiecle.gif");
        vAnomalie = new Room("vAnomalie", "Anomalie Temporelle", "Images/Anomalie.gif");
        vTeleport = new TransporterRoom("vTeleport", "TeleportRoom", "Images/Teleporteur.gif");

        vPresent.setExit ("est", vFuturProche);
        vPresent.setExit ("ouest", vFuturLointain);
        vPresent.setExit ("sud", vTempsModernes);
        vPresent.setExit ("haut", vAnomalie);  
        vFuturProche.setExit ("bas", vTeleport);
        vFuturProche.setExit ("ouest", vPresent);
        vFuturLointain.setExit ("est", vPresent);
        vTempsModernes.setExit ("est", vPrehistoire);
        vTempsModernes.setExit ("ouest", v19);
        vTempsModernes.setExit ("nord", vPresent);
        vPrehistoire.setExit ("ouest", vTempsModernes);
        v19.setExit ("est", vTempsModernes);
        v19.setExit ("nord", vFuturLointain);
        vAnomalie.setExit ("bas", vPresent);

        vPresent.setExit ("east", vFuturProche);
        vPresent.setExit ("west", vFuturLointain);
        vPresent.setExit ("south", vTempsModernes);
        vPresent.setExit ("up", vAnomalie);  
        vFuturProche.setExit ("west", vPresent);
        vFuturLointain.setExit ("east", vPresent);
        vTempsModernes.setExit ("east", vPrehistoire);
        vTempsModernes.setExit ("west", v19);
        vTempsModernes.setExit ("north", vPresent);
        vPrehistoire.setExit ("west", vTempsModernes);
        v19.setExit ("east", vTempsModernes);
        v19.setExit ("north", vFuturLointain);
        vAnomalie.setExit ("down", vPresent);

        //Creation HashMap des rooms dans l'ordre alphabétique pour l'exercice de la commande ALEA qui fonctionne en sauvegardant une String
        aHashMapRooms.put("v19",v19);
        aHashMapRooms.put("vAnomalie",vAnomalie); 
        aHashMapRooms.put("vFuturLointain",vFuturLointain); 
        aHashMapRooms.put("vFuturProche",vFuturProche);
        aHashMapRooms.put("vPrehistoire",vPrehistoire);
        aHashMapRooms.put("vPresent",vPresent);
        aHashMapRooms.put("vTeleport",vTeleport); 
        aHashMapRooms.put("vTempsModernes",vTempsModernes);

        aTabRoom= new Room[] {v19,vAnomalie,vFuturLointain,vFuturProche,vPrehistoire,vPresent,vTeleport, vTempsModernes};
        vPresent.ajoutItem("Chapeau", new Item("Chapeau","Chapeau usé", 5.5));
        vPresent.ajoutItem("Casquette", new Item("Casquette","Casquette usée", 9.0));
        vPresent.ajoutItem("MachineTemporelle", new Item("MachineTemporelle", "MachineTemporelle usée", 11.0));
        vPresent.ajoutItem("MagicCookie", new Item("MagicCookie", "Délicieux cookie magique", 0.5));

        vFuturProche.ajoutItem("beamer", new Beamer("beamer", "beamer", 1.0));
        vFuturProche.ajoutItem("ballon", new Item("ballon", "ballon usé", 1.0));
        vFuturLointain.ajoutItem("ballon", new Item("ballon", "ballon usé", 1.0));
        vTempsModernes.ajoutItem("ballon", new Item("ballon", "ballon usé", 1.0));
        vPrehistoire.ajoutItem("ballon", new Item("ballon", "ballon usé", 1.0));
        vPrehistoire.ajoutItem("PotionDeResurection", new Item("PotionDeResurection", "Potion pour ramener une personne à la vie", 0.2));
        v19.ajoutItem("ballon", new Item("ballon", "ballon usé", 1.0));
        vAnomalie.ajoutItem("ballon", new Item("ballon", "ballon usé", 1.0));

    }
    /**
     *  Crée un PNJ en lui donnant son nom, sa salle actuelle et le texte qu'il doit dire.
     */
    public void createPNJ() {
        PNJ vCharle = new PNJ("Charle");
        aListePNJ.put("Charle", vCharle);
        vCharle.setCurrentRoom(aHashMapRooms.get("vFuturLointain"));
        vCharle.setTexte("Salut, je m'appelle Charle");

        PNJ vJulie = new PNJ("Julie");
        aListePNJ.put("Julie", vJulie);
        vJulie.setCurrentRoom(aHashMapRooms.get("vFuturProche"));
        vJulie.setTexte("Salut, je m'appelle Julie");
    }

    /**
     *  crée une liste des Room des PNJ ou la recrée si elle existe déjà
     */
    public void getPNJRooms () {
        aListePNJRooms = new HashMap<String, Room>();
        for ( String vS : aListePNJ.keySet() )
            aListePNJRooms.put(vS, aListePNJ.get(vS).getCurrentRoom());

    }

    /**
     *  Retourne la liste des rooms des PNJ
     */
    public HashMap<String, Room> getListePNJRooms(){ 
        return aListePNJRooms;
    }

    /**
     *  Retourne la liste des PNJ
     */
    public HashMap<String, PNJ> getListePNJ(){ 
        return aListePNJ;
    }

    /**
     * Message de bienvenue au début du jeu
     */
    private void printWelcome()
    {
        aGui.print("\n");
        aGui.println("Bienvenue dans Back to Past!");
        aGui.println("Back to Past est un jeu d'aventure basé sur le voyage dans le temps");
        aGui.println("Tape '" + this.aCommand.getStringCommandWord(CommandWord.AIDE) + "' si tu as besoin d'aide.");
        aGui.println("tests possibles: test test2");
        aGui.print("\n");
        aGui.println(aJoueur.getCurrentRoom().getLongDescription());
        aGui.showImage(aJoueur.getCurrentRoom().getImageName());
    }

    /**
     *  Crée un PNJMoving en lui donnant son nom, sa salle actuelle et le texte qu'il doit dire.
     */
    public void createPNJMoving() {
        PNJMoving vJule = new PNJMoving("Jule");
        aListePNJMoving.put("Jule", vJule);
        vJule.setCurrentRoom(aHashMapRooms.get("vFuturProche"));
        vJule.setTexte("Salut, je m'appelle Jule. Je peux garder tes items si tu veux.");
        vJule.ajoutItemPNJ("Nourriture++", new Item("Nourriture++", "Nourriture illimitée", 10.5));
    }

    /**
     *  crée une liste des Room des PNJMoving ou la recrée si elle existe déjà
     */
    public void getPNJMovingRooms () {
        aListePNJMovingRooms = new HashMap<String, Room>();
        for ( String vS : aListePNJMoving.keySet() )
            aListePNJMovingRooms.put(vS, aListePNJMoving.get(vS).getCurrentRoom());

    }

    /**
     *  Retourne la liste des rooms des PNJMoving
     */
    public HashMap<String, Room> getListePNJMovingRooms(){ 
        return aListePNJMovingRooms;
    }

    /**
     *  Retourne la liste des PNJMoving
     */
    public HashMap<String, PNJMoving> getListePNJMoving(){ 
        return aListePNJMoving;
    }

    /**
     * Donne une une commande puis l'execute
     * Si cette commande termine la partie en cours, true est retourné et sinon false
     */
    public void interpretCommand(final String pCommandLine) 
    {

        aGui.println(pCommandLine);
        Command vCommand = aParser.getCommand(pCommandLine);

        if (aCompteur >= 45){
            aGui.println("Nombre de déplacement atteint, Vous avez perdu");
            endGame();
        }

        if(vCommand == null) {
            aGui.println("Je ne sais pas ce que tu veux dire...");
            return;
        }

        vCommand.execute(aJoueur, this, aParser, vCommand );

    }

    /**
     * Quitte le jeu et affiche un message.
     * 
     */
    public void endGame()
    {
        aGui.println("Merci d'avoir joué.  A la prochaine fois.");
        aGui.enable(false);
    }

    /**
     * Crée un nouveau joueur en lui donnant ses attributs tels que sa salle actuelle
     */
    public void createPlayer(){
        aJoueur = new Player("Mike", 10.0);
        aJoueur.setCurrentRoom(aTabRoom[5]);
    }

    public UserInterface getGui(){
        return aGui;
    }

    public Room[] getTabRoom(){
        return aTabRoom;
    }

    public int getCompteur(){
        return aCompteur;
    }

    public void setCompteur (final int pCompteur){
        aCompteur = pCompteur;
    }

    public boolean getTestActivé(){
        return aTestActivé;
    }

    public void setTestActivé(final boolean pTestActivé){
        aTestActivé = pTestActivé;
    }

    public HashMap<String,Room> getHashMapRooms (){
        return aHashMapRooms;
    }

    public TransporterRoom getIniStatic (){
        return aIniStatic;
    }   

    public Player getJoueur (){
        return aJoueur;
    }    

    
        public String getSelection(){
        return aSelection;
    }

    public void setSelection(final String pSelection){
        aSelection = pSelection;
    }
    
    
    public void createLockedDoors() {
        aHashMapRooms.get("vTempsModernes").setLockedDoor("Grosse Porte", false, "est", "east");
        Item vClefModerneEst = new Item("ClefModerneEst", "Ouvre la porte Est de l'époque Moderne", 0.1);
        aHashMapRooms.get("vTempsModernes").getListePortes().get("Grosse Porte").setClef("ClefModerneEst", vClefModerneEst);
        aJoueur.ajoutItemJoueur("ClefModerneEst", vClefModerneEst);
    }

}
