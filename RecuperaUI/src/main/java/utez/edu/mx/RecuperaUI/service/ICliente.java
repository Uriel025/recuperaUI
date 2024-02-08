package utez.edu.mx.RecuperaUI.service;

import utez.edu.mx.RecuperaUI.model.dto.ClienteDto;
import utez.edu.mx.RecuperaUI.model.entity.ClienteBean;

import java.util.List;

public interface ICliente {
     ClienteBean save(ClienteDto cliente);

    ClienteBean findById(Integer id);

    List<ClienteBean> findAll();

    void delete(ClienteBean cliente);
}
