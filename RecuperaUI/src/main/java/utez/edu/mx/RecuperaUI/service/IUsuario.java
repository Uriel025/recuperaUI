package utez.edu.mx.RecuperaUI.service;

import utez.edu.mx.RecuperaUI.model.dto.UsuarioDto;
import utez.edu.mx.RecuperaUI.model.entity.UsuarioBean;

import java.util.List;

public interface IUsuario {
    UsuarioBean save(UsuarioDto usuario);

    UsuarioBean findById(Integer id);

    List<UsuarioBean> findAll();

    void delete(UsuarioBean usuario);
    UsuarioBean findByUsername(String username);
}
