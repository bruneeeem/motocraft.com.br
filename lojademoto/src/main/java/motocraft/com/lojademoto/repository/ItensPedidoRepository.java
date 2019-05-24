/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import motocraft.com.lojademoto.entidade.ItensPedido;
import motocraft.com.lojademoto.entidade.Venda;
import org.springframework.stereotype.Repository;


@Repository
public class ItensPedidoRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
      public List<ItensPedido> findAll() {
        Query jpqlQuery = 
                entityManager.createQuery("SELECT ip FROM ItensPedido ip");
        return jpqlQuery.getResultList();
    }
       public ItensPedido findById(Integer id) {
        Query jpqlQuery = 
                entityManager.createQuery(
                        "SELECT ip FROM ItensPedido ip WHERE ip.id = :idIp")
                .setParameter("idIp", id);
        ItensPedido ip = (ItensPedido) jpqlQuery.getSingleResult();
        return ip;
    }
    @Transactional
    public void save(ItensPedido ip) {
            // Salva um novo produto
            entityManager.persist(ip);
        }
    
}
