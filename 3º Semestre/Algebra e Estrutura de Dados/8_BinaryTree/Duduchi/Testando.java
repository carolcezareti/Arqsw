public class Testando {
   public static void main(String args[]) {
      ArvBinOrd bt = new ArvBinOrd();
      
      bt.incArv(50);
      bt.incArv(40);
      bt.incArv(45);
      bt.incArv(35);
      bt.incArv(13);
      bt.incArv(37);
      bt.incArv(43);
      bt.incArv(48);
      bt.incArv(70);
      bt.incArv(69);
      bt.incArv(51);
      bt.incArv(80);
      bt.incArv(75);
      bt.incArv(90);
      bt.incArv(85);
      bt.incArv(20);
      bt.incArv(87);
      
      bt.inOrdem();
      bt.preOrdem();
      bt.posOrdem();
      bt.inversoOrdem();
      System.out.println("Altura da árvore: " + bt.altura());
      
      bt.excluiArv(20);

      bt.inOrdem();
      bt.preOrdem();
      bt.posOrdem();
      bt.inversoOrdem();
      
      System.out.println("Altura da árvore: " + bt.altura());
      
      //bt.excluiArv(40);
      //bt.inOrdem();
      
      System.exit(0);
   }
}