package com.gtponline.service.impl;

import com.gtponline.model.Band;
import com.gtponline.repository.BandRepository;
import com.gtponline.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandServiceImpl implements BandService {

    private BandRepository bandRepository;

    @Autowired
    public BandServiceImpl(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    @Override
    public Band save(Band band) {
        return bandRepository.save(band);
    }

    @Override
    public Band get(long id) {
        return bandRepository.findOne(id);
    }

    @Override
    public Iterable<Band> list() {
        return bandRepository.findAll();
    }

    @Override
    public void update(Band band) {
        bandRepository.save(band);
    }

    @Override
    public void delete(long id) {
        bandRepository.delete(id);
    }
}
