package com.ichwan.employee.service;

import com.ichwan.employee.dto.client.PosDetailDto;

public interface PosService {

    // Method to fetch POS details by phone number
    PosDetailDto fetchPosDetail(String phone);

}
