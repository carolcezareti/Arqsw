import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TelaPilha extends JFrame implements ActionListener {
   // atributos
   private PilhaInt  stack;
   private Container ctn;
   private JPanel    pnlOeste, pnlLeste;
   private JButton   btnAdd, btnDel, btnRst, btnFim;
   private JLabel    lblPilha;
   private JTextArea tarPilha;
   // construtor
   public TelaPilha(int tamanho) {
      super("Testando Pilha com " + tamanho + " posições");
      // instanciando pilha
      stack = new PilhaInt(tamanho);
      // container
      ctn = getContentPane();
      ctn.setLayout(new BorderLayout());
      // botoes
      btnAdd = new JButton("Adicionar");
      btnDel = new JButton("Eliminar");
      btnRst = new JButton("Resetar");
      btnFim = new JButton("Sair");
      // adiconar listener nos botoes
      btnAdd.addActionListener(this);
      btnDel.addActionListener(this);
      btnRst.addActionListener(this);
      btnFim.addActionListener(this);
      // painel oeste
      pnlOeste = new JPanel(new GridLayout(4, 1));
      pnlOeste.add(btnAdd);
      pnlOeste.add(btnDel);
      pnlOeste.add(btnRst);
      pnlOeste.add(btnFim);
      // label
      lblPilha = new JLabel("Pilha");
      // textArea
      tarPilha = new JTextArea(20, 1);
      atualiza();
      // painel leste
      pnlLeste = new JPanel(new BorderLayout());
      pnlLeste.add(lblPilha, BorderLayout.NORTH);
      pnlLeste.add(tarPilha, BorderLayout.SOUTH);
      // adiciona paineis no container
      ctn.add(pnlOeste, BorderLayout.WEST);
      ctn.add(pnlLeste, BorderLayout.CENTER);
      // configuracoes para o Frame
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500, 500);
      setVisible(true);
   }
   // actionPerformed
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btnAdd) {
         int    elem;
         String msg = "Pilha cheia!\nImpossível inserir elemento!";
         if (!stack.isFull()) {
            elem = Integer.parseInt(JOptionPane.showInputDialog("Qual elemento?"));
            if (stack.push(elem)) msg = "Elemento " + elem + " inserido na pilha!";
            atualiza();
         }
         JOptionPane.showMessageDialog(null, msg);
      }
      else if (e.getSource() == btnDel) {
         String msg = "";
         if (stack.isEmpty()) msg = "Pilha vazia!\nImpossível retirar elemento!";
         else                 msg = "Elemento retirado: " + stack.pop();
         atualiza();
         JOptionPane.showMessageDialog(null, msg);
      }
      else if (e.getSource() == btnRst) {
         if (JOptionPane.showConfirmDialog(null, "Resetar pilha?", "Resetar..", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            stack.reset();
            atualiza();
            JOptionPane.showMessageDialog(null, "Pilha resetada!");
         }
      }
      else if (e.getSource() == btnFim) System.exit(0);
   }
   // atualiza
   public void atualiza() {
      tarPilha.setText(stack.show());
   }
}