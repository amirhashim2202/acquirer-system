
package com.example.acquirersystem.dto;

import lombok.Data;

@Data
public class RefundResponseDto {
	
	private String reference;
	private String currency;
	private String amount;
	private String refundStatus;

}
