package com.mur073.billsplitter.service.impl;

import com.mur073.billsplitter.dto.request.SplitRequestDto;
import com.mur073.billsplitter.dto.response.SplitResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BillSplitterServiceImplTests {
    @InjectMocks
    BillSplitterServiceImpl billSplitterService;

    @Test
    void split_ShouldReturnCorrectResponse_WhenSeveralUsers() {
        var request = new SplitRequestDto(
                List.of(
                        new SplitRequestDto.ItemDto("Black Tea", 2.10, List.of("Alex", "Jane")),
                        new SplitRequestDto.ItemDto("Pizza", 12.60, List.of("Alex", "Jane", "Mike", "Sarah"))
                )
        );

        SplitResponseDto result = billSplitterService.split(request);

        assertThat(result).isNotNull();
        assertThat(result.amounts())
                .isNotNull()
                .hasSize(4)
                .containsEntry("Alex", 4.2)
                .containsEntry("Jane", 4.2)
                .containsEntry("Mike", 3.15)
                .containsEntry("Sarah", 3.15);
    }

    @Test
    void split_ShouldReturnCorrectResponse_WhenSingleUser() {
        var request = new SplitRequestDto(
                List.of(
                        new SplitRequestDto.ItemDto("Coffee", 5.00, List.of("Alex"))
                )
        );

        SplitResponseDto result = billSplitterService.split(request);

        assertThat(result).isNotNull();
        assertThat(result.amounts())
                .hasSize(1)
                .containsEntry("Alex", 5.00);
    }
}
