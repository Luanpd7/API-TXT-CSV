/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Luan Pereira
 */
public class Servico {
   private int codigo_servico;
private int numero_apolice;
private int idCliente;
private int idFuncionario;
private int idTipoSeguro;

private String nomeCliente;
private String nomeFuncionario;
private String nomeTipoSeguro;
private String modelo;
private String descricao;


    public Servico() {
    }

    public Servico(int numero_apolice, int idCliente,int idFuncionario, int idTipoSeguro) {
        this.numero_apolice = numero_apolice;
        this.idCliente= idCliente;
        this.idFuncionario = idFuncionario;
        this.idTipoSeguro = idTipoSeguro;
    }

    public Servico(int codigo_servico, int numero_apolice, int idCliente, int idFuncionario, int idTipoSeguro) {
        this.codigo_servico = codigo_servico;
        this.numero_apolice = numero_apolice;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.idTipoSeguro = idTipoSeguro;
    }

    public int getCodigo_servico() {
        return codigo_servico;
    }

    public void setCodigo_servico(int codigo_servico) {
        this.codigo_servico = codigo_servico;
    }

    public int getNumero_apolice() {
        return numero_apolice;
    }

    public void setNumero_apolice(int numero_apolice) {
        this.numero_apolice = numero_apolice;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdTipoSeguro() {
        return idTipoSeguro;
    }

    public void setIdTipoSeguro(int idTipoSeguro) {
        this.idTipoSeguro = idTipoSeguro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeTipoSeguro() {
        return nomeTipoSeguro;
    }

    public void setNomeTipoSeguro(String nomeTipoSeguro) {
        this.nomeTipoSeguro = nomeTipoSeguro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


   

}
