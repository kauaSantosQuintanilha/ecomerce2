package com.ecomerce2.resources;

import com.ecomerce2.dto.UsuarioDTO;
import com.ecomerce2.models.Usuario;
import com.ecomerce2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public UsuarioDTO buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return UsuarioService.converterUsuarioParaUsuarioDTO(usuario);
    }

    @GetMapping("/buscar")
    public UsuarioDTO buscarUsuarioPorEmail(@RequestParam String email) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
        return UsuarioService.converterUsuarioParaUsuarioDTO(usuario);
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO = UsuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }
    @PutMapping()
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO = UsuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarUsuario(@RequestBody UsuarioDTO usuarioDTO)  {
        usuarioService.deletarUsuario(usuarioDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
