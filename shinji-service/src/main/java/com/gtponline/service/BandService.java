package com.gtponline.service;

import com.gtponline.model.Band;

public interface BandService {
    Band save(Band band);
    Band get(long id);
    Iterable<Band> list();
    void update(Band band);
    void delete(long id);
}
