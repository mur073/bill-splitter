package com.mur073.billsplitter.service.impl;

import com.mur073.billsplitter.dto.request.SplitRequestDto;
import com.mur073.billsplitter.dto.response.SplitResponseDto;
import com.mur073.billsplitter.service.BillSplitterService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BillSplitterServiceImpl implements BillSplitterService {

    @Override
    public SplitResponseDto split(SplitRequestDto request) {
        Map<String, Double> result = new HashMap<>();

        for (SplitRequestDto.ItemDto item : request.items()) {

            int usersCount = item.users().size();
            double pricePerUser = item.price() / usersCount;

            for (String user : item.users()) {
                result.merge(user, pricePerUser, Double::sum);
            }
        }

        return new SplitResponseDto(result);
    }
}
