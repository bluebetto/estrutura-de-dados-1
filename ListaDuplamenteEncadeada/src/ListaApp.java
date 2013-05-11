
public class ListaApp {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lista lista = new Lista();
		System.out.println("Lista duplamente encadeada");
		/*
		lista.insereFinal(5);
		lista.insereFinal(4);
		lista.insereFinal(3);
		lista.insereFinal(7);
		lista.insereFinal(10);
		lista.insereFinal(2);
		lista.insereFinal(1);
		lista.insereFinal(6);
		lista.insereFinal(9);
		lista.insereFinal(8);
		*/
		
		for(int i=10;i>0;i--) lista.insereFinal(i);

		System.out.println(lista.imprimir());
		lista.ordernarSelection();
		System.out.println("\n Ordenada");
		System.out.println(lista.imprimir());
		System.out.println("\n--- Invertida");
		lista.imprimirInverso();

	}

}
