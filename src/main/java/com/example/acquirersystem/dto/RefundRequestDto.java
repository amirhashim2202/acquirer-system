
package com.example.acquirersystem.dto;

import lombok.Data;

@Data
public class RefundRequestDto {
	
	private String reference;
	private String currency;
	private String amount;
	
}
