public class ListaApp {
  public static void main(String args[]) throws Exception {
    Lista lista = new Lista();

    for(int i=10; i>0; i--) {
      lista.inserirFinal(i);
    } // fim for i

    lista.imprimir();
    System.out.println("Tamanho: "+lista.tamanho());
    lista.ordernarInsertionSort();
   
    lista.imprimir();
    
    
	/*
	Pilha pilha = new Pilha();
	
	pilha.push(1);
	pilha.push(5);
	pilha.push(2);
	pilha.push(8);
	pilha.push(13);
	
	System.out.println("-- Pilha:");
	pilha.imprimir();
	
	int i = pilha.tamanho();
	
	System.out.println("-- Pops");
	while(!pilha.isEmpty()){
		System.out.println((i--)+": "+pilha.pop());
	}
	*/
  } // fim main 

} // fim classe