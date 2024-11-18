package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.SzczepMapper;
import com.zhpwb.harcrej.model.DruzynaEntity;
import com.zhpwb.harcrej.model.Szczep;
import com.zhpwb.harcrej.model.SzczepEntity;
import com.zhpwb.harcrej.respository.DruzynaRepository;
import com.zhpwb.harcrej.respository.SzczepRepository;
import com.zhpwb.harcrej.service.SzczepService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SzczepServiceImpl implements SzczepService {

    private final SzczepRepository szczepRepository;
    private final DruzynaRepository druzynaRepository;
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
            var updatedEntity = szczepMapper.mapToEntity(updatedSzczepDTO);

            existingSzczepEntity.setName(updatedEntity.getName());
            existingSzczepEntity.setAreaOfOperation(updatedEntity.getAreaOfOperation());
            existingSzczepEntity.setSzczepowy(updatedEntity.getSzczepowy());

            szczepRepository.save(existingSzczepEntity);

        }
    }

    @Override
    public void deleteSzczep(Integer szczepId) {
        szczepRepository.deleteById(szczepId);
    }

    @Override
    public void linkDruzynaToSzczep(Integer szczepId, Integer druzynaId) {
        SzczepEntity szczep = szczepRepository.findById(szczepId)
                .orElseThrow(() -> new EntityNotFoundException("Szczep not found"));
        DruzynaEntity druzyna = druzynaRepository.findById(druzynaId)
                .orElseThrow(() -> new EntityNotFoundException("Drużyna not found"));

        if (szczep.getDruzyny().size() >= 3) {
            throw new IllegalStateException("A Szczep can only have up to 3 Drużyny.");
        }

        druzyna.setSzczep(szczep);
        szczep.getDruzyny().add(druzyna);

        druzynaRepository.save(druzyna);
        szczepRepository.save(szczep);
    }
}
