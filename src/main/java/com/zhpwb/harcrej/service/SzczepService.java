package com.zhpwb.harcrej.service;

import com.zhpwb.harcrej.model.Szczep;

import java.util.List;

public interface SzczepService {

    void createSzczep(Szczep szczep);

    Szczep getSzczepById(Integer szczepId);

    List<Szczep> getListOfSzczepy();

    void updateSzczep(Integer szczepId, Szczep updatedSzczepDTO);

    void deleteSzczep(Integer szczepId);

    void linkDruzynaToSzczep(Integer szczepId, Integer druzynaId);
}
