package br.uff.exercicio4.controller;


import br.uff.exercicio4.modelo.Usuario;
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
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("new")
    public ModelAndView novo(){
        val mv = new ModelAndView("usuario/edit");

        mv.addObject("usuario", new Usuario(null, null, null, 0, null));

        return mv;
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable Long id){
        val mv = new ModelAndView("usuario/edit");

        mv.addObject("usuario", usuarioService.findObjById(id));

        return mv;
    }
    
    @PostMapping
    public String save(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes){
        log.info("Olha o post a ser salvo: {}", usuario);
                
        if (result.hasErrors()){
            return "usuario/edit";
        }
        
        Usuario usuarioSalvo = usuarioService.save(usuario);
        
        redirectAttributes.addFlashAttribute("msgSuccess", "Usuário salvo com sucesso!");
        
        return "redirect:/usuario/"+usuarioSalvo.id();
        
    }
    
    @DeleteMapping("/{id}")
    public String destroy(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes, @PageableDefault Pageable pageable) {
        try {
            usuarioService.delete(id);
            redirectAttributes.addFlashAttribute("msgSuccess", "Usuário #"+id+" excluído com sucesso!");
            return "redirect:/usuario";
        }    
        catch (DbActionExecutionException e) {
            model.addAttribute("msgError", "O usuário #"+id+" tem posts associados e não pode ser excluído!");
            model.addAttribute("usuarios", usuarioService.findAll(pageable));
            return "usuario/list";
        }
        
    }
}
