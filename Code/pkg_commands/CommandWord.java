package pkg_commands;

/**
 * Enumération du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps
 * en changeant d'images à chaque nouvelle "pièce".
 * 
 * Sont présents dans cette énumération toutes les commandes du jeux, ils servent de références pour pouvoir être appelés
 * par différentes commandes tapées au clavier et donc possiblement par différentes langues que le francais.
 * 
 * @author Petit Alloys
 * @version 3.0
 */
public enum CommandWord
{
    ALLER("aller", new GoCommand()), 
    QUITTER("quitter", new QuitCommand()), 
    AIDE("aide", new HelpCommand()), 
    REGARDER("regarder", new RegarderCommand()), 
    MANGER("manger", new MangerCommand()), 
    RETOUR("retour", new RetourCommand()), 
    ALEA("alea", new AleaCommand()),
    TESTER("tester", new TesterCommand()), 
    RAMASSER("ramasser", new RamasserCommand()), 
    INVENTAIRE("inventaire", new InventaireCommand()), 
    LACHER("lacher", new LacherCommand()), 
    INCONNUE("inconnue", null), 
    CHARGER("charger", new ChargerCommand()), 
    UTILISER("utiliser", new UtiliserCommand()),
    SELECTIONNER("selectionner", new SelectionnerCommand()),
    PRENDRE("prendre", new PrendreCommand()),
    DONNER("donner", new DonnerCommand()),
    SAUVEGARDER("sauvegarder", new SauvegarderCommand()),
    
    
    GO("go", new GoCommand()), 
    QUIT("quit", new QuitCommand()), 
    HELP("help", new HelpCommand()), 
    LOOK("look", new RegarderCommand()), 
    EAT("eat", new MangerCommand()), 
    BACK("back", new RetourCommand()), 
    TEST("test", new TesterCommand()), 
    PICK("pick", new RamasserCommand()), 
    ITEM("item", new InventaireCommand()), 
    DROP("drop", new LacherCommand()), 
    CHARGE("charge", new ChargerCommand()), 
    USE("use", new UtiliserCommand()), 
    RANDOM("random", new AleaCommand()),
    SELECT("select", new SelectionnerCommand()),
    TAKE("take", new PrendreCommand()), 
    GIVE("give", new DonnerCommand()),
    SAVE("save", new SauvegarderCommand());

    private String commandString;
    private Command aCommand;
    
    /**
     * initialise avec la commande correspondante.
     * @param commandWord la commande string.
     */
    CommandWord(final String commandString, final Command pCommand)
    {
        this.commandString = commandString;
        this.aCommand = pCommand;
    }
    
    
    /**
     * @return la commande en tant que String
     */
    public String toString()
    {
        return commandString;
    }
    
    
        /**
     * @return la commande
     */
    public Command toCommand()
    {
        return aCommand;
    }
    
}


