package utez.edu.mx.RecuperaUI.model.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteDto {
    private Integer idcliente;

    private String nombre;

    private String apellido1;

    private String apellido2;

    private String direccion;

    private String contacto;
}
