/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Luan Pereira
 */
public class Cliente {
    private int codigo;
    private String nome;
    private String sexo;
    private int cpf;
    private int idVeiculo;
    
    public Cliente(){
        
    }

    public Cliente(int codigo, String nome, String sexo, int cpf, int idVeiculo) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.idVeiculo = idVeiculo;
    }
    
    public Cliente( String nome, String sexo, int cpf, int idVeiculo) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.idVeiculo = idVeiculo;
    }

    
    
    public Cliente(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
       
    }
    
     public Cliente(String nome, String sexo, int cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
       
    }
    
    
    
    

    public int getCodigo() {
        return codigo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
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

   
    
    
}
