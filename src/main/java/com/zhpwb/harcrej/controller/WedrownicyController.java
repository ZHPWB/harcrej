package com.zhpwb.harcrej.controller;

import com.zhpwb.harcrej.api.WedrownicyApi;
import com.zhpwb.harcrej.model.Wedrownicy;
import com.zhpwb.harcrej.service.WedrownicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WedrownicyController implements WedrownicyApi {
    private final WedrownicyService wedrownicyService;

    @Override
    public ResponseEntity<Wedrownicy> getWedrownicyById(Integer wedrownicyId) {
        var wedrownicy = wedrownicyService.getWedrownicyById(wedrownicyId);
        return new ResponseEntity<>(wedrownicy, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Wedrownicy>> getListOfWedrownicy() {
        var druzyny = wedrownicyService.getListOfWedrownicy();
        return new ResponseEntity<>(druzyny, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postWedrownicy(Wedrownicy wedrownicy) {
        wedrownicyService.createWedrownicy(wedrownicy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateWedrownicy(Integer wedrownicyId, Wedrownicy updatedWedrownicy) {
        wedrownicyService.updateWedrownicy(wedrownicyId, updatedWedrownicy);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteWedrownicy(Integer wedrownicyId) {
        wedrownicyService.deleteWedrownicy(wedrownicyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
