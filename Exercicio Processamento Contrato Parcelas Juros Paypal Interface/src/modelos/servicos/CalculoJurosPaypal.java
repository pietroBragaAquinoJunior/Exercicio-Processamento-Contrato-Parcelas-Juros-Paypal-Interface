package modelos.servicos;

public class CalculoJurosPaypal implements CalculoJurosServico {

	public double calcular(int nDaParcela, double valorDaParcela) {
		
		double valorParcial = valorDaParcela + valorDaParcela * 0.01 * nDaParcela;
		return valorParcial + valorParcial * 0.02;
		
	}
	
}
