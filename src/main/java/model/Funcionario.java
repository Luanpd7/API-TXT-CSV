/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Luan Pereira
 */
public class Funcionario {
    private int codigo;
    private String nome;
    private String sexo;
    private int cpf;
    
    public Funcionario (){
        
    }

    public Funcionario(int codigo, String nome, String sexo, int cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
    }
    
    public Funcionario(String nome, String sexo, int cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
    
}
