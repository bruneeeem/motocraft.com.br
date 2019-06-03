/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motocraft.com.lojademoto.controller;

import java.io.Serializable;
import motocraft.com.lojademoto.entidade.Cliente;
import motocraft.com.lojademoto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bruno
 */
@Controller
@RequestMapping("/formularioCadastro")
public class ClienteController implements Serializable {

    
    @Autowired
    private ClienteRepository clienterepository;
    
    @GetMapping
    public ModelAndView formCliente() {
        return new ModelAndView("cadastroCliente").addObject("cliente",new Cliente());
    }
     @PostMapping("/salvar")
    public ModelAndView salvarCliente( Cliente c, RedirectAttributes redirectAttributes) {
        clienterepository.save(c);
        redirectAttributes.addFlashAttribute("mensagemSucesso", " Cliente " + c.getNome() + " salvo com sucesso");
        return new ModelAndView("redirect:/index");

        
    }
}
