public class Limites {
   public static void main(String args[]) {
   
      String txt = "";
      txt += "INTEIROS\n========\n";
      txt += "\nByte    ==>  de " + Byte.MIN_VALUE    + " até " + Byte.MAX_VALUE;
      txt += "\nShort   ==>  de " + Short.MIN_VALUE   + " até " + Short.MAX_VALUE;
      txt += "\nInteger ==>  de " + Integer.MIN_VALUE + " até " + Integer.MAX_VALUE;
      txt += "\nLong    ==>  de " + Long.MIN_VALUE    + " até " + Long.MAX_VALUE;
      txt += "\n\nREAIS\n=====\n";
      txt += "\nFloat   ==>  de " + Float.MIN_VALUE   + " até " + Float.MAX_VALUE;
      txt += "\nDouble  ==>  de " + Double.MIN_VALUE  + " até " + Double.MAX_VALUE;
      System.out.println(txt);
      System.exit(0);
   }
}