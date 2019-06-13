/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.controller;

import java.util.List;
import motocraft.com.lojademoto.entidade.Carrinho;
import motocraft.com.lojademoto.entidade.Categoria;
import motocraft.com.lojademoto.entidade.Produto;
import motocraft.com.lojademoto.repository.CategoriaRepository;
import motocraft.com.lojademoto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
/*
 Responsável por listar os produtos do e-ecommerce para adicionar ao carrinho - product.html
*/
@RequestMapping("/listagemProdutos")
public class ListagemProdutosController {
 
    @Autowired
     private ProdutoRepository prod;
    
    @Autowired
    private CategoriaRepository cat;
    
    @GetMapping
    public ModelAndView listar(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "qtd", defaultValue = "100") int qtd) {
        List<Produto> produtos;
        // Busca normal
        produtos = prod.findAll(offset, qtd);

        return new ModelAndView("product").addObject("produtos", produtos).addObject("carrinho",new Carrinho());
    }
    
    @ModelAttribute("categorias")
    public List<Categoria> getCategoria() {
        return cat.findAll();
    }
   @GetMapping("/{id}/detalhes")
    public ModelAndView editar(
        @PathVariable(name = "id") Long id) {
        Produto p = prod.findById(id);
        return new ModelAndView("product-detail").addObject("produto", p);
    }
  }