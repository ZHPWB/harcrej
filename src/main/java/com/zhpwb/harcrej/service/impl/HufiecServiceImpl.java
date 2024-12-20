package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.HufiecMapper;
import com.zhpwb.harcrej.model.Hufiec;
import com.zhpwb.harcrej.model.HufiecEntity;
import com.zhpwb.harcrej.model.SzczepEntity;
import com.zhpwb.harcrej.respository.HufiecRepository;
import com.zhpwb.harcrej.respository.SzczepRepository;
import com.zhpwb.harcrej.service.HufiecService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HufiecServiceImpl implements HufiecService {

    private final HufiecRepository hufiecRepository;
    private final SzczepRepository szczepRepository;
    private final HufiecMapper hufiecMapper;

    @Override
    public void createHufiec(Hufiec hufiec) {
        var hufiecEntity = hufiecMapper.mapToEntity(hufiec);
        hufiecRepository.save(hufiecEntity);
    }

    @Override
    public Hufiec getHufiecById(Integer hufiecId) {
        return hufiecMapper.mapToDto(hufiecRepository.findById(hufiecId).orElse(null));
    }

    @Override
    public List<Hufiec> getListOfHufce() {
        var hufiecEntities = hufiecRepository.findAll();
        return hufiecMapper.mapListToDto(hufiecEntities);
    }

    @Override
    public void updateHufiec(Integer hufiecId, Hufiec updatedHufiecDTO) {
        // Find the existing entity by ID
        var existingHufiecEntity = hufiecRepository.findById(hufiecId).orElse(null);

        if (existingHufiecEntity != null) {
            var updatedEntity = hufiecMapper.mapToEntity(updatedHufiecDTO);

            existingHufiecEntity.setName(updatedEntity.getName());
            existingHufiecEntity.setHufcowy(updatedEntity.getHufcowy());
            existingHufiecEntity.setAreaOfOperation(updatedEntity.getAreaOfOperation());

            hufiecRepository.save(existingHufiecEntity);

        }
    }

    @Override
    public void deleteHufiec(Integer hufiecId) {
        hufiecRepository.deleteById(hufiecId);
    }

    @Override
    public void linkSzczepToHufiec(Integer hufiecId, Integer szczepId) {
        HufiecEntity hufiec = hufiecRepository.findById(hufiecId)
                .orElseThrow(() -> new EntityNotFoundException("Hufiec not found"));
        SzczepEntity szczep = szczepRepository.findById(szczepId)
                .orElseThrow(() -> new EntityNotFoundException("Szczep not found"));

        szczep.setHufiec(hufiec);
        hufiec.getSzczepy().add(szczep);

        szczepRepository.save(szczep);
        hufiecRepository.save(hufiec);
    }
}
