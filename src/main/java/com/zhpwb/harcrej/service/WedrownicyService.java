package com.zhpwb.harcrej.service;

import com.zhpwb.harcrej.model.Wedrownicy;

import java.util.List;

public interface WedrownicyService {

    void createWedrownicy(Wedrownicy wedrownicy);

    Wedrownicy getWedrownicyById(Integer wedrownicyId);

    List<Wedrownicy> getListOfWedrownicy();

    void updateWedrownicy(Integer wedrownicyId, Wedrownicy updatedWedrownicyDTO);

    void deleteWedrownicy(Integer wedrownicyId);
}
