/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.controller;

import java.util.List;
import motocraft.com.lojademoto.entidade.Produto;
import motocraft.com.lojademoto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {
    
    @GetMapping("/produto")
    public String product() {
        return "product";
    }
    
 
    
}
