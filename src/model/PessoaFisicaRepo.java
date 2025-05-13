/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> lista = new ArrayList<>();

    // Inserir
    public void inserir(PessoaFisica pf) {
        lista.add(pf);
    }

    // Alterar
    public void alterar(PessoaFisica pf) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == pf.getId()) {
                lista.set(i, pf);
                return;
            }
        }
    }

    // Excluir
    public void excluir(int id) {
        lista.removeIf(p -> p.getId() == id);
    }

    // Obter por ID
    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : lista) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }

    // Obter todos
    public ArrayList<PessoaFisica> obterTodos() {
        return lista;
    }

    // Persistir
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(lista);
        }
    }

    // Recuperar
    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            lista = (ArrayList<PessoaFisica>) in.readObject();
        }
    }
}
