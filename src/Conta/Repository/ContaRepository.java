package Conta.Repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {
	
	// CRUD de  conta
    public void procurarPorNumero (int numero);
    public void listartodas();
    public void Cadastrar (Conta conta);
    public void atualizar (Conta conta);
    public void deletar (int numero);
    
    // Métodos bancários
    public void sacar (int  numero, float valor);
    public void depositar (int  numero, float valor);
    public void transferir(int  numeroOrigem,int numeroDestino, float valor);

}
