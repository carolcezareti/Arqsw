/*
Utilizando pilha, fazer um método que receba uma frase num String
e retorne outro String com as palavras da frase invertidas,
conforme exemplo:

Recebe: "esta frase deve ser invertida"
Retorna: "atse esarf eved res aditrevni"
*/
import javax.swing.JOptionPane;
public class Ex1 {
   public static void main(String args[]) {
      String    frase = JOptionPane.showInputDialog("Frase:");
      PilhaChar stack = new PilhaChar(100);
      String    inver = "";
      int       i     = 0;
      while (i <= frase.length()) {
         if (i == frase.length() || frase.charAt(i) == ' ') {
            while (!stack.isEmpty()) {
               inver += stack.pop();
            }
            inver += " ";
         }
         else {
            stack.push(frase.charAt(i));
         }
         i++;
      }
      JOptionPane.showMessageDialog(null, "Original: " + frase + "\nInvertida: " + inver);
   }
}