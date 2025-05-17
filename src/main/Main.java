/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();

        int opcao;

        do {
            System.out.println("\nrun:");
            System.out.println("=================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("=================================");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = scanner.nextLine();
                    System.out.println("Digite o id da pessoa:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Insira os dados...");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    if (tipo.equalsIgnoreCase("F")) {
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        repoPF.inserir(new PessoaFisica(id, nome, cpf));
                    } else if (tipo.equalsIgnoreCase("J")) {
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();
                        repoPJ.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;
                }

                case 2: {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite o id da pessoa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo.equalsIgnoreCase("F")) {
                        PessoaFisica pf = repoPF.obter(id);
                        if (pf != null) {
                            System.out.println("Dados atuais:");
                            pf.exibir();
                            System.out.println("Insira os novos dados...");
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("CPF: ");
                            String cpf = scanner.nextLine();
                            repoPF.alterar(new PessoaFisica(id, nome, cpf));
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipo.equalsIgnoreCase("J")) {
                        PessoaJuridica pj = repoPJ.obter(id);
                        if (pj != null) {
                            System.out.println("Dados atuais:");
                            pj.exibir();
                            System.out.println("Insira os novos dados...");
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("CNPJ: ");
                            String cnpj = scanner.nextLine();
                            repoPJ.alterar(new PessoaJuridica(id, nome, cnpj));
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite o id da pessoa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo.equalsIgnoreCase("F")) repoPF.excluir(id);
                    else if (tipo.equalsIgnoreCase("J")) repoPJ.excluir(id);
                    break;
                }

                case 4: {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite o id da pessoa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo.equalsIgnoreCase("F")) {
                        PessoaFisica pf = repoPF.obter(id);
                        if (pf != null) pf.exibir();
                        else System.out.println("Pessoa Física não encontrada.");
                    } else if (tipo.equalsIgnoreCase("J")) {
                        PessoaJuridica pj = repoPJ.obter(id);
                        if (pj != null) pj.exibir();
                        else System.out.println("Pessoa Jurídica não encontrada.");
                    }
                    break;
                }

                case 5: {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = scanner.nextLine();

                    if (tipo.equalsIgnoreCase("F")) {
                        for (PessoaFisica pf : repoPF.obterTodos()) pf.exibir();
                    } else if (tipo.equalsIgnoreCase("J")) {
                        for (PessoaJuridica pj : repoPJ.obterTodos()) pj.exibir();
                    }
                    break;
                }

                case 6: {
                    System.out.print("Digite o prefixo dos arquivos: ");
                    String prefixo = scanner.nextLine();
                    try {
                        repoPF.persistir(prefixo + ".fisica.bin");
                        repoPJ.persistir(prefixo + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar: " + e.getMessage());
                    }
                    break;
                }

                case 7: {
                    System.out.print("Digite o prefixo dos arquivos: ");
                    String prefixo = scanner.nextLine();
                    try {
                        repoPF.recuperar(prefixo + ".fisica.bin");
                        repoPJ.recuperar(prefixo + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar: " + e.getMessage());
                    }
                    break;
                }

                case 0:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
