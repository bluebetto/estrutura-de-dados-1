public class Lista {
  private No inicio;

  private No criaNo(int v) {
    No tmp = new No();
    tmp.setValor(v);
    return tmp;
  }

  Lista() {
    inicio = null;
  } // fim construtor

  public void inserirFinal(int v) {
    No tmp = inicio;

    if(inicio == null) {
      inicio = criaNo(v);
    } // fim if
    else {
      while(tmp.getProx() != null) {
        tmp = tmp.getProx();
      } // fim while 
      tmp.setProx(criaNo(v));
    } // fim else
  } // fim inserirFinal
  
  public void insereInicio(int v){
	  No tmp;
	  if(inicio == null){
		  inicio = criaNo(v);
	  }else{
		  tmp = criaNo(v);
		  tmp.setProx(inicio);
		  inicio = tmp;
	  }
  }
  
  public int retiraInicio() throws Exception{
	  No tmp;
	  if(inicio == null){
		  throw new Exception("Lista vazia");
	  }else{
		  tmp = inicio;
		  inicio = inicio.getProx();
		  tmp.setProx(null);
		  return tmp.getValor();
	  }
  }
  
  public int retiraFinal() throws Exception{
	  No tmp;
	  int retorno; //Valor do nó a ser retornado
	  if(inicio == null){
		  throw new Exception("Lista vazia");
	  }else if(inicio.getProx() == null){
		  retorno = inicio.getValor();
		  inicio = null;
		  return retorno;
	  }else{
		  tmp = inicio;
		  while(tmp.getProx().getProx() != null){
			  tmp = tmp.getProx();
		  }
		  retorno = tmp.getProx().getValor();
		  tmp.setProx(null);
		  return retorno;
	  }
  }
  
  public No retiraPosicao(int posicao) throws Exception{
	  int i = 0;
	  No atual = inicio;
	  No retirado;
	  if(!isEmpty()){
		  while(i != posicao-1){
			  atual = atual.getProx();
			  i++;
		  }
		  
		  retirado = atual.getProx();
		  atual.setProx(retirado.getProx());
		  
		  return retirado;
	  }else{
		  throw new Exception("Lista vazia");
	  }
  }
  
  public void imprimir() {
    No tmp = inicio;
    if(tmp == null) {
      System.out.println("Lista Vazia");
    } else {
      while(tmp != null) {
        System.out.print(tmp.getValor());
        
        if(tmp.getProx()!= null){
        	System.out.print(", ");
        }
        tmp = tmp.getProx();
      } // fim while
      System.out.println();
    } // fim else
    
  } // fim imprimir
  
  public void ordenar() {
	  No anterior, atual, proximo, fim;
	    
	    atual = inicio;
	    proximo  = inicio.getProx();
	    if(atual == null) { 
	      System.out.println("Ordenacao nao realizada: Lista Vazia");
	    } else if (atual.getProx() == null) { 
	    	
	    } else {
	    	if(inicio == null){
	            System.out.println("Lista vazia");
	        }else if(inicio.getProx() == null){
	            System.out.println("1 elemento");
	        }else{
	        	//A lista tem mais de 2 elementos
	            //Pré inicializando o loop
	            atual = inicio;
	            fim = null;
	            //Enquanto o proximo não for igual ao final
	            //Sendo q no começo o final é null
	            while(atual.getProx() != fim){
	            	
	                proximo = inicio.getProx();
	                
	                if(atual.getValor() > proximo.getValor()){
	                    //System.out.println(atual.getValor()+ " > "+proximo.getValor()+"");
	                    atual.setProx(proximo.getProx());
	                    proximo.setProx(atual);
	                    inicio = proximo;
	                    proximo = atual.getProx();
	                    
	                    //System.out.println("O inicio agora é: "+inicio.getValor());
	                    
	                }else{
	                    atual = atual.getProx();
	                    proximo = proximo.getProx();
	                }

	                anterior = inicio;
	                //Enquanto o proximo não for o fim da lista
	                while(proximo != fim){
	                    if(atual.getValor() > proximo.getValor()){
	                        //System.out.println(atual.getValor()+ " > "+proximo.getValor()+": trocado");
	                        atual.setProx(proximo.getProx());
	                        proximo.setProx(atual);
	                        anterior.setProx(proximo);
	                        proximo = atual.getProx();
	                        anterior = anterior.getProx();
	                    }else{
	                        //System.out.print(atual.getValor()+ " < "+proximo.getValor()+" - ");
	                        anterior = anterior.getProx();
	                        atual = atual.getProx();
	                        proximo = proximo.getProx();
	                    }
	                }
	                
	                fim = atual;
	                atual = inicio;
	            }
	        }
	     
	    } // fim else
    
  
  } // fim ordenar
  
  
  public int tamanho(){
	  int i = 0;
	  No tmp = inicio;
	  while(tmp != null){
		  tmp = tmp.getProx();
		  i++;
	  }
	  return i;
  }
  
  public boolean isEmpty(){
	  if(inicio == null){
		  return true;
	  }else{
		  return false;
	  }
  }

} // fim classe Lista