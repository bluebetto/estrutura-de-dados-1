
public class Fila {
	protected Lista lista;
	public Fila() {
		lista = new Lista();
	}
	
	public void push(int v){
		lista.inserirFinal(v);
	}
	
	public int pop() throws Exception{
		try{
			return lista.retiraInicio();
		}catch(Exception e){
			throw new Exception("Erro: "+e.getMessage());
		}
	}
	
	public void imprimir(){
		lista.imprimir();
	}
	
	public boolean isEmpty(){
		return lista.isEmpty();
	}

}
