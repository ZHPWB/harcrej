package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.RejestracjeMapper;
import com.zhpwb.harcrej.model.Rejestracje;
import com.zhpwb.harcrej.respository.RejestracjeRepository;
import com.zhpwb.harcrej.service.RejestracjeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RejestracjeServiceImpl implements RejestracjeService {

    private final RejestracjeRepository rejestracjeRepository;
    private final RejestracjeMapper rejestracjeMapper;

    @Override
    public List<Rejestracje> getAllRejestracje() {
        return rejestracjeMapper.mapListToDto(rejestracjeRepository.findAll());
    }

    @Override
    public List<Rejestracje> getHufiecRejestracje(Integer hufiecId) {
        var rejestracjeEntities = rejestracjeRepository.findAllByHufiecId(hufiecId);

        return rejestracjeMapper.mapListToDto(rejestracjeEntities);
    }

    @Override
    public List<Rejestracje> getSzczepRejestracje(Integer szczepId) {
        var rejestracjeEntities = rejestracjeRepository.findAllBySzczepId(szczepId);

        return rejestracjeMapper.mapListToDto(rejestracjeEntities);
    }

    @Override
    public Rejestracje getDruzynaRejestracje(Integer druzynaId) {
        return rejestracjeMapper.mapToDto(rejestracjeRepository.findById(druzynaId).orElse(null));
    }


    @Override
    public void createHufiecRejestracje(Integer hufiecId, Rejestracje rejestracje) {
        var rejestracjeEntity = rejestracjeMapper.mapToEntity(rejestracje);

        rejestracjeEntity.setHufiecId(hufiecId);
        rejestracjeRepository.save(rejestracjeEntity);
    }

    @Override
    public void createSzczepRejestracje(Integer szczepId, Rejestracje rejestracje) {
        var rejestracjeEntity = rejestracjeMapper.mapToEntity(rejestracje);

        rejestracjeEntity.setSzczepId(szczepId);
        rejestracjeRepository.save(rejestracjeEntity);
    }

    @Override
    public void createDruzynaRejestracje(Integer druzynaId, Rejestracje rejestracje) {
        var rejestracjeEntity = rejestracjeMapper.mapToEntity(rejestracje);

        rejestracjeEntity.setDruzynaId(druzynaId);
        rejestracjeRepository.save(rejestracjeEntity);
    }

}


