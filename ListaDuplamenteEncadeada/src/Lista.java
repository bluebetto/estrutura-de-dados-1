
public class Lista {
	
	protected No inicio = null;
	protected No fim = null;

	public Lista() {
		// TODO Auto-generated constructor stub
	}
	
	public No getInicio(){
		return inicio;
	}
	
	public No getFim(){
		return fim;
	}
	
	public void insereInicio(int valor){
		if(inicio == null){
			inicio = new No(valor);
			fim = inicio;
		}else{
			inicio.setAnterior(new No(valor));
			inicio.getAnterior().setProximo(inicio);
			inicio = inicio.getAnterior();
		}
	}
	
	public void insereFinal(int valor){
		No atual = inicio;
		No tmp;
		if(inicio == null){
			//Lista vazia
			insereInicio(valor);
			return;
		}else{
			while(atual.getProximo() != null){
				atual = atual.getProximo();
			}
			
			atual.setProximo(new No(valor));
			atual.getProximo().setAnterior(atual);
			
			fim = atual.getProximo();
		}
		
		
	}
	
	public int retiraInicio() throws Exception{
		No tmp;
		
		if(inicio == null) throw new Exception("Lista vazia");
		
		tmp = inicio;
		
		if(inicio.getProximo() == null){
			inicio = null;
		}else{
			inicio = tmp.getProximo();
			inicio.setAnterior(null);
			tmp.setProximo(null);
			tmp.setAnterior(null);
		}
		
		return tmp.getValor();
		
		
	}
	
	public int retiraFinal() throws Exception {
		No tmp;
		
		if(inicio == null) throw new Exception("Lista vazia");
		if(fim.getAnterior() == null){
			//Lista tem apenas 1 elemento
			return retiraInicio();
		}
		tmp = fim;
		
		fim = fim.getAnterior();
		fim.setProximo(null);
		
		tmp.setProximo(null);
		tmp.setAnterior(null);
		
		return tmp.getValor();
	}
	
	public String imprimir(){
		No atual = inicio;
		String saida = "";
		while(atual != null){
			//System.out.print(atual.getValor());
			saida += ""+atual.getValor();
			
			if(atual.getProximo() != null){
				//System.out.print(", ");
				saida += ", ";
			}
			atual = atual.getProximo();
		}
		
		return saida;
	}
	
	public void imprimirInverso(){
		No atual = fim;
		while(atual != null){
			System.out.print(atual.getValor());
			if(atual.getAnterior() != null) System.out.print(", ");
			atual = atual.getAnterior();
		}
	}
	
	public int tamanho(){
		No atual = inicio;
		int i = 0;
		while(atual != null){
			i++;
			atual = atual.getProximo();
		}
		return i;
	}
	
	public void ordernar(){
		No anterior, atual, proximo, fim;
	   	if(inicio == null){
	        System.out.println("Lista vazia");
	    }else if(inicio.getProximo() == null){
	        System.out.println("1 elemento");
	    }else{
	    	//A lista tem mais de 2 elementos
	        //Pré inicializando o loop
	        atual = inicio;
	        proximo  = inicio.getProximo();
	        fim = null;
	        //Enquanto o proximo não for igual ao final
	        //Sendo q no começo o final é null
	        while(atual.getProximo() != fim){
	        	
	            proximo = inicio.getProximo();
	            
	            if(atual.getValor() > proximo.getValor()){
	                atual.setProximo(proximo.getProximo());
	                proximo.getProximo().setAnterior(atual);
	                
	                proximo.setProximo(atual);
	                atual.setAnterior(proximo);
	                
	                inicio = proximo;
	                inicio.setAnterior(null);
	                proximo = atual.getProximo();
	                
	                //System.out.println("O inicio agora é: "+inicio.getValor());
	                
	            }else{
	                atual = atual.getProximo();
	                proximo = proximo.getProximo();
	            }
	
	            anterior = inicio;
	            //Enquanto o proximo não for o fim da lista
	            while(proximo != fim){
	                if(atual.getValor() > proximo.getValor()){
	                    //System.out.println(atual.getValor()+ " > "+proximo.getValor()+": trocado");
	                    atual.setProximo(proximo.getProximo());
	                    if(proximo.getProximo() != null){
	                    	proximo.getProximo().setAnterior(atual);
	                    }
	                    
	                    proximo.setProximo(atual);
	                    atual.setAnterior(proximo);
	                    
	                    anterior.setProximo(proximo);
	                    proximo.setAnterior(anterior);
	                    
	                    proximo = atual.getProximo();
	                    anterior = anterior.getProximo();
	                }else{
	                    //System.out.print(atual.getValor()+ " < "+proximo.getValor()+" - ");
	                    anterior = anterior.getProximo();
	                    atual = atual.getProximo();
	                    proximo = proximo.getProximo();
	                }
	            }
	            if(fim == null){
	            	this.fim = atual;
	            }
	            fim = atual;
	            atual = inicio;
	        }
	    }
	}
	
	public void ordernarInsertion(){
		No atual, pivo, inserirAntes, retirado,proximoPivo;
		if(inicio == null){
			System.out.println("Lista vazia");
			System.exit(0);
		}else if(inicio.getProximo() == null){
			System.out.println("Lista com 1 elemento. Ja ordenada");
		}else{
			pivo = inicio.getProximo();
			
			while(pivo != null){
				inserirAntes = pivo;
				proximoPivo = pivo.getProximo();
				while(inserirAntes.getAnterior() != null && inserirAntes.getAnterior().getValor() > pivo.getValor()) {
					//Encontrando o menor numero para colocar o pivo a direita
					if(inserirAntes.getAnterior() != null){
						inserirAntes = inserirAntes.getAnterior();
					}else{
						break;
					}
				}
				
				if(pivo.getValor() < inserirAntes.getValor()){
					inserirAntes(retirar(pivo),inserirAntes);
				}
				
				pivo = proximoPivo;
				//if(pivo != null) System.out.println(pivo.getValor()+" é o novo pivo");
			}
			
		}
						
			
	}
	
	protected void trocar(No praFrente, No praTras){
		
		praFrente.setProximo(praTras.getProximo());
		praTras.setAnterior(praFrente.getAnterior());
		if(praTras.getProximo() != null){
			praTras.getProximo().setAnterior(praFrente);
		}
		if(praFrente.getAnterior() != null){
			praFrente.getAnterior().setProximo(praTras);
		}
		
		praTras.setProximo(praFrente);
		praFrente.setAnterior(praTras);
		
		if(praTras.getAnterior() == null) inicio = praTras;
		if(praFrente.getProximo() == null) fim = praFrente;
		
	}
	
	protected No retirar(No alvo){
		//System.out.println(alvo.getValor()+" retirado");
		if(alvo.getAnterior() != null){
			alvo.getAnterior().setProximo(alvo.getProximo());
		}else{
			inicio = alvo.getProximo();
		}
		if(alvo.getProximo() != null){
			alvo.getProximo().setAnterior(alvo.getAnterior());
		}else{
			fim = alvo.getAnterior();
		}
		
		alvo.setAnterior(null);
		alvo.setProximo(null);
		return alvo;
		
	}
	protected void inserirAntes(No inserir, No alvo){
		
		if(alvo.getAnterior() != null){
			alvo.getAnterior().setProximo(inserir);
			inserir.setAnterior(alvo.getAnterior());
		}else{
			inicio = inserir;
		}
		//System.out.println(inserir.getValor()+" colocado antes de "+alvo.getValor());
		alvo.setAnterior(inserir);
		inserir.setProximo(alvo);
	}
	
}