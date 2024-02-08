package utez.edu.mx.RecuperaUI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.RecuperaUI.model.dto.ClienteDto;
import utez.edu.mx.RecuperaUI.model.dto.UsuarioDto;
import utez.edu.mx.RecuperaUI.model.entity.ClienteBean;
import utez.edu.mx.RecuperaUI.model.entity.UsuarioBean;
import utez.edu.mx.RecuperaUI.service.IUsuario;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    private final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private final String NUMBER = "0123456789";
    private final String SPECIAL_CHAR = "!@#$%&*()_+-=[]|,./?><";

    private final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER + SPECIAL_CHAR;

    private final Random random = new SecureRandom();

    @GetMapping("/")
    public List<UsuarioBean> getUsuario() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioBean showById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/")
    public Object create(@RequestBody UsuarioDto usuarioDto) {
        UsuarioBean existingUser = usuarioService.findByUsername(usuarioDto.getUsername());
        if (existingUser != null) {
            return "Error: El nombre de usuario ya existe";
        }


        String generatedPassword = generateRandomPassword();
        usuarioDto.setPassword(generatedPassword);

        UsuarioBean usuarioSave = usuarioService.save(usuarioDto);
        return UsuarioDto.builder()
                .idusuario(usuarioSave.getIdusuario())
                .username(usuarioSave.getUsername())
                .password(usuarioSave.getPassword())
                .status(usuarioSave.getStatus())
                .build();
    }

    private boolean isUsernameExists(String username) {
        return usuarioService.findByUsername(username) != null;
    }

    @PutMapping("/")
    public UsuarioDto update(@RequestBody UsuarioDto usuarioDto) {
        UsuarioBean usuarioUpdate = usuarioService.save(usuarioDto);
        return UsuarioDto.builder()
                .idusuario(usuarioUpdate.getIdusuario())
                .username(usuarioUpdate.getUsername())
                .password(usuarioUpdate.getPassword())
                .status(usuarioUpdate.getStatus())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        UsuarioBean usuario = usuarioService.findById(id);
        usuarioService.delete(usuario);
    }

    private String generateRandomPassword() {
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }
}
