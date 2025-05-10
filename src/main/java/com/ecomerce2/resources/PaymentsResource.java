package com.ecomerce2.resources;

import com.ecomerce2.dto.PaymentsDTO;
import com.ecomerce2.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentsResource {
    @Autowired
    private PaymentsService paymentsService;

    @GetMapping ("/{id}")
    public void buscarPaymentsPorId(@PathVariable Long id) {
        paymentsService.buscarPaymentsPorId(id);
    }

    @PostMapping("")
    public ResponseEntity<PaymentsDTO> criarPayments(@RequestBody PaymentsDTO paymentsDTO) {
        paymentsDTO = paymentsService.salvarPayments(paymentsDTO);
        return ResponseEntity.ok(paymentsDTO);
    }

    @PutMapping("")
    public ResponseEntity<PaymentsDTO> atualizarPayments(@RequestBody PaymentsDTO paymentsDTO) {
        paymentsDTO = paymentsService.atualizarPayments(paymentsDTO);
        return ResponseEntity.ok(paymentsDTO);
    }

    @DeleteMapping("/")
    public ResponseEntity<Object> deletarPayments(@RequestBody PaymentsDTO paymentsDTO) {
        paymentsService.deletarPayments(paymentsDTO.getId());
        return ResponseEntity.noContent().build();
    }
}


