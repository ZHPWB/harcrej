package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.WedrownicyMapper;
import com.zhpwb.harcrej.model.Wedrownicy;
import com.zhpwb.harcrej.respository.WedrownicyRepository;
import com.zhpwb.harcrej.service.WedrownicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WedrownicyServiceImpl implements WedrownicyService {

    private final WedrownicyRepository wedrownicyRepository;
    private final WedrownicyMapper wedrownicyMapper;

    @Override
    public void createWedrownicy(Wedrownicy wedrownicy) {
        var wedrownicyEntity = wedrownicyMapper.mapToEntity(wedrownicy);
        wedrownicyRepository.save(wedrownicyEntity);
    }

    @Override
    public Wedrownicy getWedrownicyById(Integer wedrownicyId) {
        return wedrownicyMapper.mapToDto(wedrownicyRepository.findById(wedrownicyId).orElse(null));
    }

    @Override
    public List<Wedrownicy> getListOfWedrownicy() {
        var wedrownicyEntities = wedrownicyRepository.findAll();
        return wedrownicyMapper.mapListToDto(wedrownicyEntities);
    }

    @Override
    public void updateWedrownicy(Integer wedrownicyId, Wedrownicy updatedWedrownicyDTO) {
        // Find the existing entity by ID
        var existingWedrownicyEntity = wedrownicyRepository.findById(wedrownicyId).orElse(null);

        if (existingWedrownicyEntity != null) {
            existingWedrownicyEntity.setName(updatedWedrownicyDTO.getName());
            existingWedrownicyEntity.setAreaOfOperation(updatedWedrownicyDTO.getAreaOfOperation());
            existingWedrownicyEntity.setPersonInCharge(updatedWedrownicyDTO.getPersonInCharge());

            wedrownicyRepository.save(existingWedrownicyEntity);

        }
    }

    @Override
    public void deleteWedrownicy(Integer wedrownicyId) {
        wedrownicyRepository.deleteById(wedrownicyId);
    }
}
