package br.uff.exercicio4.controller;


import br.uff.exercicio4.modelo.Post;
import br.uff.exercicio4.modelo.PostComUsuario;
import br.uff.exercicio4.modelo.Usuario;
import br.uff.exercicio4.service.PostService;
import br.uff.exercicio4.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import java.util.List;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("post")
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final UsuarioService usuarioService;


    @GetMapping("{id}")
    public ModelAndView get(@PathVariable Long id){
        val mv = new ModelAndView("post/get");

        mv.addObject("post", postService.findbyComUsuarioById(id));

        return mv;
    }

    @GetMapping("new")
    public ModelAndView novo(){
        val mv = new ModelAndView("post/edit");

        mv.addObject("usuarios", usuarioService.findAll(Pageable.unpaged()));
        mv.addObject("postComUsuario", new PostComUsuario(
                new Post(null,LocalDateTime.now(),null,null, List.of()),
                new Usuario(null,null,null,0, null)));

        return mv;
    }

    //BindingResult result deve vir imediatamente após o objeto validado
    @PostMapping
    public String save(@Valid PostComUsuario postComUsuario, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        log.info("Olha o post a ser salvoComUsuario: {}", postComUsuario);
        
        if (result.hasErrors()){
            model.addAttribute("usuarios", usuarioService.findAll(Pageable.unpaged()));
            return "post/edit";
        }
        
        Post postReal = postComUsuario.post();
        
        val postSalvo = postService.save(postReal);
        
        redirectAttributes.addFlashAttribute("msgSuccess", "Post salvo com sucesso!");

        return "redirect:/post/" + postSalvo.id();
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable Long id){
        val mv = new ModelAndView("post/edit");

        mv.addObject("usuarios", usuarioService.findAll(Pageable.unpaged()));
        mv.addObject("postComUsuario", postService.findbyComUsuarioById(id));

        return mv;
    }

    @GetMapping
    public ModelAndView list(@PageableDefault Pageable pageable){
        val mv = new ModelAndView("post/list");
        mv.addObject("posts", postService.findAll(pageable));
        return mv;
    }
    
    @DeleteMapping("/{id}")
    public String destroy(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes, @PageableDefault Pageable pageable) {
        try {
            postService.delete(id);
            redirectAttributes.addFlashAttribute("msgSuccess", "Post #"+id+" excluído com sucesso!");
            return "redirect:/post";
        }    
        catch (DbActionExecutionException e) {
            model.addAttribute("msgError", e.getMessage());
            model.addAttribute("posts", postService.findAll(pageable));
            return "post/list";
        }
        
    }

}
