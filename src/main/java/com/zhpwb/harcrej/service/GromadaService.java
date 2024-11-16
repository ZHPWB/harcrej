package com.zhpwb.harcrej.service;

import com.zhpwb.harcrej.model.Gromada;

import java.util.List;

public interface GromadaService {

    void createGromada(Gromada gromada);

    Gromada getGromadaById(Integer gromadaId);

    List<Gromada> getListOfGromady();

    void updateGromada(Integer gromadaId, Gromada updatedGromadaDTO);

    void deleteGromada(Integer gromadaId);
}
