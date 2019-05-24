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
import motocraft.com.lojademoto.entidade.Cliente;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruno
 */
@Repository
public class ClienteRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
       
    public List<Cliente> findAll() {
        Query jpqlQuery = 
                entityManager.createQuery("SELECT c FROM Cliente c");
        return jpqlQuery.getResultList();
    }
       public Cliente findById(Integer id) {
        Query jpqlQuery = 
                entityManager.createQuery(
                        "SELECT c FROM Cliente c WHERE c.id = :idCliente")
                .setParameter("idCliente", id);
        Cliente c = (Cliente) jpqlQuery.getSingleResult();
        return c;
    }
    
    @Transactional
    public void save(Cliente c) {
            // Salva um novo produto
            entityManager.persist(c);
        }
}
