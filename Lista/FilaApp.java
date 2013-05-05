
public class FilaApp {

	public FilaApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fila fila = new Fila();
		int j = 1;
		for(int i=10;i>0;i--){
			fila.push(i);
		}
		System.out.println("-- Fila");
		fila.imprimir();
		
		System.out.println("--- Pops");
		while(!fila.isEmpty()){
			try{
				System.out.println(j+" > "+fila.pop());
				j++;
			}catch(Exception e){
				System.out.println("Erro fatal: "+e.getMessage());
				System.exit(1);
			}
			
		}

	}

}
