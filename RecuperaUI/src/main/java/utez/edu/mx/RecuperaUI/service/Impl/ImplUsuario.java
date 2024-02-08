package utez.edu.mx.RecuperaUI.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.RecuperaUI.model.dao.UsuarioDao;
import utez.edu.mx.RecuperaUI.model.dto.UsuarioDto;
import utez.edu.mx.RecuperaUI.model.entity.UsuarioBean;
import utez.edu.mx.RecuperaUI.service.IUsuario;

import java.util.List;
@Service
public class ImplUsuario implements IUsuario {
@Autowired
private UsuarioDao usuarioDao;
    @Override
@Transactional
    public UsuarioBean save(UsuarioDto usuarioDto) {
    UsuarioBean usuario =UsuarioBean.builder()
            .idusuario(usuarioDto.getIdusuario())
            .username(usuarioDto.getUsername())
            .password(usuarioDto.getPassword())
            .status(usuarioDto.getStatus())
            .build();
    return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioBean findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioBean> findAll() {
        return (List<UsuarioBean>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void delete(UsuarioBean usuario) {
        usuarioDao.delete(usuario);
    }
    @Override
    @Transactional
    public UsuarioBean findByUsername(String username) {
        return usuarioDao.findByUsername(username).orElse(null);
    }
}
