package com.zhpwb.harcrej.service;

import com.zhpwb.harcrej.model.Rejestracje;

import java.util.List;

public interface RejestracjeService {


    List<Rejestracje> getAllRejestracje();
    List<Rejestracje> getHufiecRejestracje(Integer hufiecId);
    List<Rejestracje> getSzczepRejestracje(Integer szczepId);
    Rejestracje getDruzynaRejestracje(Integer druzynaId);
    void createHufiecRejestracje(Integer hufiecId, Rejestracje rejestracje);
    void createSzczepRejestracje(Integer szczepId, Rejestracje rejestracje);
    void createDruzynaRejestracje(Integer druzynaId, Rejestracje rejestracje);
}
