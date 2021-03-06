public class Lista {
	
	protected No inicio = null;
	protected No fim = null;

	public Lista() {
		//Nothing to do here
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
	//Imprimir a lista
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
	/*
	 * Imprimir a lista inversamente a partir do ultimo no para testar as liga��es 
	 * usando as referencias de anteriores
	 * */
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
	        //Pr� inicializando o loop
	        atual = inicio;
	        proximo  = inicio.getProximo();
	        fim = null;
	        //Enquanto o proximo n�o for igual ao final
	        //Sendo q no come�o o final � null
	        while(atual.getProximo() != fim){
	            proximo = inicio.getProximo();
	            //Trocando os Nos de posicao quando � trocado o primeiro n�
	            if(atual.getValor() > proximo.getValor()){
	                atual.setProximo(proximo.getProximo());
	                proximo.getProximo().setAnterior(atual);
	                
	                proximo.setProximo(atual);
	                atual.setAnterior(proximo);
	                
	                inicio = proximo;
	                inicio.setAnterior(null);
	                
	                proximo = atual.getProximo();
	            }else{
	                atual = atual.getProximo();
	                proximo = proximo.getProximo();
	            }
	
	            anterior = inicio;
	            
	            //Proximos nos
	            //Enquanto o proximo n�o for o fim da lista
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
		No pivo, inserirAntes, proximoPivo;
		int i = 0;
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
				i=0;
				while(inserirAntes.getAnterior() != null && inserirAntes.getAnterior().getValor() > pivo.getValor()) {
					//Encontrando o menor numero para colocar o pivo a direita
					i++;
					inserirAntes = inserirAntes.getAnterior();
				}
				//colocando o no a esquerda do no encontrado
				// Quando i = 0, o nó vai manter a mesma posição
				if(i>0) inserirAntes(retirar(pivo),inserirAntes);
				
				pivo = proximoPivo;
			}
		}
	}
	
	public void ordernarSelection(){
		No ordenado = inicio;
		No atual;
		No menor;
		
		while(ordenado != null){
			atual = ordenado;
			menor = atual;
			do{
				if(menor.getValor() > atual.getValor()){
					menor = atual;
				}
				atual = atual.getProximo();
			
			}while(atual != null);
			
			if(ordenado.getValor() > menor.getValor()){
				trocar(ordenado,menor);
				ordenado = menor;
			}
			ordenado = ordenado.getProximo();
		}
		
	}
	
	
	public void ordernarShell(){
		int tamanho = tamanho();
		
		No pivo;
		No primeiro = inicio;
		
		for(int pedaco = tamanho/2; pedaco > 0; pedaco /=2){
			pivo = avancar(primeiro, pedaco);
			do{
				while(primeiro.getValor() > pivo.getValor()){
					trocar(pivo,primeiro);
				}
				primeiro = primeiro.getProximo();
				pivo = pivo.getProximo();
			}while(pivo != null);
			
		}
	}
	
	protected No retornar(No alvo, int i){
		int j = 0;
		while(j < i && alvo != null){
			alvo = alvo.getAnterior();
			j++;
		}
		return alvo;
	}
	
	protected No avancar(No alvo, int i){
		int j = 0;
		while(j < i && alvo != null){
			alvo = alvo.getProximo();
			j++;
		}
		
		return alvo;
	}
	
	protected No encontrar(int index){
		No atual = inicio;
		int i = 0;
		
		while(atual != null && i++ != index){
			atual = atual.getProximo();
		}
		return atual;
	}
	
	/*
	 * Retira o no da lista e atualiza as liga��es
	 * */
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
	
	/*
	 * Insere o no fornecido antes do No alvo
	 * */
	protected void inserirAntes(No inserir, No alvo){
		
		if(alvo.getAnterior() != null){
			alvo.getAnterior().setProximo(inserir);
			inserir.setAnterior(alvo.getAnterior());
		}else{
			inicio = inserir;
		}

		alvo.setAnterior(inserir);
		inserir.setProximo(alvo);
	}
	
	protected void inserirDepois(No inserir, No alvo){
		if(alvo.getProximo() != null){
			alvo.getProximo().setAnterior(inserir);
			inserir.setProximo(alvo.getProximo());
		}else{
			fim = inserir;
		}
		
		alvo.setProximo(inserir);
		inserir.setAnterior(alvo);
	}
	
	protected void trocar(No praFrente, No praTras){
		if(praFrente.getProximo() == praTras){
			No proximoDoPraTras = praTras.getProximo();
			No antesDoPraFrente = praFrente.getAnterior();
			
			inserirAntes(retirar(praFrente),proximoDoPraTras);
			inserirDepois(retirar(praTras),antesDoPraFrente);
		}else{
			No antesDoPraTras = praTras.getAnterior();
			No depoisDoPraFrente = praFrente.getProximo();
			
			inserirDepois(retirar(praFrente),antesDoPraTras);
			inserirAntes(retirar(praTras), depoisDoPraFrente);
		}
		
	    if(praTras.getAnterior() == null) inicio = praTras;
	    if(praFrente.getProximo() == null) fim = praFrente;
	    
	}
	
}
