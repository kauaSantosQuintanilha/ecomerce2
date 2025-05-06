package com.ecomerce2.service;

import com.ecomerce2.dto.AdminDTO;
import com.ecomerce2.models.Admin;
import com.ecomerce2.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private static AdminRepository adminRepository;
    public static AdminDTO salvarAdmin(AdminDTO adminDTO) {
        Admin admin = converterAdminDTOParaAdmin(adminDTO);
        admin = adminRepository.save(admin);
        return converterAdminParaAdminDTO(admin);
    }
    public static AdminDTO converterAdminParaAdminDTO(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setNome(admin.getNome());
        adminDTO.setEmail(admin.getEmail());
        return adminDTO;
    }

    public static Admin converterAdminDTOParaAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setNome(adminDTO.getNome());
        admin.setEmail(adminDTO.getEmail());
        return admin;
    }

    public Admin buscarAdminPorId(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin não encontrado"));
    }

    public static Admin buscarAdminPorEmail(String email) {
        return adminRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Admin não encontrado"));
    }

    public AdminDTO atualizarAdmin(AdminDTO adminDTO) {
        if (adminDTO.getId() == null) {
            throw new IllegalArgumentException("id não informado");
        }
        Admin admin = adminRepository.findById(adminDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Admin não encontrado"));
        admin = converterAdminDTOParaAdmin(adminDTO);
        admin = adminRepository.save(admin);
        return converterAdminParaAdminDTO(admin);
    }


    public static void deletarAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}


