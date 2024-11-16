package com.zhpwb.harcrej.controller;

import com.zhpwb.harcrej.api.SzczepApi;
import com.zhpwb.harcrej.model.Szczep;
import com.zhpwb.harcrej.service.SzczepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@Slf4j
public class SzczepController implements SzczepApi {
    private final SzczepService szczepService;

    @Override
    public ResponseEntity<Szczep> getSzczepById(Integer szczepId) {
        var szczep = szczepService.getSzczepById(szczepId);
        return new ResponseEntity<>(szczep, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Szczep>> getListOfSzczep() {
        var druzyny = szczepService.getListOfSzczepy();
        return new ResponseEntity<>(druzyny, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postSzczep(Szczep szczep) {
        szczepService.createSzczep(szczep);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateSzczep(Integer szczepId, Szczep updatedSzczep) {
        szczepService.updateSzczep(szczepId, updatedSzczep);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteSzczep(Integer szczepId) {
        szczepService.deleteSzczep(szczepId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
