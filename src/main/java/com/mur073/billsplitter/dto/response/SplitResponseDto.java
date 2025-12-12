package com.mur073.billsplitter.dto.response;

import java.util.Map;

public record SplitResponseDto(Map<String, Double> amounts) {
}
