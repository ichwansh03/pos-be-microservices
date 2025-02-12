package com.ichwan.outlet.service;

import com.ichwan.outlet.dto.OutletDto;
import com.ichwan.outlet.entity.Outlet;
import org.springframework.data.domain.Page;

public interface OutletService {

    Page<Outlet> getOutlets(int page, int size);

    Outlet getOutletByName(String name);

    Outlet createOutlet(OutletDto outletDto);

    Outlet updateOutlet(OutletDto outletDto, Long id);

    void deleteOutlet(Long id);
}
