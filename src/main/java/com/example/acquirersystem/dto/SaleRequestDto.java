
package com.example.acquirersystem.dto;

import lombok.Data;

@Data
public class SaleRequestDto {

	private String cardNo;
	private String currency;
	private String amount;
	private Long paymentProfileId;
	
}
