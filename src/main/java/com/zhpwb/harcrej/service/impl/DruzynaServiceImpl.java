package com.zhpwb.harcrej.service.impl;

import com.zhpwb.harcrej.mapper.DruzynaMapper;
import com.zhpwb.harcrej.mapper.PersonMapper;
import com.zhpwb.harcrej.model.Druzyna;
import com.zhpwb.harcrej.model.User;
import com.zhpwb.harcrej.model.UserEntity;
import com.zhpwb.harcrej.respository.DruzynaRepository;
import com.zhpwb.harcrej.respository.UserRepository;
import com.zhpwb.harcrej.service.DruzynaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DruzynaServiceImpl implements DruzynaService {

    private final DruzynaRepository druzynaRepository;
    private final UserRepository userRepository;
    private final DruzynaMapper druzynaMapper;
    private final PersonMapper personMapper;

    @Override
    @Transactional
    public void createDruzyna(Druzyna druzyna) {
        var druzynaEntity = druzynaMapper.mapToEntity(druzyna);

        if (druzyna.getDruzynowy() != null) {
            var druzynowyEntity = personMapper.mapToEntity(druzyna.getDruzynowy());

            if (druzynowyEntity.getUserId() == null) {
                userRepository.save(druzynowyEntity);
            }
            druzynaEntity.setDruzynowy(druzynowyEntity);
        }

        if (druzyna.getKomenda() != null) {
            List<UserEntity> komendaEntities = new ArrayList<>();
            for (User user : druzyna.getKomenda()) {
                UserEntity userEntity = personMapper.mapToEntity(user);

                if (userEntity.getUserId() == null) {
                    userRepository.save(userEntity);
                }
                komendaEntities.add(userEntity);
            }
            druzynaEntity.setKomenda(komendaEntities);
        }

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
        var existingDruzynaEntity = druzynaRepository.findById(druzynaId).orElse(null);

        if (existingDruzynaEntity != null) {
            var updatedEntity = druzynaMapper.mapToEntity(updatedDruzynaDTO);

            existingDruzynaEntity.setSzczep(updatedEntity.getSzczep());
            existingDruzynaEntity.setName(updatedEntity.getName());
            existingDruzynaEntity.setAddressOfOperation(updatedEntity.getAddressOfOperation());
            existingDruzynaEntity.setDruzynowy(updatedEntity.getDruzynowy());
            existingDruzynaEntity.setType(updatedEntity.getType());
            existingDruzynaEntity.setCurrentStats(updatedEntity.getCurrentStats());
            existingDruzynaEntity.setYearEstablished(updatedEntity.getYearEstablished());

            druzynaRepository.save(existingDruzynaEntity);
        }
    }

    @Override
    public void deleteDruzyna(Integer druzynaId) {
        druzynaRepository.deleteById(druzynaId);
    }
}
