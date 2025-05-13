/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author almei
 */
public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf); // chama o construtor da classe base
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }

    @Override
    public String toString() {
        return super.toString() + ", Email: " + email;
    }
}
