
package com.example.acquirersystem.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.acquirersystem.dto.RefundRequestDto;
import com.example.acquirersystem.dto.RefundResponseDto;
import com.example.acquirersystem.dto.SaleRequestDto;
import com.example.acquirersystem.dto.SaleResponseDto;

@RestController
@RequestMapping("/acquirer")
public class AcquirerController {
	
	@PostMapping("/sale")
	public SaleResponseDto sale(@RequestBody SaleRequestDto req) {
		SaleResponseDto res = new SaleResponseDto();
		res.setReference("ACQ-" + UUID.randomUUID().toString());
		res.setCurrency(req.getCurrency());
		res.setAmount(req.getAmount());
		BigDecimal amt = new BigDecimal(req.getAmount());
		BigDecimal cents = amt.remainder(BigDecimal.ONE) // get fractional part
							.movePointRight(2)        // shift decimal two places
							.abs();                   // make sure it's positive

		if (cents.intValue() != 99) // For negative case test
			res.setSaleStatus("SUCCESS");
		else
			res.setSaleStatus("FAILED");
		return res;
	}

	@PostMapping("/refund")
	public RefundResponseDto refund(@RequestBody RefundRequestDto req) {
		RefundResponseDto res = new RefundResponseDto();
		res.setReference(req.getReference());
		res.setCurrency(req.getCurrency());
		res.setAmount(req.getAmount());
		BigDecimal amt = new BigDecimal(req.getAmount());
		BigDecimal cents = amt.remainder(BigDecimal.ONE) // get fractional part
				.movePointRight(2)        // shift decimal two places
				.abs();                   // make sure it's positive

		if (cents.intValue() != 99) // For negative case test
			res.setRefundStatus("SUCCESS");
		else
			res.setRefundStatus("FAILED");
		return res;
	}
}
