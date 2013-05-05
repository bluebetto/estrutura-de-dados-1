
public class Pilha {
	private Lista p;
	
	public Pilha() {
		p = new Lista();
	}
	
	public void push(int v){
		p.inserirFinal(v);
	}
	
	public int pop() throws Exception{
		try{
			return p.retiraFinal();
		}catch(Exception e){
			throw new Exception("Erro: "+e.getMessage());
		}
	}
	
	public void imprimir(){
		p.imprimir();
	}
	
	public boolean isEmpty(){
		return p.isEmpty();
	}
	
	public int tamanho(){
		return p.tamanho();
	}

}
