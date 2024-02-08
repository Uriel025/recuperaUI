package utez.edu.mx.RecuperaUI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.RecuperaUI.model.dto.ClienteDto;
import utez.edu.mx.RecuperaUI.model.entity.ClienteBean;
import utez.edu.mx.RecuperaUI.service.ICliente;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")

public class ClienteController {
@Autowired
    private ICliente clienteService;

    @GetMapping("/")
    public List<ClienteBean> getCliente() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ClienteBean showById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping("/")
    public ClienteDto create(@RequestBody ClienteDto clienteDto) {
        ClienteBean clienteSave = clienteService.save(clienteDto);
        return ClienteDto.builder()
                .idcliente(clienteSave.getIdcliente())
                .nombre(clienteSave.getNombre())
                .apellido1(clienteSave.getApellido1())
                .apellido2(clienteSave.getApellido2())
                .direccion(clienteSave.getDireccion())
                .contacto(clienteSave.getContacto())
                .build();
    }

    @PutMapping("/")
    public ClienteDto update(@RequestBody ClienteDto clienteDto) {
        ClienteBean clienteUpdate = clienteService.save(clienteDto);
        return ClienteDto.builder().
                    idcliente(clienteUpdate.getIdcliente())
                .nombre(clienteUpdate.getNombre())
                .apellido1(clienteUpdate.getApellido1())
                .apellido2(clienteUpdate.getApellido2())
                .direccion(clienteUpdate.getDireccion())
                .contacto(clienteUpdate.getContacto())
                .build();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        ClienteBean cliente = clienteService.findById(id);
        clienteService.delete(cliente);
    }

}
