import javax.swing.JOptionPane;
public class TestePilhaInt {
   public static void main(String args[]) {
      int tam = Integer.parseInt(JOptionPane.showInputDialog("Qual o tamanho da pilha?"));
      TelaPilha obj = new TelaPilha(tam);
   }
}