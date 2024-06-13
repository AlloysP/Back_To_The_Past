package pkg_commands;import java.util.Set;import java.util.Map;import java.util.HashMap;/** * Classe du jeu "Back to Past".  * "Back to Past" est un jeu textuel avec interface graphique.  L'utilisateur peut voyager dans le temps * en changeant d'images à chaque nouvelle "pièce". *  * Cette classe réalise une énumération de toutes les commandes connues du jeu * et les reconnait quand elles sont tapées au clavier. * * @author  Petit Alloys * @version 3.0 */public class CommandWords{    private HashMap<String, CommandWord> aValidCommands;    private HashMap<CommandWord, String> aValidCommandsInverse;    private HashMap<String, Command> aCommands;        /**     * Constructeur par defaut - Initialise toutes les commandes.     */    public CommandWords()    {        this.aValidCommands = new HashMap<String, CommandWord>();        for(CommandWord command : CommandWord.values()) {            if(command != CommandWord.INCONNUE) {                aValidCommands.put(command.toString(), command);            }        }                this.aValidCommandsInverse = new HashMap<CommandWord, String>();        this.créationValidCommandsInverse();                this.aCommands = new HashMap<String, Command>();                for(CommandWord command2 : CommandWord.values()) {            if(command2 != CommandWord.INCONNUE) {                aCommands.put(command2.toString(), command2.toCommand());            }        }    }            /**     * Verifie si une String donnee fait partie des commandes valides.      * @param pString la String a tester     * @return true si pString est une comande valide, false sinon     **/    public boolean isCommand(final String pString)    {        return aValidCommands.containsKey(pString);   }    /**     * Retourne une string de toutes les commandes valides     */    public String getCommandList()       {       StringBuilder returnString = new StringBuilder();                for(String command : aValidCommands.keySet()) {            returnString.append("  " + command);        }        return returnString.toString();             }                /**     * Retourne le CommandWord correspondant à la String entrée en paramètre de la HashMap     */    public Command getCommandWord(final String commandWord)    {        CommandWord vCommand = aValidCommands.get(commandWord);        if(vCommand != null) {            return (Command)vCommand.toCommand();        }        else {              return null;        }    }                  /**     * Retourne la String associée à l'objet CommandWord voulu dans la HashMap     */    public String getStringCommandWord(final CommandWord pCommandWord)    {      return (this.aValidCommandsInverse.get(pCommandWord));    }                     /**     *Rempli la HashMap permettant d'accéder aux Keys de aValidCommands grâce à ses valeurs.     */     public void créationValidCommandsInverse(){         Set<Map.Entry<String,CommandWord>> vSet = this.aValidCommands.entrySet();         for (Map.Entry<String,CommandWord> vMap : vSet) {           this.aValidCommandsInverse.put(vMap.getValue(), vMap.getKey()); }                 }                            /**     *     */    public Command get(String word)    {        return (Command)aCommands.get(word);    }   }