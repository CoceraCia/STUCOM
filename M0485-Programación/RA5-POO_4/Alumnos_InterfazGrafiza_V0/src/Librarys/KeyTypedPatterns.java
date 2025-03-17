/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Librarys;

/**
 *
 * @author migue
 */
public class KeyTypedPatterns{

    public boolean patDni(java.awt.event.KeyEvent evt, String text, int caretPos) {
        // TODO add your handling code here:
        text += evt.getKeyChar();
        char[] textSplitted = text.toCharArray();
        int len = text.length();
        for (int i = 0; i < len; i++) {
            if (len < 9) { // si la longitud es menor a 8 solo pueden ser numeros
                if (!Character.isDigit(textSplitted[i])) {
                    return false;
                }
            } else if (len < 10 && caretPos == 8) { // el ultimo numero solo puede ser una letra
                if (Character.isDigit(textSplitted[8])) {
                    return false;
                }
            } else { //cualquier otro valor sera eliminado ya que la longitud maxima de 1 DNI consta de 9 char
                return false;
            }
        }
        return true;
    }
}
