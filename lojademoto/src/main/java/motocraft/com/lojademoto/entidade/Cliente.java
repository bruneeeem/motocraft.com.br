/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.entidade;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author bruno.malmeida3
 */
@Entity
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 100, nullable = false)
    private String nome;
    
    private String endereco;
    
    private String bairro;
    
    private String cidade;
    
    private String estado;
    
    private String cep;
    
    private String sexo;
    
    private String telefone;
    
    private String celular;

     public Cliente() {
    
     }
     
    public Cliente(Long id, String nome, String endereco, String bairro, String cidade, String estado, String cep, String sexo, String telefone, String celular, Set<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.pedidos = pedidos;
    }
    
    
   
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;
        

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public Long getId(){return id;}
    
    public void setId(Long id){
        
        this.id = id;
    }
    
    public String getNome(){return nome;}
    
    public void setNome(String nome){
        
        this.nome = nome;
        
    }
    
    public String getEndereco(){return endereco;}
    
    public void setEndereco(String endereco){
        
        this.endereco = endereco;
        
    }
    
    public String getBairro(){return bairro;}
    
    public void setBairro(String bairro){
        
        this.bairro = bairro;
        
    }
    
    public String getCidade(){return cidade;}
    
    public void setCidade(String cidade){
        
    this.cidade = cidade;
    
    }    
    
    public String getEstado(){return estado;}
    
    public void setEstado(String estado){
        
        this.estado = estado;
        
    }
    
    public String getCep(){return cep;}
    
    public void setCep(String cep){
        
        this.cep = cep;
        
    }
    
    public String getSexo(){return sexo;}
    
    public void setSexo(String sexo){
    
        this.sexo = sexo;
        
    }
   
    public String getTelefone(){return telefone;}
    
    public void setTelefone(String telefone){
        
        this.telefone = telefone;
        
    }
    
    public String getCelular(){return celular;}
    
    public void setCelular(String celular){
    
        this.celular = celular;
    
    }
}
