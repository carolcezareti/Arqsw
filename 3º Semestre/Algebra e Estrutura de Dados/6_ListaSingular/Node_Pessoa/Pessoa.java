/*
   +-------------------------+
   |         Pessoa          |
   +-------------------------+
   | - nome:  String = ""    |
   | - idade: int    = 0     |
   | - sexo:  char   = 'f'   |
   +-------------------------+
   | + getNome() : String    |
   | + getIdade(): int       |
   | + getSexo() : char      |
   | + setNome(String): void |
   | + setIdade(int)  : void |
   | + setSexo(char)  : void |
   +-------------------------+
*/
public class Pessoa {
   // atributos
   private String nome;
   private int    idade;
   private char   sexo;
   // construtores
   public Pessoa() {
      this("", 0, 'f');
   }
   public Pessoa(String n, int i, char s) {
      setNome(n);
      setIdade(i);
      setSexo(s);
   }
   // metodos de aceso - get's
   public String getNome()  { return this.nome;  }
   public int    getIdade() { return this.idade; }
   public char   getSexo()  { return this.sexo;  }
   // metodos de modificacao
   public void setNome(String n) {
      this.nome = n;
   }
   public void setIdade(int i) {
      if (i < 0) i = 0;
      this.idade = i;
   }
   public void setSexo(char s) {
      if      (s == 'F')             s = 'f';
      else if (s == 'M')             s = 'm';
      else if (s != 'f' && s != 'm') s = 'f';
      this.sexo = s;
   }
}