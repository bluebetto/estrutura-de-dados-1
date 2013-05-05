public class No {
  private int valor;
  private No  prox;

  No() {
    valor = -1;
    prox = null;
  } // fim construtor

  public void setValor(int v) { valor = v;    }
  public void setProx(No p)   { prox  = p;    }
  public int  getValor()      { return valor; }
  public No   getProx()       { return prox;  }

} //fim classe No