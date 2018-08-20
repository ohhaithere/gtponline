package com.gtponline.repository;

import com.gtponline.model.Gtp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GtpRepository extends CrudRepository<Gtp, Long> {

    Gtp findByBandId(Long bandId);

}
