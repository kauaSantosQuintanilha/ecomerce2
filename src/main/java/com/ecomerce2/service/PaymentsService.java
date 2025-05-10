package com.ecomerce2.service;

import com.ecomerce2.dto.PaymentsDTO;
import com.ecomerce2.models.Payments;
import com.ecomerce2.repositories.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {
    @Autowired
    private  PaymentsRepository paymentsRepository;
    public PaymentsDTO salvarPayments(PaymentsDTO paymentsDTO) {
        Payments payments = converterPaymentsDTOParaPayments(paymentsDTO);
        payments = paymentsRepository.save(payments);
        return converterPaymentsParaPaymentsDTO(payments);
    }
    public static PaymentsDTO converterPaymentsParaPaymentsDTO(Payments payments) {
        PaymentsDTO paymentsDTO = new PaymentsDTO();
        paymentsDTO.setId(payments.getId());
        paymentsDTO.setMoments(payments.getMoment());
        return paymentsDTO;
    }

    public static Payments converterPaymentsDTOParaPayments(PaymentsDTO paymentsDTO) {
        Payments payments = new Payments();
        payments.setId(paymentsDTO.getId());

        payments.setMoment(paymentsDTO.getMoments());

        return payments;
    }

    public PaymentsDTO buscarPaymentsPorId(Long id) {
        Payments payment = paymentsRepository.findById(id).orElseThrow();
        return new PaymentsDTO(payment.getId(), payment.getMoment());
    }


    public PaymentsDTO atualizarPayments(PaymentsDTO paymentsDTO) {
        if (paymentsDTO.getId() == null) {
            throw new IllegalArgumentException("id não informado");
        }
        Payments payments = paymentsRepository.findById(paymentsDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Payments não encontrado"));
        payments = converterPaymentsDTOParaPayments(paymentsDTO);
        payments = paymentsRepository.save(payments);
        return converterPaymentsParaPaymentsDTO(payments);
    }


    public void deletarPayments(Long id) {
        paymentsRepository.deleteById(id);
    }
}

