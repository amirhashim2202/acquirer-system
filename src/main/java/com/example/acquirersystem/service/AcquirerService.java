
package com.example.acquirersystem.service;
import org.springframework.stereotype.Service;

import com.example.acquirersystem.dto.RefundRequestDto;
import com.example.acquirersystem.dto.RefundResponseDto;
import com.example.acquirersystem.dto.SaleRequestDto;
import com.example.acquirersystem.dto.SaleResponseDto;

import java.math.BigDecimal;
@Service
public class AcquirerService {
    public SaleResponseDto sale(SaleRequestDto req){
        SaleResponseDto res = new SaleResponseDto();
        res.setReference(req.getCurrency());
        res.setCurrency(req.getCurrency()); res.setAmount(req.getAmount());
        BigDecimal amt = new BigDecimal(req.getAmount()); if(amt.intValue()%2==1) res.setSaleStatus("SUCCESS"); else res.setSaleStatus("FAILED");
        return res;
    }
    public RefundResponseDto refund(RefundRequestDto req){
        RefundResponseDto res = new RefundResponseDto();
        res.setReference(req.getReference()); res.setCurrency(req.getCurrency()); res.setAmount(req.getAmount());
        BigDecimal amt = new BigDecimal(req.getAmount()); if(amt.intValue()%2==1) res.setRefundStatus("SUCCESS"); else res.setRefundStatus("FAILED");
        return res;
    }
}
