package br.uff.sti.models.dto;

import java.time.LocalDateTime;

/**
 *
 * @author leandroribeirodecicco
 */

public record PostComUsuarioDTO ( 
    Long id,
    LocalDateTime dataPostagem,
    String mensagem,
    Long idUsuario,
    String nomeUsuario,
    String usernameUsuario,
    int idadeUsuario) 
{
    
    @Override
    public String toString(){
        return """
        =========================================================
        | PostComUsuario
        =========================================================       
        | Id: %s
        | DataPostagem: %s
        | Mensagem: %s
        | Id Usuario: %s
        | Nome Usuario: %s
        | Username Usuario: %s
        | Idade Usuario: %s
        =========================================================
        """.formatted(
                this.id,
                this.dataPostagem,
                this.mensagem,
                this.idUsuario,
                this.nomeUsuario,
                this.usernameUsuario,
                this.idadeUsuario);
    }
    
}
