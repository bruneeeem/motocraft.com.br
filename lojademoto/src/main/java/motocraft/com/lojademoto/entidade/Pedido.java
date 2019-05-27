/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author bruno.malmeida3
 */
@Entity
public class Pedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    private LocalDateTime dataPedido;
    
    
    public Pedido(){
        
        
    }
    
     public Pedido(Long id, LocalDateTime dataPedido, Cliente cliente, List<ItensPedido> itensPedido) {
        this.id = id;
        this.dataPedido = dataPedido;
       
        this.cliente = cliente;
        this.itensPedido = itensPedido;
    }
     
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
    public List<ItensPedido> itensPedido;
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItensPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItensPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
   
}
