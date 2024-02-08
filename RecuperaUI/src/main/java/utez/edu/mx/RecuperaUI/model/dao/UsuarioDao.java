package utez.edu.mx.RecuperaUI.model.dao;

import org.springframework.data.repository.CrudRepository;
import utez.edu.mx.RecuperaUI.model.entity.UsuarioBean;

import java.util.Optional;

public interface UsuarioDao extends CrudRepository<UsuarioBean, Integer> {

    Optional<UsuarioBean> findByUsername(String username);
}
