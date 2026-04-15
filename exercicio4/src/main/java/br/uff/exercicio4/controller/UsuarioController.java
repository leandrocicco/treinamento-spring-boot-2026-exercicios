package br.uff.exercicio4.controller;


import br.uff.exercicio4.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.data.web.PageableDefault;

@Slf4j
@Controller
@RequestMapping("usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


    @GetMapping("{id}")
    public ModelAndView get(@PathVariable Long id){
        val mv = new ModelAndView("usuario/get");

        mv.addObject("usuario", usuarioService.findObjById(id));

        return mv;
    }

    @GetMapping
    public ModelAndView list(@PageableDefault Pageable pageable){
        val mv = new ModelAndView("usuario/list");
        mv.addObject("usuarios", usuarioService.findAll(pageable));
        return mv;
    }


}
