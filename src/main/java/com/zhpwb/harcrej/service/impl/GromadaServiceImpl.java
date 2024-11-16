package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.GromadaMapper;
import com.zhpwb.harcrej.model.Gromada;
import com.zhpwb.harcrej.respository.GromadaRepository;
import com.zhpwb.harcrej.service.GromadaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GromadaServiceImpl implements GromadaService {

    private final GromadaRepository gromadaRepository;
    private final GromadaMapper gromadaMapper;

    @Override
    public void createGromada(Gromada gromada) {
        var gromadaEntity = gromadaMapper.mapToEntity(gromada);
        gromadaRepository.save(gromadaEntity);
    }

    @Override
    public Gromada getGromadaById(Integer gromadaId) {
        return gromadaMapper.mapToDto(gromadaRepository.findById(gromadaId).orElse(null));
    }

    @Override
    public List<Gromada> getListOfGromady() {
        var gromadaEntities = gromadaRepository.findAll();
        return gromadaMapper.mapListToDto(gromadaEntities);
    }

    @Override
    public void updateGromada(Integer gromadaId, Gromada updatedGromadaDTO) {
        // Find the existing entity by ID
        var existingGromadaEntity = gromadaRepository.findById(gromadaId).orElse(null);

        if (existingGromadaEntity != null) {
            existingGromadaEntity.setName(updatedGromadaDTO.getName());
            existingGromadaEntity.setAreaOfOperation(updatedGromadaDTO.getAreaOfOperation());
            existingGromadaEntity.setPersonInCharge(updatedGromadaDTO.getPersonInCharge());

            gromadaRepository.save(existingGromadaEntity);

        }
    }

    @Override
    public void deleteGromada(Integer gromadaId) {
        gromadaRepository.deleteById(gromadaId);
    }
}
