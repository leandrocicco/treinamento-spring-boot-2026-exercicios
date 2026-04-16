package br.uff.exercicio4.controller;

import br.uff.exercicio4.modelo.Post;
import br.uff.exercicio4.modelo.PostComUsuario;
import br.uff.exercicio4.modelo.Usuario;
import br.uff.exercicio4.repository.UsuarioRepository;
import br.uff.exercicio4.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import org.springframework.data.web.PageableDefault;

/**
 *
 * @author leandroribeirodecicco
 */

@Slf4j
@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping
    public String get(){
        log.info("Entrando no index da aplicacao");
        return "root/index";
    }
}