package com.kodlama.invoiceService.business.abstracts;

import java.util.List;

import com.kodlama.invoiceService.business.requests.CreateInvoiceRequest;
import com.kodlama.invoiceService.business.requests.UpdateInvoiceRequest;
import com.kodlama.invoiceService.business.responses.CreateInvoiceResponse;
import com.kodlama.invoiceService.business.responses.GetAllInvoiceResponse;
import com.kodlama.invoiceService.business.responses.GetInvoiceResponse;
import com.kodlama.invoiceService.business.responses.UpdateInvoiceResponse;
import com.kodlama.invoiceService.entities.Invoice;

public interface InvoiceService {

	List<GetAllInvoiceResponse> getAll();
	GetInvoiceResponse getById(String id);
	CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest);
	UpdateInvoiceResponse update(UpdateInvoiceRequest updateInvoiceRequest);
	void delete(String id);
	
	void createInvoice(Invoice invoice);
}
