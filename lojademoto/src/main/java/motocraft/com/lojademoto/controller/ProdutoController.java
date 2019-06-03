/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import motocraft.com.lojademoto.entidade.Categoria;
import motocraft.com.lojademoto.entidade.Produto;
import motocraft.com.lojademoto.repository.CategoriaRepository;
import motocraft.com.lojademoto.repository.ClienteRepository;
import motocraft.com.lojademoto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private CategoriaRepository cat;

    @Autowired
    private ProdutoRepository prod;
    
    @GetMapping
    public ModelAndView detalheProduto() {
        return new ModelAndView("product-detail");

    }

    @GetMapping("/novo")
    public ModelAndView novoProduto() {
        return new ModelAndView("produto/novo").addObject("produto", new Produto());

    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute("produto") Produto produto,
            RedirectAttributes redirectAttributes) {

        prod.save(produto);
        redirectAttributes.addFlashAttribute("mensagemSucesso",
                "Produto " + produto.getNome() + " salvo com sucesso");
        return new ModelAndView("redirect:/produto/listar");
    }
    /* 
    Este listar, não é a lista de produtos disponiveis para a compra no e-ecommerce, é uma lista que apresenta um relatório de produtos cadastros(backOffice)
    localhost:8080/produto/listar === URL 
    */
    @GetMapping("/listar")
    public ModelAndView listar(
            @RequestParam(name = "offset", defaultValue = "2") int offset,
            @RequestParam(name = "qtd", defaultValue = "100") int qtd) {

        List<Produto> produtos;

        // Busca normal
        produtos = prod.findAll(offset, qtd);
        return new ModelAndView("produto/lista").addObject("produtos", produtos);
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(
            @PathVariable(name = "id") Long id) {
        Produto p = prod.findById(id);
        return new ModelAndView("produto/novo").addObject("produto", p);
    }

    @PostMapping("/{id}/remover")
    public ModelAndView remover(
            @PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes) {
        prod.delete(id);
        redirectAttributes.addFlashAttribute("mensagemSucesso",
                "Produto ID " + id + " removido com sucesso");
        return new ModelAndView("redirect:/produto/listar");
    }

    @ModelAttribute("categorias")
    public List<Categoria> getCategoria() {
        return cat.findAll();
    }
}
