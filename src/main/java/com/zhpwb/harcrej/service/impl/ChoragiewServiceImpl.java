package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.ChoragiewMapper;
import com.zhpwb.harcrej.mapper.PersonMapper;
import com.zhpwb.harcrej.model.Choragiew;
import com.zhpwb.harcrej.model.ChoragiewEntity;
import com.zhpwb.harcrej.model.HufiecEntity;
import com.zhpwb.harcrej.respository.ChoragiewRepository;
import com.zhpwb.harcrej.respository.HufiecRepository;
import com.zhpwb.harcrej.respository.UserRepository;
import com.zhpwb.harcrej.service.ChoragiewService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChoragiewServiceImpl implements ChoragiewService {

    private final ChoragiewRepository choragiewRepository;
    private final HufiecRepository hufiecRepository;
    private final UserRepository userRepository;
    private final ChoragiewMapper choragiewMapper;
    private final PersonMapper personMapper;

    @Override
    @Transactional
    public void createChoragiew(Choragiew choragiew) {
        var choragiewEntity = choragiewMapper.mapToEntity(choragiew);

        if (choragiew.getKomendantChoragwi() != null) {
            var komendantChoragwiEntity = personMapper.mapToEntity(choragiew.getKomendantChoragwi());

            if (komendantChoragwiEntity.getUserId() == null) {
                userRepository.save(komendantChoragwiEntity);
            }
            choragiewEntity.setKomendantChoragwi(komendantChoragwiEntity);
        }
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
            var updatedEntity = choragiewMapper.mapToEntity(updatedChoragiewDTO);

            existingChoragiewEntity.setCountry(updatedEntity.getCountry());
            existingChoragiewEntity.setKomendantChoragwi(updatedEntity.getKomendantChoragwi());
            existingChoragiewEntity.setHufce(updatedEntity.getHufce());

            choragiewRepository.save(existingChoragiewEntity);

        }
    }

    @Override
    public void deleteChoragiew(Integer choragiewId) {
        choragiewRepository.deleteById(choragiewId);
    }

    @Override
    public void linkHufiecToChoragiew(Integer choragiewId, Integer hufiecId) {
        ChoragiewEntity choragiew = choragiewRepository.findById(choragiewId)
                .orElseThrow(() -> new EntityNotFoundException("Choragiew not found"));
        HufiecEntity hufiec = hufiecRepository.findById(hufiecId)
                .orElseThrow(() -> new EntityNotFoundException("Hufiec not found"));

        hufiec.setChoragiew(choragiew);
        choragiew.getHufce().add(hufiec);

        hufiecRepository.save(hufiec);
        choragiewRepository.save(choragiew);
    }
}
