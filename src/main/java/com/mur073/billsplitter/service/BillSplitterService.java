package com.mur073.billsplitter.service;

import com.mur073.billsplitter.dto.request.SplitRequestDto;
import com.mur073.billsplitter.dto.response.SplitResponseDto;

public interface BillSplitterService {
    SplitResponseDto split(SplitRequestDto request);
}
