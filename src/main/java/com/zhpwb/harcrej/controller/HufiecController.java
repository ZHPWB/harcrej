package com.zhpwb.harcrej.controller;

import com.zhpwb.harcrej.api.HufiecApi;
import com.zhpwb.harcrej.model.Hufiec;
import com.zhpwb.harcrej.service.HufiecService;
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
@PreAuthorize("hasRole('ADMIN') or hasRole('KOMENDANT_CHORAGWI') or hasRole('HUFCOWY') ")
public class HufiecController implements HufiecApi {
    private final HufiecService hufiecService;

    @Override
    @PreAuthorize("hasAuthority('hufcowy:read')")
    public ResponseEntity<Hufiec> getHufiecById(Integer hufiecId) {
        var hufiec = hufiecService.getHufiecById(hufiecId);
        return new ResponseEntity<>(hufiec, HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasAuthority('komendantChoragwi:read')")
    public ResponseEntity<List<Hufiec>> getListOfHufce() {
        var druzyny = hufiecService.getListOfHufce();
        return new ResponseEntity<>(druzyny, HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasAuthority('komendantChoragwi:create')")
    public ResponseEntity<Void> postHufiec(Hufiec hufiec) {
        hufiecService.createHufiec(hufiec);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PreAuthorize("hasAuthority('hufcowy:update')")
    public ResponseEntity<Void> updateHufiec(Integer hufiecId, Hufiec updatedHufiec) {
        hufiecService.updateHufiec(hufiecId, updatedHufiec);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @PreAuthorize("hasAuthority('komendantChoragwi:delete') ")
    public ResponseEntity<Void> deleteHufiec(Integer hufiecId) {
        hufiecService.deleteHufiec(hufiecId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> linkSzczepToHufiec(Integer hufiecId, Integer szczepId) {
        hufiecService.linkSzczepToHufiec(hufiecId, szczepId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
