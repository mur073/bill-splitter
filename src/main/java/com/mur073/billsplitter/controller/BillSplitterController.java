package com.mur073.billsplitter.controller;

import com.mur073.billsplitter.dto.request.SplitRequestDto;
import com.mur073.billsplitter.dto.response.SplitResponseDto;
import com.mur073.billsplitter.service.BillSplitterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class BillSplitterController {

    private final BillSplitterService billSplitterService;

    @GetMapping("/split")
    public ResponseEntity<SplitResponseDto> split(
            @Valid @RequestBody SplitRequestDto request
    ) {
        return ResponseEntity.ok(billSplitterService.split(request));
    }
}
