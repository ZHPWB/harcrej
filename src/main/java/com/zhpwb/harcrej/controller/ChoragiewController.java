package com.zhpwb.harcrej.controller;

import com.zhpwb.harcrej.api.ChoragiewApi;
import com.zhpwb.harcrej.model.Choragiew;
import com.zhpwb.harcrej.service.ChoragiewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN') or hasRole('KOMENDANT_CHORAGWI')")
public class ChoragiewController implements ChoragiewApi {

    private final ChoragiewService choragiewService;

    @Override
    @PreAuthorize("hasAuthority('komendantChoragwi:read')")
    public ResponseEntity<Choragiew> getChoragiewById(Integer choragiewId) {
        var choragiew = choragiewService.getChoragiewById(choragiewId);
        return new ResponseEntity<>(choragiew, HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<Choragiew>> getListOfChoragwi() {
        var druzyny = choragiewService.getListOfChoragwi();
        return new ResponseEntity<>(druzyny, HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Void> postChoragiew(Choragiew choragiew) {
        choragiewService.createChoragiew(choragiew);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PreAuthorize("hasAuthority('komendantChoragwi:update')")
    public ResponseEntity<Void> updateChoragiew(Integer choragiewId, Choragiew updatedChoragiew) {
        choragiewService.updateChoragiew(choragiewId, updatedChoragiew);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<Void> deleteChoragiew(Integer choragiewId) {
        choragiewService.deleteChoragiew(choragiewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    //todo: think about permissions here
    public ResponseEntity<Void> linkHufiecToChoragiew(Integer choragiewId, Integer hufiecId) {
        choragiewService.linkHufiecToChoragiew(choragiewId, hufiecId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

