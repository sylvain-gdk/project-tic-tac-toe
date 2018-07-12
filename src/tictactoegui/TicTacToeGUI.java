/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author sylvain
 */
public class TicTacToeGUI extends JFrame {

    private Marque[][] grille; //grille a partir de la classe Marque
    private int ligne; //nombre de lignes dans la grille
    private int colonne; //nombre de colonnes dans la grille
    private int compteMarqueMax; //nombre de marques pour gagner
    private boolean turnX = true; //c'est le tour au 'x'
    private boolean gameOver = false; //la partie n'est pas terminee
    private boolean placer = false; //la marque n'est pas placee
    private int tauxX = 0, nulles = 0; //taux de reussite et nombre de parties nulles
    private int nbGagneX = 0, nbGagneO = 0, nbTotal = 0; //nombre de parties gagnees

    
    /**
     * Creates new form TicTacToeGUI
     */
    public TicTacToeGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Tic Tac Toe");
        jouer(3,3,3);        
    }
    
    /**
     * initialise la grille de jeu vide
     * @param ligne la ligne
     * @param colonne la colonne
     */
    public final void initGrille(int ligne, int colonne){
        int position;
        this.grille = new Marque[ligne][colonne];
        for(int i=0; i<grille.length; i++){
            for(int j=0; j<grille[i].length; j++){
                grille[i][j] = Marque.vide;
                position = i*getGrille().length+j;
                boutons(position).setIcon(new ImageIcon(getClass().getResource("/images/Vide.png"))); 
            }
        }
    }
    
    /**
     * converti (x,y) en position de 1 a 9
     * @param x la ligne
     * @param y la colonne
     * @return la position de 1 a 9
     */
    public int getPosition(int x, int y){
        int position = x*getGrille().length+y;             
        return position;
    }
    
    /**
     * pour entrer les marques dans la grille de jeu
     * @param x la ligne
     * @param y la colonne
     * @param marque la marque a jouer
     */
    public void setGrille(int x, int y, Marque marque){
        this.grille[x][y] = marque;
    }
    
    /**
     * @return la grille de jeu
     */
    public Marque[][] getGrille(){
        return grille;
    }

    /**
     * defini le nombre de lignes dans la grille
     * @param ligne_ le nombre de lignes
     */
    public void setLigne(int ligne_){
        this.ligne = ligne_;
    }
    
    /**
     * @return le nombre de lignes
     */
    public int getLigne(){
        return ligne;
    }
    
    /**
     * defini le nombre de colonne dans la grille
     * @param colonne_ le nombre de colonnes
     */
    public void setColonne(int colonne_){
        this.colonne = colonne_;
    }
    
    /**
     * @return le nombre de colonnes
     */
    public int getColonne(){
        return colonne;
    }
    
    /**
     * defini le nombre de marques requises pour gagner
     * @param compteMarqueMax_ le nombre de marques
     */
    public void setCompteMarqueMax(int compteMarqueMax_){
        this.compteMarqueMax = compteMarqueMax_;
    }
    
    /**
     * @return le nombre de marques requises pour gagner
     */
    public int getCompteMarqueMax(){
        return compteMarqueMax;
    }
    
    /**
     * defini si c'est le tour a 'X' de jouer
     * @param turnX true si c'est le tour a 'X' de jouer
     */
    public void setTurnX(boolean turnX){
        this.turnX = turnX;
    }
       
    /**
     * @return true si c'est le tour a 'X' de jouer 
     */
    public boolean getTurnX(){
        return turnX;
    }
    
    /**
     * defini si la partie est terminee
     * @param gameOver true si la partie est terminee
     */
    public void setGameOver(boolean gameOver){
        this.gameOver = gameOver;
    }
    
    /**
     * @return true si la partie est terminee
     */
    public boolean getGameOver(){
        return gameOver;
    }
    
    /**
     * defini si la marque est placee
     * @param placer true si la marque est placee
     */
    public void setPlacer(boolean placer){
        this.placer = placer;
    }
    
    /**
     * @return true si la marque est placee
     */
    public boolean getPlacer(){
        return placer;
    }
    
    /**
     * defini le taux de reussite pour 'X'
     * @param tauxX le taux de reussite pour 'X'
     */
    public void setTauxX(int tauxX){
        this.tauxX = tauxX;
    }
    
    /**
     * @return le taux de reussite pour 'X'
     */
    public int getTauxX(){
        return tauxX;
    }
    
    /**
     * defini le nombre de parties nulles
     * @param nulles le nombre de parties nulles
     */
    public void setNulles(int nulles){
        this.nulles = nulles;
    }
    
    /**
     * @return le nombre de parties nulles
     */
    public int getNulles(){
        return nulles;
    }
    
    /**
     * defini le nombre de parties gagnees par 'X'
     * @param nbGagneX le nombre de parties gagnees par 'X'
     */
    public void setNbGagneX(int nbGagneX){
        this.nbGagneX = nbGagneX;
    }
    
    /**
     * @return le nombre de parties gagnees par 'X'
     */
    public int getNbGagneX(){
        return nbGagneX;
    }
    
    /**
     * defini le nombre de parties gagnees par 'O'
     * @param nbGagneO le nombre de parties gagnees par 'O
     */
    public void setNbGagneO(int nbGagneO){
        this.nbGagneO = nbGagneO;
    }
    
    /**
     * @return le nombre de parties gagnees par 'O
     */
    public int getNbGagneO(){
        return nbGagneO;
    }
    
    
    /**
     * defini le nombre de parties jouees
     * @param nbTotal le nombre de parties jouees
     */
    public void setNbTotal(int nbTotal){
        this.nbTotal = nbTotal;
    }
    
    /**
     * @return le nombre de parties jouees
     */
    public int getNbTotal(){
        return nbTotal;
    }    

    /**
     * jouer une partie
     * @param ligne le nombre de lignes
     * @param colonne le nombre de colonnes
     * @param marqueMax le nombre de marques pour gagner
     */
    public final void jouer(int ligne, int colonne, int marqueMax){
        setCompteMarqueMax(marqueMax);
        setLigne(ligne);
        setColonne(colonne);
        initGrille(ligne, colonne);
        setEnablePan(centerPan, true);
        jButtonEncore.hide();
        jButtonStats.hide();
        jLabelFace.hide();
        statsPan.hide();
        centerPan.show();
        if(getNbTotal() == 0) setNbTotal(1);
        else setNbTotal(getNbTotal()+1);
        jLabel1.setText("Vous avez les 'X'.");
        jLabel2.setText("C'est à vous de jouer!");
        if(!getTurnX()) setMarqueAutoDificile(Marque.o);
    }
   
     /**
     * jouer une autre partie
     */
    public void jouerEncore(){ 
        setGameOver(false);
        setPlacer(false);
        this.jouer(3,3,3); 
    }
    
    /**
     * affiche la marque dans le GUI
     * @param position la position de la marque dans le GUI
     * @param marque la marque a placer
     */
    public void afficheGUI(int position, Marque marque){
        String image = "/images/Vide.png";
        if(marque == Marque.x)
            image = "/images/X.png";
        else if(marque == Marque.o)
            image = "/images/O.png";
        else if(marque == Marque.vide)
            image = "/images/Vide.png";
        boutons(position).setIcon(new ImageIcon(getClass().getResource(image)));
    } 
    
    /**
     * trouve le bouton correspondant a une position
     * @param position la position dans la grille
     * @return le bouton
     */
    public JButton boutons(int position){
        JButton bouton = new JButton();
        switch(position){
            case 0:
                bouton = jButton1;
                break;
            case 1:
                bouton = jButton2;
                break;
            case 2:
                bouton = jButton3;
                break;
            case 3:
                bouton = jButton4;
                break;
            case 4:
                bouton = jButton5;
                break;
            case 5:
                bouton = jButton6;
                break;
            case 6:
                bouton = jButton7;
                break;
            case 7:
                bouton = jButton8;
                break;
            case 8:
                bouton = jButton9;
                break;          
        }
        return bouton;
    }
            
    /**
     * controle la visibilitee des panels
     * @param container le panel
     * @param enable visible ou non
     */
    public void setEnablePan(Component container, boolean enable){
        container.setEnabled(enable);

        try {
            Component[] components= ((Container) container).getComponents();
            for (int i = 0; i < components.length; i++) {
                setEnablePan(components[i], enable);
            }
        } catch (ClassCastException e) {

        }
    }

    /**
     * un joueur place une marque dans le jeu
     * @param x la ligne
     * @param y la colonne
     * @param marque la marque a placer
     */
    public void setMarque(int x, int y, Marque marque){ 
        if(getGrille()[x][y] != Marque.vide){
            jLabel2.setText("Cette case est déjà occupée!");                   
        }
        else{
            jLabel2.setText("C'est à vous de jouer!");                   
            setGrille(x, y, marque);
            afficheGUI(getPosition(x, y), marque);
            setTurnX(false);
            setPlacer(false);
            validateGagne(marque);
            validateNulle(marque);
        }
        if(!getGameOver()){
            setMarqueAutoDificile(Marque.o);
            validateGagne(Marque.o);
            validateNulle(Marque.o);
        }
    }            

    
    /**
     * le systeme place une marque dans le jeu en mode dificile
     * @param marque la marque a placer
     */    
    public void setMarqueAutoDificile(Marque marque){
        //jLabel2.setText("C'est mon tour.");       
        int position;
        int compteur = 0;
        //compte les cases vides
        for(int i=0; i<getGrille().length; i++){
            for(int j=0; j<getGrille()[i].length; j++){
                if(getGrille()[i][j] == Marque.vide){
                    compteur++;
                }
            }
        }
        //place de facon aleatoire si au debut du jeu
        int casesTot = getLigne()*getColonne();
        if(compteur == casesTot || compteur == casesTot-1){
            int numX;
            int numY;
            do{
                Random genNum = new Random();
                int num = genNum.nextInt(casesTot);
                numX = num / getGrille().length;
                numY = num % getGrille().length;
            }while(getGrille()[numX][numY] != Marque.vide);
            setMarqueAuto(numX, numY, marque);
        }
        //analyse les marques adverse dans la grille avant de jouer
        for(int i=0; i<getGrille().length && !getPlacer(); i++){
            for(int j=0; j<getGrille()[i].length && !getPlacer(); j++){
                if(getGrille()[i][j] == Marque.vide){
                    position = i*getGrille().length+j;             
                    analysePosition(position, marque, Marque.x);
                }
            }
        }
        //analyse ses propres marques dans la grille avant de jouer
        for(int i=0; i<getGrille().length && !getPlacer(); i++){
            for(int j=0; j<getGrille()[i].length && !getPlacer(); j++){
                if(getGrille()[i][j] == Marque.vide){
                    position = i*getGrille().length+j;             
                    analysePosition(position, marque, Marque.o);
                }
            }
        }
        //si aucune marque n'est placee, place dans la premiere case vide
        if(!getPlacer()){
            for(int i=0; i<getGrille().length && !getPlacer(); i++){
                for(int j=0; j<getGrille()[i].length && !getPlacer(); j++){
                    if(getGrille()[i][j] == Marque.vide){
                       setMarqueAuto(i, j, marque);
                    }
                }
            }
        } 
    }
    
    /**
     * place une marque dans la grille apres un delais de 2 sec.
     * @param x pour la ligne
     * @param y pour la colonne
     * @param marque pour la marque a placer
     */
    public final void setMarqueAuto(int x, int y, Marque marque){
        grille[x][y] = marque;
        afficheGUI(getPosition(x, y), marque);
        setPlacer(true);
    }
    
    /**
     * affiche les statistiques
     */
    public void afficheStats(){
        centerPan.hide();
        statsPan.show();
        jButtonStats.hide();
        jButtonEncore.show();
        jLabel1.setText("");
        jLabelFace.show();
        if(getNbTotal() != 0){           
            setTauxX((getNbGagneX() * 100) / getNbTotal());
            setNulles(getNbTotal()-getNbGagneX()-getNbGagneO());
        }
        if(getTauxX() >= 40 && getTauxX() <= 60) jLabelFace.setIcon(new ImageIcon(getClass().getResource("/images/NotSure.png")));
        if(getTauxX() < 40) jLabelFace.setIcon(new ImageIcon(getClass().getResource("/images/Sad.png")));
        if(getTauxX() > 60) jLabelFace.setIcon(new ImageIcon(getClass().getResource("/images/Happy.png")));
        
        jLabel2.setText("------ Vos statistiques ------");
        jLabelJoue.setText(" Nombre de parties jouées : " + getNbTotal());
        jLabelGagne.setText(" Nombre de parties gagnées : " + getNbGagneX());
        jLabelPerdu.setText(" Nombre de parties perdues : " + getNbGagneO());
        jLabelNulles.setText(" Nombre de parties nulles : " + getNulles());
        jLabelTaux.setText(" Taux de réussite : " + getTauxX() + "%");
    }
    
    /**
     * analyse du systeme pour placer une marque
     * @param position la position de depart
     * @param marque la marque a placer
     * @param trouveMarque la marque a trouver
     */
    public final void analysePosition(int position, Marque marque, Marque trouveMarque){
        int x = position / grille.length;
        int y = position % grille.length;
        switch(position){
            case 0 : //en position 0
                if((grille[x][y+1] == grille[x][y+2] && grille[x][y+1] == trouveMarque) || 
                   (grille[x+1][y+1] == grille[x+2][y+2] && grille[x+1][y+1] == trouveMarque) || 
                   (grille[x+1][y] == grille[x+2][y] && grille[x+1][y] == trouveMarque)){
                    setMarqueAuto(x, y, marque);
                }
                break;
            case 1 ://en position 1
                if((grille[x+1][y] == grille[x+2][y] && grille[x+1][y] == trouveMarque) ||
                   (grille[x][y-1] == grille[x][y+1] && grille[x][y-1] == trouveMarque)){
                    setMarqueAuto(x, y, marque);
                }
                break;
            case 2 ://en position 2
                if((grille[x][y-1] == grille[x][y-2] && grille[x][y-1] == trouveMarque) || 
                   (grille[x+1][y-1] == grille[x+2][y-2] && grille[x+1][y-1] == trouveMarque) || 
                   (grille[x+1][y] == grille[x+2][y] && grille[x+1][y] == trouveMarque)){
                    setMarqueAuto(x, y, marque);
                }
                break;
            case 3 ://en position 3
                if((grille[x][y+1] == grille[x][y+2] && grille[x][y+1] == trouveMarque) ||
                   (grille[x-1][y] == grille[x+1][y] && grille[x-1][y] == trouveMarque)){
                    setMarqueAuto(x, y, marque);
                }
                break;
            case 4 ://en position 4
                if((grille[x-1][y-1] == grille[x+1][y+1] && grille[x-1][y-1] == trouveMarque) || 
                   (grille[x+1][y-1] == grille[x-1][y+1] && grille[x+1][y-1] == trouveMarque) || 
                   (grille[x][y-1] == grille[x][y+1] && grille[x][y-1] == trouveMarque) || 
                   (grille[x-1][y] == grille[x+1][y] && grille[x-1][y] == trouveMarque)){
                    setMarqueAuto(x, y, marque);
                }
                break;
            case 5 ://en position 5
                if((grille[x][y-1] == grille[x][y-2] && grille[x][y-1] == trouveMarque) ||
                   (grille[x-1][y] == grille[x+1][y] && grille[x-1][y] == trouveMarque)){
                    setMarqueAuto(x, y, marque);
                }
                break;
            case 6 ://en position 6
                if((grille[x-1][y] == grille[x-2][y] && grille[x-1][y] == trouveMarque) || 
                   (grille[x-1][y+1] == grille[x-2][y+2] && grille[x-1][y+1] == trouveMarque) || 
                   (grille[x][y+1] == grille[x][y+2] && grille[x][y+1] == trouveMarque)){
                    setMarqueAuto(x, y, marque);
                }
                break;
            case 7 ://en position 7
                if((grille[x-1][y] == grille[x-2][y] && grille[x-1][y] == trouveMarque) ||
                   (grille[x][y-1] == grille[x][y+1] && grille[x][y-1] == trouveMarque)){
                    setMarqueAuto(x, y, marque);
                }
                break;
            case 8 ://en position 8
                if((grille[x][y-1] == grille[x][y-2] && grille[x][y-1] == trouveMarque) || 
                   (grille[x-1][y-1] == grille[x-2][y-2] && grille[x-1][y-1] == trouveMarque) || 
                   (grille[x-1][y] == grille[x-2][y] && grille[x-1][y] == trouveMarque)){
                    setMarqueAuto(x, y, marque);
                }
                break;  
            default :
                break;
        }
    }
       
    /**
     * valide si la partie est gagnee
     * @param trouveMarque la marque a trouver
     * @return true si la partie est gagnee
     */
    public final boolean validateGagne(Marque trouveMarque){
        for(int i = 0; i < grille.length; i++){
            for(int j = 0; j < grille[i].length; j++ ){
                int ligneMax = grille.length-getCompteMarqueMax();
                int colMax = grille[i].length-getCompteMarqueMax();
                if(grille[i][j] == trouveMarque){
                    if(//diagonale en haut et a droite
                       (i >= getCompteMarqueMax() - 1 && j <= colMax && compteMarque(grille, i, j, -1, +1) == getCompteMarqueMax()) ||
                       //horizontale a droite
                       (j <= colMax && compteMarque(grille, i, j, 0, +1) >= getCompteMarqueMax()) ||
                       //diagonale en bas et a droite
                       (i <= ligneMax && j <= colMax && compteMarque(grille, i, j, +1, +1) >= getCompteMarqueMax()) ||
                       //verticale en bas
                       (i <= ligneMax && compteMarque(grille, i, j, +1, 0) >= getCompteMarqueMax())){
                            jLabel1.setText("Les '" + trouveMarque + "' ont gagnés!");
                            jLabel2.setText("*******************");
                            if(trouveMarque == Marque.x){
                                setNbGagneX(getNbGagneX()+1);
                                setTurnX(false);
                            }
                            else if(trouveMarque == Marque.o){
                                setNbGagneO(getNbGagneO()+1);
                                setTurnX(true);
                            }
                            setGameOver(true);
                            setEnablePan(centerPan, false);
                            jButtonEncore.show();
                            jButtonStats.show();
                    }
                }    
            }
        }
        return getGameOver();
    } 
    
    /**
     * compte les marques identiques
     * @param grille la grille de jeu
     * @param start_ligne le debut de la ligne
     * @param start_col le debut de la colonne
     * @param dir_ligne la direction a prendre pour la ligne
     * @param dir_col la direction a prendre pour la colonne
     * @return le nombre de marques identique
     */
    public final int compteMarque(Marque[][] grille, int start_ligne, int start_col, int dir_ligne, int dir_col){
        int compteur = 0;
        int x = start_ligne;
        int y = start_col;
        //augmente le compteur si la marque est identique a celle du debut
        while(x >= 0 && x < grille.length && y >= 0 && y < grille[x].length && grille[x][y] == grille[start_ligne][start_col]){
            ++compteur;
            x += dir_ligne;
            y += dir_col;
        }
        return compteur;
    }
    
    /**
     * valide si la partie est nulle
     * @param trouveMarque la marque a trouver
     * @return true si la grille est pleine sans gagnant
     */
    public final boolean validateNulle(Marque trouveMarque){
        int compteur = 0;
        for(int i = 0; i<grille.length; i++){
            for(int j = 0; j<grille[i].length; j++){
                if(grille[i][j] != Marque.vide)
                    compteur++;
            }
        }
        if(compteur == 9 && !getGameOver()){
            jLabel1.setText("La partie est nulle!");
            jLabel2.setText("********************");
            setEnablePan(centerPan, false);           
            jButtonEncore.show();
            jButtonStats.show();
            if(trouveMarque == Marque.x) setTurnX(false);
            else if(trouveMarque == Marque.o) setTurnX(true);
            setGameOver(true);
        }
        return getGameOver();       
    }           
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        centerPan = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        bottomPan = new javax.swing.JPanel();
        jButtonStats = new javax.swing.JButton();
        jButtonEncore = new javax.swing.JButton();
        statsPan = new javax.swing.JPanel();
        jLabelTaux = new javax.swing.JLabel();
        jLabelJoue = new javax.swing.JLabel();
        jLabelGagne = new javax.swing.JLabel();
        jLabelPerdu = new javax.swing.JLabel();
        jLabelNulles = new javax.swing.JLabel();
        jLabelFace = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(400, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topPan.setMinimumSize(new java.awt.Dimension(400, 75));
        topPan.setPreferredSize(new java.awt.Dimension(400, 75));
        topPan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topPan.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, 30));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topPan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 32));

        getContentPane().add(topPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 80));

        centerPan.setBackground(new java.awt.Color(0, 0, 0));
        centerPan.setAutoscrolls(true);
        centerPan.setMinimumSize(new java.awt.Dimension(0, 0));
        centerPan.setPreferredSize(new java.awt.Dimension(320, 320));
        centerPan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setOpaque(true);
        jButton1.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        centerPan.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 100));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setOpaque(true);
        jButton2.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        centerPan.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 100, 100));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setOpaque(true);
        jButton3.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        centerPan.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 100, 100));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setOpaque(true);
        jButton4.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        centerPan.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 100, 100));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setOpaque(true);
        jButton5.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        centerPan.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 100, 100));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setOpaque(true);
        jButton6.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        centerPan.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 100, 100));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setOpaque(true);
        jButton7.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        centerPan.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 100, 100));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setBorder(null);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setOpaque(true);
        jButton8.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        centerPan.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 100, 100));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setBorder(null);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setOpaque(true);
        jButton9.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        centerPan.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 100, 100));

        getContentPane().add(centerPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        bottomPan.setPreferredSize(new java.awt.Dimension(400, 75));
        bottomPan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonStats.setText("Stats");
        jButtonStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatsActionPerformed(evt);
            }
        });
        bottomPan.add(jButtonStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 120, 30));

        jButtonEncore.setText("Jouer Encore?");
        jButtonEncore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncoreActionPerformed(evt);
            }
        });
        bottomPan.add(jButtonEncore, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 120, 30));

        getContentPane().add(bottomPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 400, 75));

        statsPan.setPreferredSize(new java.awt.Dimension(320, 320));
        statsPan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTaux.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        statsPan.add(jLabelTaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 280, 20));

        jLabelJoue.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        statsPan.add(jLabelJoue, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 280, 20));

        jLabelGagne.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        statsPan.add(jLabelGagne, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 280, 20));

        jLabelPerdu.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        statsPan.add(jLabelPerdu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 280, 20));

        jLabelNulles.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        statsPan.add(jLabelNulles, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 280, 20));
        statsPan.add(jLabelFace, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 150, 150));

        getContentPane().add(statsPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setMarque(0,0,Marque.x);       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setMarque(0,1,Marque.x);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setMarque(0,2,Marque.x);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setMarque(1,0,Marque.x);   
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setMarque(1,1,Marque.x);  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.setMarque(1,2,Marque.x);   
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.setMarque(2,0,Marque.x);   
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.setMarque(2,1,Marque.x);    
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        this.setMarque(2,2,Marque.x);     
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButtonStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatsActionPerformed
        // TODO add your handling code here:  
        this.afficheStats();
    }//GEN-LAST:event_jButtonStatsActionPerformed

    private void jButtonEncoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncoreActionPerformed
        // TODO add your handling code here:
        this.jouerEncore();
    }//GEN-LAST:event_jButtonEncoreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPan;
    private javax.swing.JPanel centerPan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonEncore;
    private javax.swing.JButton jButtonStats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFace;
    private javax.swing.JLabel jLabelGagne;
    private javax.swing.JLabel jLabelJoue;
    private javax.swing.JLabel jLabelNulles;
    private javax.swing.JLabel jLabelPerdu;
    private javax.swing.JLabel jLabelTaux;
    private javax.swing.JPanel statsPan;
    private javax.swing.JPanel topPan;
    // End of variables declaration//GEN-END:variables
}
