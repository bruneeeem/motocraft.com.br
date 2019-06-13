/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.controller;

import java.math.BigDecimal;
import java.util.List;
import motocraft.com.lojademoto.entidade.Carrinho;
import motocraft.com.lojademoto.entidade.Produto;
import motocraft.com.lojademoto.repository.CarrinhoRepository;
import motocraft.com.lojademoto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel
 */
@Controller
@RequestMapping("/carrinho")
public class AddCartController {

    @Autowired
    private ProdutoRepository prod;

    @Autowired
    private CarrinhoRepository carrinho;

    @PostMapping("/adicionar")
    public ModelAndView addCart(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "nome") String nome,
            @RequestParam(name = "precoVenda") BigDecimal venda,
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "qtd", defaultValue = "100") int qtd) {

        Produto p = prod.findById(id);
        
        Carrinho car = new Carrinho();
        car.setNomeProduto(nome);
        car.setPrecoVendaCar(venda);
        car.setProduto(p);

        List<Produto> produto;
        // Busca normal
        produto = prod.findAll(offset, qtd);

        carrinho.save(car);
        return new ModelAndView("product").addObject("produtos", produto);
    }

}
