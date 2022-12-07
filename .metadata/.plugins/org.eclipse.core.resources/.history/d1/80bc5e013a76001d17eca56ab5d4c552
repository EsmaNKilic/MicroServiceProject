package com.kodlama.invoiceService.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.invoiceService.business.abstracts.InvoiceService;
import com.kodlama.invoiceService.business.requests.CreateInvoiceRequest;
import com.kodlama.invoiceService.business.requests.UpdateInvoiceRequest;
import com.kodlama.invoiceService.business.responses.CreateInvoiceResponse;
import com.kodlama.invoiceService.business.responses.GetAllInvoiceResponse;
import com.kodlama.invoiceService.business.responses.GetInvoiceResponse;
import com.kodlama.invoiceService.business.responses.UpdateInvoiceResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoicesController {

	private InvoiceService invoiceService;
	
	@GetMapping
	public List<GetAllInvoiceResponse> getAll() {
		return this.invoiceService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetInvoiceResponse getById(@PathVariable String id) {
		return this.invoiceService.getById(id);
	}
	
	@PostMapping
	public CreateInvoiceResponse add(@RequestBody CreateInvoiceRequest createInvoiceRequest) {
		return this.invoiceService.add(createInvoiceRequest);
	}
	
	@PutMapping
	public UpdateInvoiceResponse update(@RequestBody UpdateInvoiceRequest updateInvoiceRequest) {
		return this.invoiceService.update(updateInvoiceRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.invoiceService.delete(id);
	}
}
