package com.kodlama.invoiceService.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
	private String id;
    private double dailyPrice;
    private String brandName;
    private String modelName;
    private int modelYear;
    private String plate;
    private int state;
    
}
