package com.vwake.controller;

import com.vwake.exception.InvalidInputException;
import com.vwake.records.OperationRequest;
import com.vwake.records.OperationResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("error")
public class ProblemDetailsController {
    @PostMapping("/post")
    public ResponseEntity<OperationResult> postOperation(@Validated @RequestBody OperationRequest operationRequest){
        OperationResult operationResult = null;
        Double discount = operationRequest.discount();
        if (discount == null) {
            operationResult =
                    new OperationResult(operationRequest.basePrice(), null, operationRequest.basePrice());
        } else {
            if (discount.intValue() >= 100) {
                throw new InvalidInputException("Free sale is not allowed.");
            } else if (discount.intValue() > 30) {
                throw new IllegalArgumentException("Discount greater than 30% not allowed.");
            } else {
                operationResult = new OperationResult(operationRequest.basePrice(),
                        discount,
                        operationRequest.basePrice() * (100 - discount) / 100);
            }
        }
        return ResponseEntity.ok(operationResult);
    }
}
