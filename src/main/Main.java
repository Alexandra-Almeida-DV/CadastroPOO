/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import model.*;

public class Main {
    public static void main(String[] args) {
        // Pessoa Física
        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();

        PessoaFisica pf1 = new PessoaFisica(1, "Ana", "1111111111", 25);
        PessoaFisica pf2 = new PessoaFisica(2, "Carlos", "2222222222", 52);

        repoPF.inserir(pf1);
        repoPF.inserir(pf2);

        try {
            repoPF.persistir("pessoas_fisicas.dat");
            System.out.println("Dados de Pessoa Fisica Armazenados.");

            repoPF = new PessoaFisicaRepo(); // nova instância para testar recuperação
            repoPF.recuperar("pessoas_fisicas.dat");
            System.out.println("Dados de Pessoa Fisica Recuperados.");

            for (PessoaFisica pf : repoPF.obterTodos()) {
                pf.exibir();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Pessoa Jurídica
        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();

        PessoaJuridica pj1 = new PessoaJuridica(3, "XPTO Sales", "3333333333333");
        PessoaJuridica pj2 = new PessoaJuridica(4, "XPTO Solutions", "4444444444444");

        repoPJ.inserir(pj1);
        repoPJ.inserir(pj2);

        try {
            repoPJ.persistir("pessoas_juridicas.dat");
            System.out.println("Dados de Pessoa Juridica Armazenados.");

            repoPJ = new PessoaJuridicaRepo(); // nova instância para testar recuperação
            repoPJ.recuperar("pessoas_juridicas.dat");
            System.out.println("Dados de Pessoa Juridica Recuperados.");

            for (PessoaJuridica pj : repoPJ.obterTodos()) {
                pj.exibir();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
