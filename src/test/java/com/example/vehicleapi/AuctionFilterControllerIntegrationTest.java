package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.dto.AuctionFilterTypeDto;
import com.example.vehicleapi.model.AuctionFilterType;
import com.example.vehicleapi.model.User;
import com.example.vehicleapi.repository.AuctionFilterTypeRepository;
import com.example.vehicleapi.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuctionFilterControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuctionFilterTypeRepository auctionFilterTypeRepository;

    private User user;
    private AuctionFilterType type;

    @BeforeEach
    public void setup() {
        user = userRepository.save(User.builder().login("demo_user").password("password").enabled(true).build());
        type = auctionFilterTypeRepository.save(AuctionFilterType.builder().filterType("FAVORITES").build());
    }

    @Test
    public void testCreate() throws Exception {
        AuctionFilterDto dto = new AuctionFilterDto();
        dto.setUserId(user.getId());
        dto.setType(AuctionFilterTypeDto.builder().id(type.getId()).filterType("FAVORITES").build());
        dto.setFilterData("{\"year\":2023,\"make\":\"Honda\"}");

        mockMvc.perform(post("/auction-filter")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isCreated());
    }
}