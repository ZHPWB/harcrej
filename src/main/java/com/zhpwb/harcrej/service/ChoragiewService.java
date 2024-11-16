package com.zhpwb.harcrej.service;

import com.zhpwb.harcrej.model.Choragiew;

import java.util.List;

public interface ChoragiewService {
    void createChoragiew(Choragiew choragiew);

    Choragiew getChoragiewById(Integer choragiewId);

    List<Choragiew> getListOfChoragwi();

    void updateChoragiew(Integer choragiewId, Choragiew updatedChoragiewDTO);

    void deleteChoragiew(Integer choragiewId);
}
