package com.zhpwb.harcrej.controller;

import com.zhpwb.harcrej.api.DruzynaApi;
import com.zhpwb.harcrej.model.Druzyna;
import com.zhpwb.harcrej.service.DruzynaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DruzynaController implements DruzynaApi {

    private final DruzynaService druzynaService;

    @Override
    public ResponseEntity<Druzyna> getDruzynaById(Integer druzynaId) {
        var druzyna = druzynaService.getDruzynaById(druzynaId);
        return new ResponseEntity<>(druzyna, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Druzyna>> getListOfDruzyna() {
        var druzyny = druzynaService.getListOfDruzyny();
        return new ResponseEntity<>(druzyny, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postDruzyna(Druzyna druzyna) {
        druzynaService.createDruzyna(druzyna);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateDruzyna(Integer druzynaId, Druzyna updatedDruzyna) {
        druzynaService.updateDruzyna(druzynaId, updatedDruzyna);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteDruzyna(Integer druzynaId) {
        druzynaService.deleteDruzyna(druzynaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
