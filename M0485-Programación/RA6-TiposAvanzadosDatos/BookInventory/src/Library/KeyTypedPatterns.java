/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.awt.event.KeyEvent;

/**
 *
 * @author migue
 */
public class KeyTypedPatterns {
    private KeyEvent evt;

    public KeyTypedPatterns(KeyEvent evt) {
        this.evt = evt;
    }
    
    public boolean patternISBN(javax.swing.JTextField field){
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String text = field.getText();

        if (Character.isDigit(c) && !Character.isDigit(c)) {
            return false;
        }
        if (!Character.isDigit(c)) {
            evt.consume();
            return false;
        }
        if (field.getCaretPosition() == 3 && text.length() == 3) {
            field.setText(text + "-");
        } else if (field.getCaretPosition() == 3 && text.length() > 3) {
            evt.consume();
            return false;
        } else if (field.getCaretPosition() == 6 && text.length() == 6) {
            field.setText(text + "-");
        } else if (field.getCaretPosition() == 6 && text.length() > 6 && evt.getKeyCode() == 8) {
            evt.consume();
            return false;
        } else if (field.getCaretPosition() == 10 && text.length() == 10) {
            field.setText(text + "-");
        } else if (field.getCaretPosition() == 10 && text.length() > 10) {
            evt.consume();
            return false;
        } else if (field.getCaretPosition() == 14 && text.length() == 14) {
            field.setText(text + "-");
        } else if (field.getCaretPosition() == 14 && text.length() > 14) {
            evt.consume();
            return false;
        } else if (text.length() > 15) {
            evt.consume();
            return false;
        }
        return true;
    }
}
