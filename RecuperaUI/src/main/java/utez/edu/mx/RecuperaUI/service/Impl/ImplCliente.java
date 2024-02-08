package utez.edu.mx.RecuperaUI.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.RecuperaUI.model.dao.ClienteDao;
import utez.edu.mx.RecuperaUI.model.dto.ClienteDto;
import utez.edu.mx.RecuperaUI.model.entity.ClienteBean;
import utez.edu.mx.RecuperaUI.service.ICliente;

import java.util.List;

@Service
public class ImplCliente implements ICliente {

    @Autowired
    private ClienteDao clienteDao;
    @Override
    @Transactional
    public ClienteBean save(ClienteDto clienteDto) {
ClienteBean cliente = ClienteBean.builder()
        .idcliente(clienteDto.getIdcliente())
        .nombre(clienteDto.getNombre())
        .apellido1(clienteDto.getApellido1())
        .apellido2(clienteDto.getApellido2())
        .direccion(clienteDto.getDireccion())
        .contacto(clienteDto.getContacto())
        .build();
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteBean findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
@Transactional(readOnly = true)
    public List<ClienteBean> findAll() {
        return (List<ClienteBean>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void delete(ClienteBean cliente) {
        clienteDao.delete(cliente);

    }



}
