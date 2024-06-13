package pkg_game;

import pkg_commands.CommandWord;
import pkg_commands.CommandWords;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;


/**
 * Classe du jeu "Back to Past". 
 * "Back to Past" est un jeu textuel avec interface graphique.  
 * L'utilisateur peut voyager dans le temps en changeant d'images à chaque nouvelle "pièce".
 * 
 * 
 * Crée une interface graphique avec une zone de saisie de texte, une zone d'affichage du texte et une image.
 * 
 * @author Petit Alloys
 * @version 3.0
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame aMyFrame;
    private JTextField aEntryField;
    private JTextArea aLog;
    private JLabel aImage;
    //     private JPanel aPan = new JPanel();
    private JButton aBoutonDroit;
    private JButton aBouton2;
    private JButton aBoutonGauche;
    private JButton aBoutonHaut;
    private JButton aBoutonBas;

    private JButton aBoutonEst;
    private JButton aBoutonOuest;
    private JButton aBoutonNord;
    private JButton aBoutonSud;
    
    private JButton aBoutonInventaire;

    
    private CommandWords aCommands;
    /**
     * 
     * Construit une interface utilisateur. Comme paramètre un Game Engine est requis.
     * 
     * @param gameEngine  Le GameEngine object implémente la logic du jeu.
     */
    public UserInterface(final GameEngine pGameEngine)
    {
        this.aEngine = pGameEngine;
        this.createGUI();
        this.aCommands = new CommandWords();
    }

    
    /**
     * Affiche du texte dans une zone de texte.
     */
    public void print(final String pText)
    {
        aLog.append(pText);
        aLog.setCaretPosition(aLog.getDocument().getLength());
    }

    /**
     * Affiche du texte dans une zone de texte, puis passe à la ligne suivante.
     */
    public void println(final String pText)
    {
        aLog.append(pText + "\n");
        aLog.setCaretPosition(aLog.getDocument().getLength());
    }

    /**
     * Montre un fichier d'image dans l'interface.
     */
    public void showImage(final String pImageName)
    {
        URL imageURL = this.getClass().getClassLoader().getResource(pImageName);
        if(imageURL == null)
            System.out.println("image non trouvée");
        else {
            ImageIcon icon = new ImageIcon(imageURL);
            aImage.setIcon(icon);
            aMyFrame.pack();
        }
    }

    /**
     * Active ou désactive l'input dans sa zone respective.
     */
    public void enable(final boolean pOn)
    {
        aEntryField.setEditable(pOn);
        if(!pOn)
            aEntryField.getCaret().setBlinkRate(0);
    }

    
    /**
     * Rend une interface utilisateur graphique.
     */
    private void createGUI()
    {
        aMyFrame = new JFrame("Back To The Past");
        aEntryField = new JTextField(34);
        aBoutonDroit = new JButton("Est");
        aBoutonGauche= new JButton("Ouest");

        aBoutonHaut= new JButton("Haut");
        aBoutonBas= new JButton("Bas");
        aBoutonEst = new JButton("Est");
        aBoutonOuest = new JButton("Ouest");
        aBoutonNord = new JButton("Nord");
        aBoutonSud = new JButton("Sud");
        
        aBoutonInventaire= new JButton ("Inventaire");
        

        aLog = new JTextArea();
        aLog.setEditable(false);
        JScrollPane listScroller = new JScrollPane(aLog);
        listScroller.setPreferredSize(new Dimension(200, 200));
        listScroller.setMinimumSize(new Dimension(100,100));

        
        
        
        
                JPanel panel3 = new JPanel();
        panel3.setBackground(Color.WHITE);
        panel3.setLayout(new BorderLayout());
//         panel3.add(aBoutonHaut, BorderLayout.NORTH);
//         panel3.add(aBoutonBas, BorderLayout.CENTER);
        

//                 JPanel panel2 = new JPanel();
//         panel2.setBackground(Color.WHITE);
// 
//         panel2.setLayout(new BorderLayout());
//         panel2.add(aBoutonOuest, BorderLayout.NORTH);
//         panel2.add(aBoutonOuest, BorderLayout.CENTER);
//         panel2.add(aBoutonSud, BorderLayout.SOUTH);
//         panel2.add(aBoutonEst, BorderLayout.EAST);
        
        
        
                    JPanel panel4 = new JPanel();
        panel4.setBackground(Color.WHITE);

        panel4.setLayout(new BorderLayout());
        panel4.add(aBoutonNord, BorderLayout.NORTH);
        panel4.add(aBoutonOuest, BorderLayout.CENTER);
        panel4.add(aBoutonSud, BorderLayout.SOUTH);
        panel4.add(aBoutonEst, BorderLayout.EAST);    
        
                panel3.add(panel4, BorderLayout.SOUTH);
//                         panel3.add(aBoutonHaut, BorderLayout.NORTH);
//         panel3.add(aBoutonBas, BorderLayout.CENTER);
        

                
                

        
//         JPanel panel4 = new JPanel();
//         panel4.setBackground(Color.WHITE);
// 
//         panel4.setLayout(new BorderLayout());
//         panel4.add(aBoutonHaut, BorderLayout.SOUTH);
//         panel4.add(aBoutonBas, BorderLayout.NORTH);


        
        
        
        
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        aImage = new JLabel();

        panel.setLayout(new BorderLayout());
        panel.add(aImage, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(aEntryField, BorderLayout.SOUTH);
        panel.add(aBoutonInventaire, BorderLayout.WEST);

        
        aMyFrame.getContentPane().add(panel, BorderLayout.CENTER);

        
        aMyFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {System.exit(0);}
            });

        aEntryField.addActionListener(this);
        //         aBouton2.addActionListener(this);
        aBoutonDroit.addActionListener(this);
        aBoutonGauche.addActionListener(this);
        aBoutonHaut.addActionListener(this);
        aBoutonBas.addActionListener(this);
        aBoutonNord.addActionListener(this);
        aBoutonOuest.addActionListener(this);
        aBoutonSud.addActionListener(this);
        aBoutonEst.addActionListener(this);
        aBoutonInventaire.addActionListener(this);

        aMyFrame.pack();
        aMyFrame.setVisible(true);
        aEntryField.requestFocus();

        
        
        aMyFrame.getContentPane().add(panel3, BorderLayout.EAST);
