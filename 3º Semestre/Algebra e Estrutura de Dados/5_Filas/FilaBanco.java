import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class FilaBanco extends JFrame implements ActionListener {
   // atributos
   private FilaCInt   fPre, fCom;
   private int        senha;
   private Container  cnt;
   private JPanel     pnlQueues, pnlBotoes1, pnlBotoes2;
   private JLabel     lblPre, lblCom, txtPre, txtCom;
   private JButton    btnCom, btnPre, btnPro, btnRst, btnFim;
   // construtor
   public FilaBanco(int tamanho) {
      senha = 1;
      fPre  = new FilaCInt(tamanho);
      fCom  = new FilaCInt(tamanho);
      // labels
      lblPre = new JLabel("Preferencial:");
      txtPre = new JLabel("");
      txtPre.setFont(new Font("Arial", Font.BOLD, 20));
      lblCom = new JLabel("Comum:");
      txtCom = new JLabel("");
      txtCom.setFont(new Font("Arial", Font.BOLD, 20));
      atualizaFilas();
      // buttons
      btnCom = new JButton("Comum");
      btnPre = new JButton("Preferencial");
      btnPro = new JButton("Próóóóximo");
      btnRst = new JButton("Reset");
      btnFim = new JButton("Fim");
      // listeners nos buttons
      btnCom.addActionListener(this);
      btnPre.addActionListener(this);
      btnPro.addActionListener(this);
      btnRst.addActionListener(this);
      btnFim.addActionListener(this);
      // panel das filas
      pnlQueues = new JPanel(new GridLayout(2, 2));
      pnlQueues.add(lblPre);
      pnlQueues.add(txtPre);
      pnlQueues.add(lblCom);
      pnlQueues.add(txtCom);
      // 1º panel dos buttons
      pnlBotoes1 = new JPanel(new GridLayout(1, 3));
      pnlBotoes1.add(btnCom);
      pnlBotoes1.add(btnPre);
      pnlBotoes1.add(btnPro);
      // 2º panel dos buttons
      pnlBotoes2 = new JPanel(new GridLayout(1, 2));
      pnlBotoes2.add(btnRst);
      pnlBotoes2.add(btnFim);
      // container
      cnt = getContentPane();
      cnt.setLayout(new GridLayout(3, 1));
      // adiciona paineis no container
      cnt.add(pnlQueues);
      cnt.add(pnlBotoes1);
      cnt.add(pnlBotoes2);
      // configuracoes para o Frame
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(1000, 500);
      setVisible(true);
   }
   // actionPerformed
   public void actionPerformed(ActionEvent e) {
      if      (e.getSource() == btnCom) {
         if (!fCom.enQueue(senha++)) {
            senha--;
            JOptionPane.showMessageDialog(null, "Fila Comum LOTADA!");
         }
      }
      else if (e.getSource() == btnPre) {
         if (!fPre.enQueue(senha++)) {
            senha--;
            JOptionPane.showMessageDialog(null, "Fila Preferencial LOTADA!");
         }
      }
      else if (e.getSource() == btnPro) {
         String msg = "";
         if      (!fPre.isEmpty()) msg = "Próóóóóximo\n\nSENHA Nº " + fPre.deQueue();
         else if (!fCom.isEmpty()) msg = "Próóóóóximo\n\nSENHA Nº " + fCom.deQueue();
         else                      msg = "Não há clientes em espera!";
         JOptionPane.showMessageDialog(null, msg);
      }
      else if (e.getSource() == btnRst) {
         fCom.reset();
         fPre.reset();
         senha = 1;
      }
      else if (e.getSource() == btnFim) {
         System.exit(0);
      }
      atualizaFilas();
   }
   // atualizaFilas
   public void atualizaFilas() {
      txtPre.setText(fPre.show());
      txtCom.setText(fCom.show());
   }
}