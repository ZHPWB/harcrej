package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.ChoragiewMapper;
import com.zhpwb.harcrej.model.Choragiew;
import com.zhpwb.harcrej.respository.ChoragiewRepository;
import com.zhpwb.harcrej.service.ChoragiewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChoragiewServiceImpl implements ChoragiewService {

    private final ChoragiewRepository choragiewRepository;
    private final ChoragiewMapper choragiewMapper;

    @Override
    public void createChoragiew(Choragiew choragiew) {
        var choragiewEntity = choragiewMapper.mapToEntity(choragiew);
        log.info("mapping");
        choragiewRepository.save(choragiewEntity);
    }

    @Override
    public Choragiew getChoragiewById(Integer choragiewId) {
        return choragiewMapper.mapToDto(choragiewRepository.findById(choragiewId).orElse(null));
    }

    @Override
    public List<Choragiew> getListOfChoragwi() {
        var choragiewEntities = choragiewRepository.findAll();
        return choragiewMapper.mapListToDto(choragiewEntities);
    }

    @Override
    public void updateChoragiew(Integer choragiewId, Choragiew updatedChoragiewDTO) {
        // Find the existing entity by ID
        var existingChoragiewEntity = choragiewRepository.findById(choragiewId).orElse(null);

        if (existingChoragiewEntity != null) {
            existingChoragiewEntity.setName(updatedChoragiewDTO.getName());
            existingChoragiewEntity.setAreaOfOperation(updatedChoragiewDTO.getAreaOfOperation());
            existingChoragiewEntity.setPersonInCharge(updatedChoragiewDTO.getPersonInCharge());

            choragiewRepository.save(existingChoragiewEntity);

        }
    }

    @Override
    public void deleteChoragiew(Integer choragiewId) {
        choragiewRepository.deleteById(choragiewId);
    }
}
