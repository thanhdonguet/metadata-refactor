package com.vcb.process.metadataupdater.repository;

import com.vcb.process.metadataupdater.domain.PropertyDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyDefRepository extends JpaRepository<PropertyDef, Long> {
}