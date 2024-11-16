package com.zhpwb.harcrej.service;

import com.zhpwb.harcrej.model.Hufiec;

import java.util.List;

public interface HufiecService {

    void createHufiec(Hufiec hufiec);

    Hufiec getHufiecById(Integer hufiecId);

    List<Hufiec> getListOfHufce();

    void updateHufiec(Integer hufiecId, Hufiec updatedHufiecDTO);

    void deleteHufiec(Integer hufiecId);
}
