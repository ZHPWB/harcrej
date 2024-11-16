package com.zhpwb.harcrej.controller;

import com.zhpwb.harcrej.api.GromadaApi;
import com.zhpwb.harcrej.model.Gromada;
import com.zhpwb.harcrej.service.GromadaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GromadaController implements GromadaApi {

    private final GromadaService gromadaService;

    @Override
    public ResponseEntity<Gromada> getGromadaById(Integer gromadaId) {
        var gromada = gromadaService.getGromadaById(gromadaId);
        return new ResponseEntity<>(gromada, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Gromada>> getListOfGromady() {
        var druzyny = gromadaService.getListOfGromady();
        return new ResponseEntity<>(druzyny, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postGromada(Gromada gromada) {
        gromadaService.createGromada(gromada);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateGromada(Integer gromadaId, Gromada updatedGromada) {
        gromadaService.updateGromada(gromadaId, updatedGromada);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteGromada(Integer gromadaId) {
        gromadaService.deleteGromada(gromadaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
