package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.model.GromadaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GromadaRepository extends CrudRepository<GromadaEntity, Integer> {
}
