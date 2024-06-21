package main.org.iniflex.model;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Funcionario extends Pessoa {
	
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");
    
 
	private BigDecimal salario;
	private String funcao;

	private static List<Funcionario> funcionarios = new ArrayList<>();
	
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
		

	}
	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public static void incluirFuncionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		 Funcionario novoFuncionario = new Funcionario(nome, dataNascimento, salario, funcao);
	     funcionarios.add(novoFuncionario);
	}
	
	public static void mostarFuncionarios() {
		 for (Funcionario funcionario : funcionarios) {
	            System.out.println(funcionario);
	     }
		
		
	}
	
	
	public static void removerFuncionario(String nome) {
		Funcionario funcionarioParaRemover = null; 
		
		for(Funcionario funcionario : funcionarios) {
			if(funcionario.getNome() == nome) {
				funcionarioParaRemover = funcionario; 
				break;
	        }
		}
		
		if (funcionarioParaRemover != null) {
			funcionarios.remove(funcionarioParaRemover);
			System.out.println("*******Funcionario " + nome + " removido com sucesso!*******" );

		}
			
	}
	
	public static void aumentoSalario(double porcentagem) {
		 for (Funcionario funcionario : funcionarios) {
			 BigDecimal percentualAumento= funcionario.getSalario().multiply(new BigDecimal(porcentagem/100));
			 funcionario.setSalario(funcionario.getSalario().add(percentualAumento));
			 System.out.println("*******Salário "+funcionario.getNome()+" atualizados com sucesso!*******" );
		
		 }
	}
	
	public static void agruparPorFuncao() {
		Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
	                .collect(Collectors.groupingBy(Funcionario::getFuncao));
		 
	        funcionariosPorFuncao.forEach((funcao, listaFuncionarios) -> {
	            System.out.println("Função: " + funcao);
	            listaFuncionarios.forEach(funcionario -> {
	                System.out.println(" - " + funcionario.getNome());
	            });
	            System.out.println();
	        });

		 
	}
	
	public static void agruparPorDataNascimento() {
		funcionarios.stream()
				.filter(funcionario -> funcionario.getDataNascimento().getDayOfMonth() == 10 ||  funcionario.getDataNascimento().getDayOfMonth() == 12)
                .forEach(funcionario -> System.out.println("Funcionários que fazer aniversários dias 10 e 12: "+funcionario.getNome()));
		
	}
	
	public static void mostrarFuncionarioComMaiorIdade() {
        Optional<Funcionario> funcionarioMaisVelho = funcionarios.stream()
        	.max(Comparator.comparing(funcionario -> calcularIdade(funcionario.getDataNascimento())));
        
        System.out.println("O funcionario mais velho é: " +  funcionarioMaisVelho.get().getNome()+ " | Idade: " + calcularIdade( funcionarioMaisVelho.get().getDataNascimento()));

   			
		
	}
	
    public static int calcularIdade(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        return Period.between(dataNascimento, hoje).getYears();
    }
	
    public static void mostrarFuncionarioOrderAlfabetica() {
    	 funcionarios.sort((f1, f2) -> f1.getNome().compareTo(f2.getNome()));

         System.out.println("Funcionários ordenados por nome:");
         funcionarios.forEach(funcionario -> System.out.println(funcionario.getNome()));
    }
    
    public static void somaTotalSalarios() {
    	 BigDecimal totalSalarios = funcionarios.stream()
                 .map(Funcionario::getSalario)
                 .reduce(BigDecimal.ZERO, BigDecimal::add);

         System.out.println("Total dos salários dos funcionários: " + "R$" + decFormat.format(totalSalarios));
   }
	
    public static void qntSalarioMinimoFuncionario() {
    	 BigDecimal salarioMinimo = new BigDecimal("1212.00");
    	 System.out.println("Salários mínimos ganhos por cada funcionário:");
         funcionarios.forEach(funcionario -> {
             BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.DOWN);
             System.out.println(funcionario.getNome() + ": " + salariosMinimos + " salários mínimos");
         });
    }
    
	   
	
	@Override
	public String toString() {
		return "Funcionario: "+ this.getNome() + " | Data de nascimento: " + this.getDataNascimento().format(formatter) + " | Salário: " + decFormat.format(salario) + " | Função: " + funcao;
	}


}
