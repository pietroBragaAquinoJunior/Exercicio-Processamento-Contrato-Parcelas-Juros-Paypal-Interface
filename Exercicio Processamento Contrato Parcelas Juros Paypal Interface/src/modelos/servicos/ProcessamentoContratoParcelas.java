package modelos.servicos;

import java.util.Calendar;
import java.util.Date;

import modelos.entidades.Contrato;
import modelos.entidades.Parcela;

public class ProcessamentoContratoParcelas {
	
	public void processar(Contrato contrato, int nParcelas, CalculoJurosServico calculoJurosServico) {
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(contrato.getDataInicio());
		
		for(int i=1;i<=nParcelas;i++) {
			double valorParcelaComJuros = calculoJurosServico.calcular(i, contrato.getValor()/nParcelas);
			calendario.add(Calendar.MONTH, 1);
			Date dataVencimentoParcela = calendario.getTime();
			Parcela parcela = new Parcela(dataVencimentoParcela, valorParcelaComJuros);
			contrato.adicionarParcela(parcela);
		}
	}
	
}
