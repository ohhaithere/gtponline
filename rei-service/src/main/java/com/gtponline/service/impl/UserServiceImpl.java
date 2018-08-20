package com.gtponline.service.impl;

import com.gtponline.model.Gtp;
import com.gtponline.repository.GtpRepository;
import com.gtponline.service.GtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements GtpService {

    private GtpRepository gtpRepository;

    @Autowired
    public UserServiceImpl(GtpRepository gtpRepository) {
        this.gtpRepository = gtpRepository;
    }

    @Override
    public Gtp save(Gtp gtp) {
        return gtpRepository.save(gtp);
    }

    @Override
    public Gtp get(long id) {
        return gtpRepository.findOne(id);
    }

    @Override
    public Iterable<Gtp> list() {
        return gtpRepository.findAll();
    }

    @Override
    public void update(Gtp gtp) {
        gtpRepository.save(gtp);
    }

    @Override
    public void delete(long id) {
        gtpRepository.delete(id);
    }

    @Override
    public Gtp getByBandId(Long id) {
        return gtpRepository.findByBandId(id);
    }
}
