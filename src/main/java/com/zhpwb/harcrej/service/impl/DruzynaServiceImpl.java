package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.DruzynaMapper;
import com.zhpwb.harcrej.model.Druzyna;
import com.zhpwb.harcrej.respository.DruzynaRepository;
import com.zhpwb.harcrej.service.DruzynaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DruzynaServiceImpl implements DruzynaService {

    private final DruzynaRepository druzynaRepository;
    private final DruzynaMapper druzynaMapper;

    @Override
    public void createDruzyna(Druzyna druzyna) {
        var druzynaEntity = druzynaMapper.mapToEntity(druzyna);
        druzynaRepository.save(druzynaEntity);
    }

    @Override
    public Druzyna getDruzynaById(Integer druzynaId) {
        return druzynaMapper.mapToDto(druzynaRepository.findById(druzynaId).orElse(null));
    }

    @Override
    public List<Druzyna> getListOfDruzyny() {
        var druzynaEntities = druzynaRepository.findAll();
        return druzynaMapper.mapListToDto(druzynaEntities);
    }

    @Override
    public void updateDruzyna(Integer druzynaId, Druzyna updatedDruzynaDTO) {
        // Find the existing entity by ID
        var existingDruzynaEntity = druzynaRepository.findById(druzynaId).orElse(null);

        if (existingDruzynaEntity != null) {
            existingDruzynaEntity.setName(updatedDruzynaDTO.getName());
            existingDruzynaEntity.setAreaOfOperation(updatedDruzynaDTO.getAreaOfOperation());
            existingDruzynaEntity.setPersonInCharge(updatedDruzynaDTO.getPersonInCharge());

            druzynaRepository.save(existingDruzynaEntity);

        }
    }

    @Override
    public void deleteDruzyna(Integer druzynaId) {
        druzynaRepository.deleteById(druzynaId);
    }
}
