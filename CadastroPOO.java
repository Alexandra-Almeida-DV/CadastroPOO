/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.io.IOException;
import java.util.Scanner;

public class CadastroPOO {
    private static final PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
    private static final PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Digite a opção desejada: ");
            processarOpcao(opcao);
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=================================");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo Id");
        System.out.println("5 - Exibir Todos");
        System.out.println("6 - Persistir Dados");
        System.out.println("7 - Recuperar Dados");
        System.out.println("0 - Finalizar Programa");
        System.out.println("=================================");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> incluirPessoa();
            case 2 -> alterarPessoa();
            case 3 -> excluirPessoa();
            case 4 -> buscarPorId();
            case 5 -> exibirTodos();
            case 6 -> persistirDados();
            case 7 -> recuperarDados();
            case 0 -> System.out.println("Programa finalizado.");
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void incluirPessoa() {
        System.out.println("\nF - Pessoa Física | J - Pessoa Jurídica");
        String tipo = lerString("Digite o tipo: ").toUpperCase();
        
        if (tipo.equals("F")) {
            int id = lerInteiro("Digite o id da pessoa: ");
            String nome = lerString("Nome: ");
            String cpf = lerString("CPF: ");
            int idade = lerInteiro("Idade: ");
            
            PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
            repoFisica.inserir(pf);
            System.out.println("Pessoa física incluída com sucesso!");
        } 
        else if (tipo.equals("J")) {
            int id = lerInteiro("Digite o id da pessoa: ");
            String nome = lerString("Nome: ");
            String cnpj = lerString("CNPJ: ");
            
            PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
            repoJuridica.inserir(pj);
            System.out.println("Pessoa jurídica incluída com sucesso!");
        } 
        else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void alterarPessoa() {
        System.out.println("\nF - Pessoa Física | J - Pessoa Jurídica");
        String tipo = lerString("Digite o tipo: ").toUpperCase();
        int id = lerInteiro("Digite o id da pessoa: ");

        if (tipo.equals("F")) {
            PessoaFisica pf = repoFisica.obter(id);
            if (pf != null) {
                System.out.println("\nDados atuais:");
                pf.exibir();
                
                System.out.println("\nNovos dados:");
                String nome = lerString("Nome: ");
                String cpf = lerString("CPF: ");
                int idade = lerInteiro("Idade: ");
                
                pf.setNome(nome);
                pf.setCpf(cpf);
                pf.setIdade(idade);
                repoFisica.alterar(pf);
                System.out.println("Pessoa física alterada com sucesso!");
            } else {
                System.out.println("Pessoa física não encontrada!");
            }
        } 
        else if (tipo.equals("J")) {
            PessoaJuridica pj = repoJuridica.obter(id);
            if (pj != null) {
                System.out.println("\nDados atuais:");
                pj.exibir();
                
                System.out.println("\nNovos dados:");
                String nome = lerString("Nome: ");
                String cnpj = lerString("CNPJ: ");
                
                pj.setNome(nome);
                pj.setCnpj(cnpj);
                repoJuridica.alterar(pj);
                System.out.println("Pessoa jurídica alterada com sucesso!");
            } else {
                System.out.println("Pessoa jurídica não encontrada!");
            }
        } 
        else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void excluirPessoa() {
        System.out.println("\nF - Pessoa Física | J - Pessoa Jurídica");
        String tipo = lerString("Digite o tipo: ").toUpperCase();
        int id = lerInteiro("Digite o id da pessoa: ");

        if (tipo.equals("F")) {
            if (repoFisica.excluir(id)) {
                System.out.println("Pessoa física excluída com sucesso!");
            } else {
                System.out.println("Pessoa física não encontrada!");
            }
        } 
        else if (tipo.equals("J")) {
            if (repoJuridica.excluir(id)) {
                System.out.println("Pessoa jurídica excluída com sucesso!");
            } else {
                System.out.println("Pessoa jurídica não encontrada!");
            }
        } 
        else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void buscarPorId() {
        System.out.println("\nF - Pessoa Física | J - Pessoa Jurídica");
        String tipo = lerString("Digite o tipo: ").toUpperCase();
        int id = lerInteiro("Digite o id da pessoa: ");

        if (tipo.equals("F")) {
            PessoaFisica pf = repoFisica.obter(id);
            if (pf != null) {
                pf.exibir();
            } else {
                System.out.println("Pessoa física não encontrada!");
            }
        } 
        else if (tipo.equals("J")) {
            PessoaJuridica pj = repoJuridica.obter(id);
            if (pj != null) {
                pj.exibir();
            } else {
                System.out.println("Pessoa jurídica não encontrada!");
            }
        } 
        else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void exibirTodos() {
        System.out.println("\nF - Pessoa Física | J - Pessoa Jurídica");
        String tipo = lerString("Digite o tipo: ").toUpperCase();

        if (tipo.equals("F")) {
            System.out.println("\nPessoas Físicas Cadastradas:");
            for (PessoaFisica pf : repoFisica.obterTodos()) {
                pf.exibir();
                System.out.println("---------------------");
            }
        } 
        else if (tipo.equals("J")) {
            System.out.println("\nPessoas Jurídicas Cadastradas:");
            for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                pj.exibir();
                System.out.println("---------------------");
            }
        } 
        else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void persistirDados() {
        String prefixo = lerString("Digite o prefixo para os arquivos: ");
        
        try {
            repoFisica.persistir(prefixo + ".fisica.bin");
            repoJuridica.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados persistidos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao persistir dados: " + e.getMessage());
        }
    }

    private static void recuperarDados() {
        String prefixo = lerString("Digite o prefixo dos arquivos: ");
        
        try {
            repoFisica.recuperar(prefixo + ".fisica.bin");
            repoJuridica.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Valor inválido! Digite um número inteiro.");
            scanner.next();
            System.out.print(mensagem);
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        return valor;
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}