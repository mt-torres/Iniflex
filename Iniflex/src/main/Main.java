package main;

import java.math.BigDecimal;
import java.time.LocalDate;

import main.org.iniflex.model.Funcionario;

public class Main {

	public static void main(String[] args) {
		Funcionario.incluirFuncionario("Maria", LocalDate.of(2000, 10,18), new BigDecimal(2009.44),"Operador");
		Funcionario.incluirFuncionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38),"Operador");
		Funcionario.incluirFuncionario("Caio", LocalDate.of(1961, 5, 02), new BigDecimal(9836.14),"Coordenador");
		Funcionario.incluirFuncionario("Miguel", LocalDate.of(1988, 10,14), new BigDecimal(19119.88),"Diretor");
		Funcionario.incluirFuncionario("Alice", LocalDate.of(1995, 1, 05), new BigDecimal(2234.68),"Recepcionista");
		Funcionario.incluirFuncionario("Heitor", LocalDate.of(1999, 11,19), new BigDecimal(1582.72),"Operador");
		Funcionario.incluirFuncionario("Arthur", LocalDate.of(1993, 3,31), new BigDecimal(4071.84),"Contador");
		Funcionario.incluirFuncionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45),"Gerente");
		Funcionario.incluirFuncionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85),"Eletricista");
		Funcionario.incluirFuncionario("Helena", LocalDate.of(1996, 9,2), new BigDecimal(2799.93),"Gerente");
		
		
		Funcionario.removerFuncionario("João");
				
		Funcionario.mostarFuncionarios();

		Funcionario.aumentoSalario(10);

		Funcionario.agruparPorFuncao();
		
		Funcionario.agruparPorDataNascimento();
		
		Funcionario.mostrarFuncionarioComMaiorIdade();
		
		Funcionario.mostrarFuncionarioOrderAlfabetica();
		
		Funcionario.somaTotalSalarios();
		
		Funcionario.qntSalarioMinimoFuncionario();
	}

}
