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
import motocraft.com.lojademoto.entidade.Produto;
import motocraft.com.lojademoto.entidade.Venda;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rbezerra
 */
@Repository
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Produto> findAll(Integer offset, Integer quantidade) {
        Query jpqlQuery
                = entityManager.createNamedQuery("Produto.findAll")
                        .setFirstResult(offset)
                        .setMaxResults(quantidade);
        return jpqlQuery.getResultList();
    }
    
    @Transactional
    public void save(Venda v) {
            // Salva um novo produto
            entityManager.persist(v);
        }
    

}

