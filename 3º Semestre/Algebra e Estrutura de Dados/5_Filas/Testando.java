import javax.swing.JOptionPane;
public class Testando {
   // main
   public static void main(String args[]) {
      int qtde = Integer.parseInt(JOptionPane.showInputDialog("Criar filas com quantos elementos?"));
      FilaBanco obj = new FilaBanco(qtde);
   }
}