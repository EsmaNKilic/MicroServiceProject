package com.kodlama.invoiceService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.invoiceService.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String>{

}
