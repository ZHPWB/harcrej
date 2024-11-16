package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.SzczepMapper;
import com.zhpwb.harcrej.model.Szczep;
import com.zhpwb.harcrej.respository.SzczepRepository;
import com.zhpwb.harcrej.service.SzczepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SzczepServiceImpl implements SzczepService {

    private final SzczepRepository szczepRepository;
    private final SzczepMapper szczepMapper;

    @Override
    public void createSzczep(Szczep szczep) {
        var szczepEntity = szczepMapper.mapToEntity(szczep);
        szczepRepository.save(szczepEntity);
    }

    @Override
    public Szczep getSzczepById(Integer szczepId) {
        return szczepMapper.mapToDto(szczepRepository.findById(szczepId).orElse(null));
    }

    @Override
    public List<Szczep> getListOfSzczepy() {
        var szczepEntities = szczepRepository.findAll();
        return szczepMapper.mapListToDto(szczepEntities);
    }

    @Override
    public void updateSzczep(Integer szczepId, Szczep updatedSzczepDTO) {
        // Find the existing entity by ID
        var existingSzczepEntity = szczepRepository.findById(szczepId).orElse(null);

        if (existingSzczepEntity != null) {
            existingSzczepEntity.setName(updatedSzczepDTO.getName());
            existingSzczepEntity.setAreaOfOperation(updatedSzczepDTO.getAreaOfOperation());
            existingSzczepEntity.setPersonInCharge(updatedSzczepDTO.getPersonInCharge());

            szczepRepository.save(existingSzczepEntity);

        }
    }

    @Override
    public void deleteSzczep(Integer szczepId) {
        szczepRepository.deleteById(szczepId);
    }
}
