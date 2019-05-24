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
import motocraft.com.lojademoto.entidade.Pedido;
import motocraft.com.lojademoto.entidade.Venda;
import org.springframework.stereotype.Repository;



@Repository
public class PedidoRepository {
    @PersistenceContext
    private EntityManager entityManager;
    
      public List<Pedido> findAll() {
        Query jpqlQuery = 
                entityManager.createQuery("SELECT p FROM Pedido p");
        return jpqlQuery.getResultList();
    }
       public Pedido findById(Integer id) {
        Query jpqlQuery = 
                entityManager.createQuery(
                        "SELECT p FROM Pedido p WHERE p.id = :idP")
                .setParameter("idP", id);
        Pedido p = (Pedido) jpqlQuery.getSingleResult();
        return p;
    }
    
    
    @Transactional
    public void save(Pedido p) {
            // Salva um novo produto
            entityManager.persist(p);
        }
}
