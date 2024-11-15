package com.zhpwb.harcrej.service;

import com.zhpwb.harcrej.model.Druzyna;

import java.util.List;

public interface DruzynaService {

    void createDruzyna(Druzyna druzyna);

    Druzyna getDruzynaById(Integer druzynaId);

    List<Druzyna> getListOfDruzyny();

    void updateDruzyna(Integer druzynaId, Druzyna updatedDruzynaDTO);

    void deleteDruzyna(Integer druzynaId);
}
