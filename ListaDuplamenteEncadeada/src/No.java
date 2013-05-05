
public class No {
	
	protected int valor;
	protected No anterior;
	protected No proximo;

	/**
	 * @return the valor
	 */
	public final int getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public final void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * @return the anterior
	 */
	public final No getAnterior() {
		return anterior;
	}

	/**
	 * @param anterior the anterior to set
	 */
	public final void setAnterior(No anterior) {
		this.anterior = anterior;
	}

	/**
	 * @return the proximo
	 */
	public final No getProximo() {
		return proximo;
	}

	/**
	 * @param proximo the proximo to set
	 */
	public final void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public No() {}
	
	public No(int valor){
		setValor(valor);
	}
	
	public No(int valor, No proximo){
		setValor(valor);
		setProximo(proximo);
	}
	
	public No(int valor, No proximo, No anterior){
		setValor(valor);
		setProximo(proximo);
		setAnterior(anterior);
	}

}
