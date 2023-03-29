package conta_bancaria.controller;

import java.util.ArrayList;

import Conta.Repository.ContaRepository;
import conta_bancaria.model.Conta;

public class Controller implements ContaRepository {
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else 
			System.out.println("A conta não foi encontrada!");
		
	}

	@Override
	public void listartodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void Cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta número: " + conta.getNumero() + " foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	/*Métodos Auxiliares*/
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
	}
	

}
