/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Luan Pereira
 */
public class TipoVeiculo {
    private int id_TipoVeiculo;
    private String nome;
    
    public TipoVeiculo(){
        
    }

    public TipoVeiculo(int id_TipoVeiculo, String nome) {
        this.id_TipoVeiculo = id_TipoVeiculo;
        this.nome = nome;
    }

    public int getId_TipoVeiculo() {
        return id_TipoVeiculo;
    }

    public void setId_TipoVeiculo(int id_TipoVeiculo) {
        this.id_TipoVeiculo = id_TipoVeiculo;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
