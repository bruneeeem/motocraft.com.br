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
import motocraft.com.lojademoto.entidade.Carrinho;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruno
 */
@Repository
public class CarrinhoRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
     public List<Carrinho> findAll(Integer offset, Integer quantidade) {
        Query jpqlQuery
                = entityManager.createNamedQuery("Carrinho.findAll")
                        .setFirstResult(offset)
                        .setMaxResults(quantidade);
        return jpqlQuery.getResultList();
    }

    @Transactional
    public void save(Carrinho c) {
        if (c.getId() == null) {
            entityManager.persist(c);
        } else {
            entityManager.merge(c);
        }
    }
}
