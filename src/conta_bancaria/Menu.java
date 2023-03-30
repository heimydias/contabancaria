package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.Controller;
import conta_bancaria.model.Conta;
import conta_bancaria.model.Conta_Corrente;
import conta_bancaria.model.Conta_Poupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		int numero;
		int agencia;
		int tipo;
		int aniversario;
		int numeroDestino;
		String titular;
		float saldo;
		float limite;
		float valor;
		
		Controller contas = new Controller();
		
		Conta_Corrente cc1 = new Conta_Corrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
        contas.Cadastrar(cc1);

        Conta_Corrente cc2 = new Conta_Corrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
        contas.Cadastrar(cc2);

        Conta_Poupanca cp1 = new Conta_Poupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
        contas.Cadastrar(cp1);

        Conta_Poupanca cp2 = new Conta_Poupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
        contas.atualizar(cp2);
		
		while (true) {
			
			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_WHITE_BACKGROUND + "****************************************************");
			System.out.println("                                                    ");
			System.out.println("                  DevGirls Bank                     ");
			System.out.println("                                                    ");
			System.out.println("****************************************************");
			System.out.println("                                                    ");
			System.out.println("             1 - Criar Conta                        ");
			System.out.println("             2 - Listar todas as Contas             ");
			System.out.println("             3 - Buscar Conta por Numero            ");
			System.out.println("             4 - Atualizar Dados da Conta           ");
			System.out.println("             5 - Apagar Conta                       ");
			System.out.println("             6 - Sacar                              ");
			System.out.println("             7 - Depositar                          ");
			System.out.println("             8 - Transferir valores entre Contas    ");
			System.out.println("             9 - Sair                               ");
			System.out.println("                                                    ");
			System.out.println("****************************************************");
			System.out.println("Entre com a opção desejada:                         ");
			System.out.println("                                                    " + Cores.TEXT_RESET);
			
			try {
			opcao = leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			if (opcao == 9) {
				System.out.println("\nDevGirls Bank - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
				case 1 -> {
					System.out.println("Criar Conta\n\n");
					
					System.out.println("Digite o Numero da Agência: ");
	                agencia = leia.nextInt();
	                System.out.println("Digite o Nome do Titular: ");
	                leia.skip("\\R?");
	                titular = leia.nextLine();

	                do {
	                    System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
	                    tipo = leia.nextInt();
	                } while (tipo < 1 && tipo > 2);

	                System.out.println("Digite o Saldo da Conta (R$): ");
	                saldo = leia.nextFloat();

	                switch (tipo) {
	                case 1 -> {
	                    System.out.println("Digite o Limite de Crédito (R$): ");
	                    limite = leia.nextFloat();
	                    
	                    contas.Cadastrar(new Conta_Corrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
	                }
	                case 2 -> {
	                    System.out.println("Digite o dia do Aniversario da Conta: ");
	                    aniversario = leia.nextInt();
	                    
	                    contas.Cadastrar(new Conta_Poupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
	                }
	                }
	                keyPress();
				}
				case 2 -> {
					System.out.println("Listar todas as Contas\n\n");
					contas.listartodas();
					keyPress();
				}
				case 3 -> {
					System.out.println("Buscar Conta por Numero\n\n");
					System.out.println("Digite o número da conta: ");
	                numero = leia.nextInt();
	                contas.procurarPorNumero(numero);
	                keyPress();
				}
				case 4 -> {
					System.out.println("Atualizar Dados da Conta\n\n");
					System.out.println("Digite o número da conta: ");
	                numero = leia.nextInt();

	                if (contas.buscarNaCollection(numero) != null) {
	                	tipo = contas.retornaTipo(numero);
	                	
		                System.out.println("Digite o Numero da Agência: ");
		                agencia = leia.nextInt();
		                System.out.println("Digite o Nome do Titular: ");
		                leia.skip("\\R?");
		                titular = leia.nextLine();

		                System.out.println("Digite o Saldo da Conta (R$): ");
		                saldo = leia.nextFloat();

	                switch (tipo) {
	                case 1 -> {
	                    System.out.println("Digite o Limite de Crédito (R$): ");
	                    limite = leia.nextFloat();
	                    
	                    contas.atualizar(new Conta_Corrente(numero, agencia, tipo, titular, saldo, limite));
	                }
	                case 2 -> {
	                    System.out.println("Digite o dia do Aniversario da Conta: ");
	                    aniversario = leia.nextInt();
	                    
	                    contas.atualizar(new Conta_Poupanca(numero, agencia, tipo, titular, saldo, aniversario));

	                }
	                default -> {
	                    System.out.println("Tipo de conta inválido!");
	                }
	           }
	               }else {
	            	   System.out.println("A conta foi encontrada!");
	               }
	                keyPress();
				}
				case 5 -> {
					System.out.println("Apagar Conta\n\n");
					System.out.println("Digite o número da conta: ");
	                numero = leia.nextInt();
	                
	                contas.deletar(numero);
	                
	                keyPress();
				}
				case 6 -> {
					System.out.println("Sacar\n\n");
					System.out.println("Digite o número da conta: ");
	                numero = leia.nextInt();
	                
	                System.out.println("Digite o valor do Saque: ");
	                valor = leia.nextFloat();
	                
	                contas.sacar(numero, valor);
	                
	                keyPress();
				}
				case 7 -> {
					System.out.println("Depósito\n\n");
					System.out.println("Digite o número da conta: ");
	                numero = leia.nextInt();
	                
	                System.out.println("Digite o valor do Depósito: ");
	                valor = leia.nextFloat();
	                
	                contas.depositar(numero, valor);
	                
	                keyPress();
				}
				case 8 -> {
					System.out.println("Transferir valores entre Contas\n\n");
					System.out.println("Digite o Numero da Conta de Origem: ");
	                numero = leia.nextInt();
	                System.out.println("Digite o Numero da Conta de Destino: ");
	                numeroDestino = leia.nextInt();

	                do {
	                    System.out.println("Digite o Valor da Transferência (R$): ");
	                    valor = leia.nextFloat();
	                } while (valor <= 0);
	                
	                contas.transferir(numero, numeroDestino, valor);
	                
	                keyPress();
				}
				default -> System.out.println("\nOpção Inválida!\n"); 
				
			}
			keyPress();
		}
	}
	
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Heimy Dias - heimysantana@hotmail.com");
		System.out.println("github.com/heimydias");
		System.out.println("*********************************************************");
	}
	
	public static void keyPress() {
		
		try {
			System.out.println(Cores.TEXT_RESET + "Pressione a tecla enter para continuar...");
			System.in.read();
		}catch(IOException e) {
			System.out.println("Erro de digitação!");
		}
	}
}
