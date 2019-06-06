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
import motocraft.com.lojademoto.entidade.Categoria;
import org.springframework.stereotype.Repository;


@Repository
public class CategoriaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<Categoria> findAll() {
        Query jpqlQuery
                = entityManager.createQuery("SELECT c FROM Categoria c ");
        return jpqlQuery.getResultList();
    }
  
    public Categoria findById(int id) {
        Query jpqlQuery
                = entityManager.createQuery(
                        "SELECT c FROM Categoria c WHERE p.id = :idC")
                        .setParameter("idC", id);
        Categoria c = (Categoria) jpqlQuery.getSingleResult();
        return c;
    }

    @Transactional
    public void save(Categoria c) {
        if (c.getId() == null) {

            entityManager.persist(c);
        } else {

            entityManager.merge(c);
        }
    }
    
}
