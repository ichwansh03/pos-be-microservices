package com.ichwan.outlet.repository;

import com.ichwan.outlet.entity.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OutletRepository extends JpaRepository<Outlet, Long> {

    Optional<Outlet> findByName(String name);
}
