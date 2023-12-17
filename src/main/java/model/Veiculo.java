/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Luan Pereira
 */
public class Veiculo {
    private int codigo;
    private String modelo;
    private String montadora;
    private String placa;
    private int idTipoVeiculo;
    
    
    public Veiculo(){
        
    }

    public Veiculo(int codigo, String modelo, String montadora, String placa, int idTipoVeiculo) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.montadora = montadora;
        this.placa = placa;
        this.idTipoVeiculo = idTipoVeiculo;
    }
    
    public Veiculo( String modelo, String montadora, String placa, int idTipoVeiculo) {       
        this.modelo = modelo;
        this.montadora = montadora;
        this.placa = placa;
        this.idTipoVeiculo = idTipoVeiculo;
    }

    public Veiculo(String modelo, String montadora, String placa) {
        this.modelo = modelo;
        this.montadora = montadora;
        this.placa = placa;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdTipoVeiculo() {
        return idTipoVeiculo;
    }

    public void setIdTipoVeiculo(int idTipoVeiculo) {
        this.idTipoVeiculo = idTipoVeiculo;
    }
    
    
}
