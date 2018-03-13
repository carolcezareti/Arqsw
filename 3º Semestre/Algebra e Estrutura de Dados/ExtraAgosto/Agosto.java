import javax.swing.JOptionPane;
public class Agosto {
   // variável global
   static Node vet[];
   public static void main(String args[]) {
      // variáveis e objetos
      int    qtde     = Integer.parseInt(JOptionPane.showInputDialog("Quantas posições?"));
      vet             = new Node[qtde];
      for (int i = 0; i < vet.length; i++) {
         vet[i] = new Node();
      }
      String opcoes[] = {"Cadastrar", "Alterar", "Eliminar", "Listar Tudo", "Sair"};
      int    opcao;
      // menu
      do {
         opcao = JOptionPane.showOptionDialog(
                              null,
                              "Clique na opção desejada",
                              "Menu",
                              JOptionPane.DEFAULT_OPTION,
                              JOptionPane.WARNING_MESSAGE,
                              null,
                              opcoes,
                              opcoes[0]);
         if      (opcao == 0) cadastrar();
         else if (opcao == 1) alterar();
         else if (opcao == 2) eliminar();
         else if (opcao == 3) listar();
      } while(opcao != 4);
      // fim   
      System.exit(0);
   }
   // cadastrar
   public static void cadastrar() {
      String msg = "";
      int i = Integer.parseInt(JOptionPane.showInputDialog("Qual o índice?"));
      if (i < 0 || i >= vet.length) msg = "Índice inválido";
      else {
         if (vet[i].isLocked()) msg = "Node reservado!";
         else {
            String dados = JOptionPane.showInputDialog("Insira a informação:");
            vet[i].setData(dados);
            vet[i].lock();
            msg = "Posição " + i + " reservada com sucesso!";
         }
      }
      JOptionPane.showMessageDialog(null, msg);
   }
   // alterar
   public static void alterar() {
      String msg = "";
      int i = Integer.parseInt(JOptionPane.showInputDialog("Qual o índice?"));
      if (i < 0 || i >= vet.length) msg = "Índice inválido";
      else {
         if (!vet[i].isLocked()) msg = "Node vazio!";
         else {
            String dados = JOptionPane.showInputDialog("Insira a informação:");
            vet[i].setData(dados);
            msg = "Posição " + i + ": dados alterados com sucesso!";
         }
      }
      JOptionPane.showMessageDialog(null, msg);
   }
   // eliminar
   public static void eliminar() {
      String msg = "";
      int i = Integer.parseInt(JOptionPane.showInputDialog("Qual o índice?"));
      if (i < 0 || i >= vet.length) msg = "Índice inválido";
      else {
         if (!vet[i].isLocked()) msg = "Node vazio!";
         else {
            vet[i].kill();
            msg = "Posição " + i + ": dados eliminados com sucesso!";
         }
      }
      JOptionPane.showMessageDialog(null, msg);
   }
   // listar
   public static void listar() {
      String msg = "";
      int    i;
      for (i = 0; i < vet.length; i++) {
         if (vet[i].isLocked()) msg += "\n[" + i + "]: " + vet[i];
      }
      JOptionPane.showMessageDialog(null, msg);
   }
}