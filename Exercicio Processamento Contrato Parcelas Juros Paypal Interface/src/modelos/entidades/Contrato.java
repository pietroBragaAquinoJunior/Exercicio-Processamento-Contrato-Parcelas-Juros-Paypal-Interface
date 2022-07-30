package modelos.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {

	private Integer numero;
	private Date dataInicio;
	private Double valor;
	private List<Parcela> parcelas = new ArrayList<>();
	
	public Contrato(Integer numero, Date dataInicio, Double valor) {
		this.numero = numero;
		this.dataInicio = dataInicio;
		this.valor = valor;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Double getValor() {
		return valor;
	}
	
	public List<Parcela> getParcelas() {
		return parcelas;
	}
	
	public void adicionarParcela(Parcela parcela){
		parcelas.add(parcela);
	}
	
}
