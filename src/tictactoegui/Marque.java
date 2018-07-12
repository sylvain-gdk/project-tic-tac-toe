/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;


/**
 * classe pour gerer la marque de placement
 * @author Sylvain Goedike
 */
public enum Marque {
    x('X'), o('O'), vide(' ');
    
    private final char ch;
    /**
     * construit la marque
     * @param ch marque pour le placement
     */
    Marque(char ch){
        this.ch = ch;
    }
    
    /**
     * converti le charactere en string
     * @return String la marque
     */
    @Override
    public String toString(){
        return String.format("%c", this.ch);
    }
    
    
}
