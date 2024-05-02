package com.vcb.process.metadataupdater.repository;

import com.vcb.process.metadataupdater.domain.Logging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoggingRepository extends JpaRepository<Logging, Long> {
    List<Logging> findByMarkError(String markError);
}