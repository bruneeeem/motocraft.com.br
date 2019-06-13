/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.controller;

import motocraft.com.lojademoto.entidade.Produto;
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
@RequestMapping("/addcart")
public class AddCartController {      
    @Autowired
    private ProdutoRepository prod;
       
    @PostMapping("/addCarrinho")
    public ModelAndView addCart(@RequestParam(name = "id") Long id)
    {
        Produto p = prod.findById(id); 
        return new ModelAndView("/carrinho").addObject("produto",p);
    }
    
}
