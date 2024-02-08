package utez.edu.mx.RecuperaUI.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsuarioDto {
    private Integer idusuario;
    private String username;
    private String password;
    private String status;
}
