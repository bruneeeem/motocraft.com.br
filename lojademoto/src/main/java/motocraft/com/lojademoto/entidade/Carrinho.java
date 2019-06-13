/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name = "Carrinho.findAll", query = "SELECT c FROM Carrinho c"),
   
})

public class Carrinho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nomeProduto;

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal precoVendaCar;

    @OneToOne(fetch = FetchType.LAZY)// REMOVER O @Transient e USAR A ANOTAÇÃO DE ASSOCIAÇÃO COM A CLASSE Pessoa
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Carrinho(Produto produto, Long id, String nomeProduto, BigDecimal precoVendaCar) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoVendaCar = precoVendaCar;
        this.produto = produto;
    }
    
    public Carrinho(Long id, String nomeProduto, BigDecimal precoVendaCar) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoVendaCar = precoVendaCar;
        
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Carrinho() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPrecoVendaCar() {
        return precoVendaCar;
    }

    public void setPrecoVendaCar(BigDecimal precoVenda) {
        this.precoVendaCar = precoVenda;
    }

}
