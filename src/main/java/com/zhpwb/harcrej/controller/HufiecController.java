package com.zhpwb.harcrej.controller;

import com.zhpwb.harcrej.api.HufiecApi;
import com.zhpwb.harcrej.model.Hufiec;
import com.zhpwb.harcrej.service.HufiecService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@Slf4j
public class HufiecController implements HufiecApi {
    private final HufiecService hufiecService;

    @Override
    public ResponseEntity<Hufiec> getHufiecById(Integer hufiecId) {
        var hufiec = hufiecService.getHufiecById(hufiecId);
        return new ResponseEntity<>(hufiec, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Hufiec>> getListOfHufce() {
        var druzyny = hufiecService.getListOfHufce();
        return new ResponseEntity<>(druzyny, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postHufiec(Hufiec hufiec) {
        hufiecService.createHufiec(hufiec);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateHufiec(Integer hufiecId, Hufiec updatedHufiec) {
        hufiecService.updateHufiec(hufiecId, updatedHufiec);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
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
