package com.ecomerce2.resources;
import com.ecomerce2.dto.AdminDTO;
import com.ecomerce2.models.Admin;
import com.ecomerce2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminResource {
    @Autowired
    private AdminService adminServices;

    @GetMapping("/{id}")
    public AdminDTO buscarAdminPorId(@PathVariable Long id) {
        Admin admin = adminServices.buscarAdminPorId(id);
        return AdminService.converterAdminParaAdminDTO(admin);
    }
    @GetMapping("/buscar")
    public AdminDTO buscarAdminPorEmail(@RequestParam String email) {
        Admin admin = AdminService.buscarAdminPorEmail(email);
        return AdminService.converterAdminParaAdminDTO(admin);
    }

    @PostMapping("/")
    public ResponseEntity<AdminDTO> criarAdmin(@RequestBody AdminDTO adminDTO) {
        adminDTO = AdminService.salvarAdmin(adminDTO);
        return ResponseEntity.ok(adminDTO);
    }
    @PutMapping()
    public ResponseEntity<AdminDTO> atualizarAdmin(@RequestBody AdminDTO adminDTO) {
        adminDTO = AdminService.salvarAdmin(adminDTO);
        return ResponseEntity.ok(adminDTO);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarAdmin(@RequestBody AdminDTO adminDTO)  {
        AdminService.deletarAdmin(adminDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
