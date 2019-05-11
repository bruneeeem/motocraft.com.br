/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Bruno
 */
@Controller
public class DetalhePedidoContoller {
    
       @GetMapping("/detalhedoproduto")
    public String index() {
        return "product-detail";
    }
    
    
}
