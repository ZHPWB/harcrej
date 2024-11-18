package com.zhpwb.harcrej.controller;

import com.zhpwb.harcrej.api.RejestracjeApi;
import com.zhpwb.harcrej.model.Rejestracje;
import com.zhpwb.harcrej.service.RejestracjeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RejestracjeController implements RejestracjeApi {

    private final RejestracjeService rejestracjeService;


    @Override
    public ResponseEntity<List<Rejestracje>> getAllRejestracje() {
        var allRejestracje = rejestracjeService.getAllRejestracje();
        return new ResponseEntity<>(allRejestracje, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Rejestracje>> getHufiecRejestracje(Integer hufiecId) {
        var hufiecRejestracje = rejestracjeService.getHufiecRejestracje(hufiecId);
        return new ResponseEntity<>(hufiecRejestracje, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Rejestracje>> getSzczepRejestracje(Integer szczepId) {
        var szczepRejestracje = rejestracjeService.getSzczepRejestracje(szczepId);
        return new ResponseEntity<>(szczepRejestracje, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Rejestracje> getDruzynaRejestracje(Integer druzynaId) {
        var druzynaRejestracje = rejestracjeService.getDruzynaRejestracje(druzynaId);
        return new ResponseEntity<>(druzynaRejestracje, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Void> postHufiecRejestracje(Integer hufiecId, Rejestracje rejestracje) {
        rejestracjeService.createHufiecRejestracje(hufiecId, rejestracje);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> postSzczepRejestracje(Integer szczepId, Rejestracje rejestracje) {
        rejestracjeService.createSzczepRejestracje(szczepId, rejestracje);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> postDruzynaRejestracje(Integer druzynaId, Rejestracje rejestracje) {
        rejestracjeService.createDruzynaRejestracje(druzynaId, rejestracje);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
