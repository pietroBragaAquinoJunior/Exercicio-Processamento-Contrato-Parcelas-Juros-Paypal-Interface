package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelos.entidades.Contrato;
import modelos.entidades.Parcela;
import modelos.servicos.CalculoJurosPaypal;
import modelos.servicos.ProcessamentoContratoParcelas;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		/* Exercício em java para treinamento de Interface, entidades, serviços e outros conceitos */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do contrato: ");
		int numeroContrato = sc.nextInt();
		System.out.print("Data de início do contrato (dd/MM/yyyy): ");
		Date dataInicioContrato = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		double valorDoContrato = sc.nextDouble();
		System.out.print("Número de parcelas: ");
		int nParcelas = sc.nextInt();
		
		Contrato contrato = new Contrato(numeroContrato, dataInicioContrato, valorDoContrato);
		ProcessamentoContratoParcelas processamentoContratoParcelas = new ProcessamentoContratoParcelas();
		
		CalculoJurosPaypal calculoJurosPaypal = new CalculoJurosPaypal();
		
		processamentoContratoParcelas.processar(contrato, nParcelas, calculoJurosPaypal);
		
		System.out.println("Parcelas: ");
		for(Parcela p: contrato.getParcelas()) {
			System.out.print(sdf.format(p.getDataVencimento()) + " - ");
			System.out.println(p.getValor());
		}
		
		sc.close();

	}

}
