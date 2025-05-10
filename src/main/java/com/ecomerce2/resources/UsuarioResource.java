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
    private UsuarioService service;

      @GetMapping("/{id}")
      public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
          Usuario usuario = service.buscarUsuarioPorId(id);
          return ResponseEntity.ok(service.converterUsuarioParaUsuarioDTO(usuario));
      }
    @GetMapping("")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@RequestParam String email) {
        Usuario usuario = service.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(service.converterUsuarioParaUsuarioDTO(usuario));

    }
    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = service.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }
    @PutMapping("")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id,
                                                        @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = service.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario( @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioService.deletarUsuario(usuarioDTO.getId());
        return ResponseEntity.noContent().build();
    }

}
