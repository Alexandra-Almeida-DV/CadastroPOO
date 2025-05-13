/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> lista = new ArrayList<>();

    // Inserir
    public void inserir(PessoaJuridica pj) {
        lista.add(pj);
    }

    // Alterar
    public void alterar(PessoaJuridica pj) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == pj.getId()) {
                lista.set(i, pj);
                return;
            }
        }
    }

    // Excluir
    public void excluir(int id) {
        lista.removeIf(p -> p.getId() == id);
    }

    // Obter por ID
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pj : lista) {
            if (pj.getId() == id) {
                return pj;
            }
        }
        return null;
    }

    // Obter todos
    public ArrayList<PessoaJuridica> obterTodos() {
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
            lista = (ArrayList<PessoaJuridica>) in.readObject();
        }
    }
}
