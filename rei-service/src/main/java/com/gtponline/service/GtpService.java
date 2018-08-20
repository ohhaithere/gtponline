package com.gtponline.service;

import com.gtponline.model.Gtp;

public interface GtpService {
    Gtp save(Gtp gtp);
    Gtp get(long id);
    Iterable<Gtp> list();
    void update(Gtp gtp);
    void delete(long id);
    Gtp getByBandId(Long bandId);
}
