
package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.AuctionFilterTypeDto;
import com.example.vehicleapi.service.AuctionFilterTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuctionFilterTypeController.class)
public class AuctionFilterTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuctionFilterTypeService service;

    @Test
    public void shouldReturnOkForGetAll() throws Exception {
        Mockito.when(service.findAll()).thenReturn(List.of());
        mockMvc.perform(get("/auction-filter-type")).andExpect(status().isOk());
    }
}
