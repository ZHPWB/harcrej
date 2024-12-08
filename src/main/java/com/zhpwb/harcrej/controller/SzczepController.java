package com.zhpwb.harcrej.controller;

import com.zhpwb.harcrej.api.SzczepApi;
import com.zhpwb.harcrej.model.Szczep;
import com.zhpwb.harcrej.service.SzczepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasRole('ADMIN') or hasRole('KOMENDANT_CHORAGWI') or hasRole('HUFCOWY') or hasRole('SZCZEPOWY')")
public class SzczepController implements SzczepApi {
    private final SzczepService szczepService;

    @Override
    @PreAuthorize("hasAuthority('szczepowy:read')")
    public ResponseEntity<Szczep> getSzczepById(Integer szczepId) {
        var szczep = szczepService.getSzczepById(szczepId);
        return new ResponseEntity<>(szczep, HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasAuthority('hufcowy:read')")
    public ResponseEntity<List<Szczep>> getListOfSzczep() {
        var druzyny = szczepService.getListOfSzczepy();
        return new ResponseEntity<>(druzyny, HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasAuthority('hufcowy:create')")
    public ResponseEntity<Void> postSzczep(Szczep szczep) {
        szczepService.createSzczep(szczep);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PreAuthorize("hasAuthority('szczepowy:update')")
    public ResponseEntity<Void> updateSzczep(Integer szczepId, Szczep updatedSzczep) {
        szczepService.updateSzczep(szczepId, updatedSzczep);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @PreAuthorize("hasAuthority('hufcowy:delete')")
    public ResponseEntity<Void> deleteSzczep(Integer szczepId) {
        szczepService.deleteSzczep(szczepId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> linkDruzynaToSzczep(Integer szczepId, Integer druzynaId) {
        szczepService.linkDruzynaToSzczep(szczepId, druzynaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
