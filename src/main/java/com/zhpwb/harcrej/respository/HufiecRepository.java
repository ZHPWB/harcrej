package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.model.HufiecEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HufiecRepository extends CrudRepository<HufiecEntity, Integer> {
}
