import javax.swing.JOptionPane;
public class TesteLDE {
   // lista singularmente encadeada
   public static LDE lista = new LDE();
   // metodo main
   public static void main(String args[]) {
      String menu[] = {"Inserir", "Excluir", "Listar", "Sair"};
      int    opcao;
      do {
         opcao = JOptionPane.showOptionDialog(null,
                                              "Selecione a opcao",
                                              "Menu Principal",
                                              JOptionPane.DEFAULT_OPTION,
                                              JOptionPane.WARNING_MESSAGE,
                                              null,
                                              menu,
                                              menu[0]);
         if      (opcao <= 1) auxiliar(opcao);
         else if (opcao == 2) JOptionPane.showMessageDialog(null, lista.show(), "Elementos da lista", JOptionPane.WARNING_MESSAGE);
      } while (opcao != menu.length - 1);
      // fim do programa
      System.exit(0);
   }
   // metodo auxiliar
   public static void auxiliar(int op) {
      int    opc       = 0;
      String str       = "";
      String generos[] = {"Feminino", "Masculino"};
      String simNao[]  = {"Sim", "Nao"};
      if (op == 0) str = "Inserir n";
      else         str = "Retirar d";
      String subMenu[] = {str + "o inicio", str +"o meio", str + "o fim"};
      opc = JOptionPane.showOptionDialog(null,
                                         "Selecione a opcao",
                                         "Menu secundario",
                                         JOptionPane.DEFAULT_OPTION,
                                         JOptionPane.WARNING_MESSAGE,
                                         null,
                                         subMenu,
                                         subMenu[0]);
      if (op == 0) {
         String nome   =                  JOptionPane.showInputDialog("Informe o nome:");
         int    idade  = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade:"));
         String genero = (String)         JOptionPane.showInputDialog(null,
                                                             "Informe o genero:",
                                                             "Genero",
                                                             JOptionPane.INFORMATION_MESSAGE,
                                                             null,
                                                             generos,
                                                             generos[0]);
         char   sexo = genero.toLowerCase().charAt(0);
         Pessoa p    = new Pessoa(nome, idade, sexo);

         if      (opc == 0) lista.insertFirst(p);
         else if (opc == 1) {
                 int posicao = Integer.parseInt(JOptionPane.showInputDialog("Inserir em qual posicao?"));
                 lista.insertAt(p, posicao);
         }
         else if (opc == 2) lista.insertLast(p);
      }
      else if (op == 1) {
         int sn = 0;
         if      (opc == 0) {
            sn = JOptionPane.showOptionDialog(null,
                                         "Deseja EXCLUIR " + lista.get(0).getNome() + "?",
                                         "Exclusao...",
                                         JOptionPane.DEFAULT_OPTION,
                                         JOptionPane.WARNING_MESSAGE,
                                         null,
                                         simNao,
                                         simNao[1]);
            if (sn == 0) lista.removeFirst();
         }
         else if (opc == 1) {
            int posicao = Integer.parseInt(JOptionPane.showInputDialog("Remover dequal posicao?"));
            sn = JOptionPane.showOptionDialog(null,
                                         "Deseja EXCLUIR " + lista.get(posicao).getNome() + "?",
                                         "Exclusao...",
                                         JOptionPane.DEFAULT_OPTION,
                                         JOptionPane.WARNING_MESSAGE,
                                         null,
                                         simNao,
                                         simNao[1]);
            if (sn == 0) lista.removeAt(posicao);
}
         else if (opc == 2) {
            sn = JOptionPane.showOptionDialog(null,
                                         "Deseja EXCLUIR " + lista.get(lista.size()-1).getNome() + "?",
                                         "Exclusao...",
                                         JOptionPane.DEFAULT_OPTION,
                                         JOptionPane.WARNING_MESSAGE,
                                         null,
                                         simNao,
                                         simNao[1]);
            if (sn == 0) lista.removeLast();
}
      }
   }
}