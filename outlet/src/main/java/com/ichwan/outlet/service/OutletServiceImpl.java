package com.ichwan.outlet.service;

import com.ichwan.outlet.dto.OutletDto;
import com.ichwan.outlet.entity.Outlet;
import com.ichwan.outlet.exception.ResourceNotFoundException;
import com.ichwan.outlet.repository.OutletRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OutletServiceImpl implements OutletService{

    private OutletRepository outletRepository;

    @Override
    public Page<Outlet> getOutlets(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return outletRepository.findAll(pageable);
    }

    @Override
    public Outlet getOutletByName(String name) {
        return outletRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("outlet not found")
        );
    }

    @Override
    public Outlet createOutlet(OutletDto outletDto) {
        Outlet outlet = new Outlet();
        outlet.setName(outlet.getName());
        outlet.setAddress(outlet.getAddress());
        outlet.setPhone(outlet.getPhone());
        outlet.setTotalEmployee(outletDto.getTotalEmployee());
        outlet.setCreatedBy(outlet.getCreatedBy());
        return outletRepository.save(outlet);
    }

    @Override
    public Outlet updateOutlet(OutletDto outletDto, Long id) {
        Outlet outlet = new Outlet();
        outlet.setName(outlet.getName());
        outlet.setAddress(outlet.getAddress());
        outlet.setPhone(outlet.getPhone());
        outlet.setTotalEmployee(outletDto.getTotalEmployee());
        outlet.setCreatedBy(outlet.getCreatedBy());
        outlet.setOutletId(id);
        return outletRepository.save(outlet);
    }

    @Override
    public void deleteOutlet(Long id) {
        outletRepository.deleteById(id);
    }
}
