import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TestaSLL extends JFrame implements ActionListener {
   // atributos
   private SLL        lista;
   private Container  cnt;
   private JPanel     pnlInserir, pnlRemover;
   private JTextField txtShow;
   private JLabel     lblIns, lblRem;
   private JButton    btnInsFirst, btnInsAt, btnInsLast, btnRemFirst, btnRemAt, btnRemLast;
   // construtor
   public TestaSLL() {
      super("SLL");
      // instacia lista
      lista = new SLL();
      // objetos da tela
      cnt = getContentPane();
      cnt.setLayout(new GridLayout(3, 1, 10, 10));
      pnlInserir  = new JPanel(new GridLayout(1, 4, 10, 10));
      pnlRemover  = new JPanel(new GridLayout(1, 4, 10, 10));
      txtShow     = new JTextField("");
      lblIns      = new JLabel("Inserir:");
      lblRem      = new JLabel("Remover:");
      btnInsFirst = new JButton("Início");
      btnInsAt    = new JButton("Meio");
      btnInsLast  = new JButton("Fim");
      btnRemFirst = new JButton("Início");
      btnRemAt    = new JButton("Meio");
      btnRemLast  = new JButton("Fim");
      // insere listener nos botoes
      btnInsFirst.addActionListener(this);
      btnInsAt.addActionListener(this);
      btnInsLast.addActionListener(this);
      btnRemFirst.addActionListener(this);
      btnRemAt.addActionListener(this);
      btnRemLast.addActionListener(this);
      // insere objetos no pnlInserir
      pnlInserir.add(lblIns);
      pnlInserir.add(btnInsFirst);
      pnlInserir.add(btnInsAt);
      pnlInserir.add(btnInsLast);
      // insere objetos no pnlRemover
      pnlRemover.add(lblRem);
      pnlRemover.add(btnRemFirst);
      pnlRemover.add(btnRemAt);
      pnlRemover.add(btnRemLast);
      // insere objetos no container
      cnt.add(txtShow);
      cnt.add(pnlInserir);
      cnt.add(pnlRemover);
      // configuracoes para o Frame
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500, 500);
      setVisible(true);
   }
   // actionPerformed
   public void actionPerformed(ActionEvent e) {
      String msg = "";
      if      (e.getSource() == btnInsFirst) {
         String carac = JOptionPane.showInputDialog("Digite o caracter:");
         lista.insertFirst(new SingleNode(carac.charAt(0), null));
         msg = "Elemento '" + carac + "' inserido com sucesso!";
      }
      else if (e.getSource() == btnInsAt) {
         String carac =                  JOptionPane.showInputDialog("Digite o caracter:");
         int    pos   = Integer.parseInt(JOptionPane.showInputDialog("Em qual posição?"));
         lista.insertAt(new SingleNode(carac.charAt(0), null), pos);
         msg = "Elemento '" + carac + "' inserido com sucesso!";
      }
      else if (e.getSource() == btnInsLast) {
         String carac = JOptionPane.showInputDialog("Digite o caracter:");
         lista.insertLast(new SingleNode(carac.charAt(0), null));
         msg = "Elemento '" + carac + "' inserido com sucesso!";
      }
      else if (e.getSource() == btnRemFirst) {
         if (lista.isEmpty()) msg = "Impossível retirar elemento: LISTA VAZIA!";
         else                 msg = "Elemento retirado: " + lista.removeFirst().getData();
      }
      else if (e.getSource() == btnRemAt) {
         if (lista.isEmpty()) msg = "Impossível retirar elemento: LISTA VAZIA!";
         else {
            int    pos   = Integer.parseInt(JOptionPane.showInputDialog("De qual posição?"));
            msg = "Elemento retirado: " + lista.removeAt(pos).getData();
         }
      }
      else if (e.getSource() == btnRemLast) {
         if (lista.isEmpty()) msg = "Impossível retirar elemento: LISTA VAZIA!";
         else                 msg = "Elemento retirado: " + lista.removeLast().getData();
      }
      txtShow.setText(lista.show());
      JOptionPane.showMessageDialog(null, msg);
   }
   // main
   public static void main(String args[]) {
      TestaSLL obj = new TestaSLL();
   }
}