//         aMyFrame.getContentPane().add(aBoutonGauche, BorderLayout.WEST);
        aMyFrame.getContentPane().add(aBoutonBas, BorderLayout.SOUTH);
        aMyFrame.getContentPane().add(aBoutonHaut, BorderLayout.NORTH);

        

        
        
        
    }

    //     
    //     @override equals (final String pReference){
    //      retu;
    //     }

    /**
     * Une commande a été rentrée. Ecrit la commande et fait ce qui est nécessaire pour l'appliquer.
     * necessary to process it.
     */
    private void processCommand()
    {
        boolean finished = false;
        String input = aEntryField.getText();
        aEntryField.setText("");

        aEngine.interpretCommand(input);
    }

    /**
     * Interface du Actionlistener pour les entrées de texte ou les cliques sur les boutons.
     */
    public void actionPerformed(final ActionEvent pE) 
    {

        Object vTypeAction = pE.getActionCommand();

        //         if (vTypeAction == "Regarder") 
        // 		 aEngine.interpretCommand("regarder");
        // 		else        if (vTypeAction == "Nord")
        // 		 aEngine.interpretCommand("aller nord");
        // 		 else        if (vTypeAction == "Sud")
        // 		 aEngine.interpretCommand("aller sud");
        // 		 else        if (vTypeAction == "Est")
        // 		 aEngine.interpretCommand("aller est");
        // 		 else       if (vTypeAction == "Ouest")
        // 		 aEngine.interpretCommand("aller ouest");
        // 		 else
        //          processCommand();

        if (vTypeAction == "Regarder")
            aEngine.interpretCommand(this.aCommands.getStringCommandWord(CommandWord.REGARDER));
        else        if (vTypeAction == "Nord")
            aEngine.interpretCommand(this.aCommands.getStringCommandWord(CommandWord.ALLER) + " nord");
        else        if (vTypeAction == "Sud")
            aEngine.interpretCommand(this.aCommands.getStringCommandWord(CommandWord.ALLER) + " sud");
        else        if (vTypeAction == "Est")
            aEngine.interpretCommand(this.aCommands.getStringCommandWord(CommandWord.ALLER) + " est");
        else       if (vTypeAction == "Ouest")
            aEngine.interpretCommand(this.aCommands.getStringCommandWord(CommandWord.ALLER) + " ouest");
                    else       if (vTypeAction == "Bas")
            aEngine.interpretCommand(this.aCommands.getStringCommandWord(CommandWord.ALLER) + " bas");
                                else       if (vTypeAction == "Inventaire")
            aEngine.interpretCommand(this.aCommands.getStringCommandWord(CommandWord.INVENTAIRE));
                    else       if (vTypeAction == "Haut")
            aEngine.interpretCommand(this.aCommands.getStringCommandWord(CommandWord.ALLER) + " haut");
        else
            processCommand();

    }
    
}
