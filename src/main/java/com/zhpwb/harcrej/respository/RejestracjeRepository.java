package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.model.RejestracjeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RejestracjeRepository extends CrudRepository<RejestracjeEntity, Integer> {

    List<RejestracjeEntity> findAllByHufiecId(Integer hufiecId);
    List<RejestracjeEntity> findAllBySzczepId(Integer szczepId);
}
