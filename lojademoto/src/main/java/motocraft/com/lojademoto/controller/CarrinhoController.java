/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.controller;

import java.time.LocalDateTime;
import java.util.List;
import motocraft.com.lojademoto.entidade.Carrinho;

import motocraft.com.lojademoto.entidade.Produto;

import motocraft.com.lojademoto.repository.CategoriaRepository;
import motocraft.com.lojademoto.repository.ClienteRepository;

import motocraft.com.lojademoto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bruno
 */
@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
    
    
    @GetMapping
    public String product() {
        return "cart";
    }
    
}
