package com.example.demo.controller;

import com.example.demo.domain.PostInfo;
import com.example.demo.service.SearchPostNumService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestAPIController {
    @Autowired
    SearchPostNumService searchPostNumService;


    @GetMapping
    public ResponseEntity<List<PostInfo>> getTest(@RequestParam(name = "searchWord") String searchWord,
                                                  @RequestParam(name = "page")int page){


        List<PostInfo> postInfos = searchPostNumService.searchTest(searchWord , page);

        if(postInfos.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(postInfos, HttpStatus.OK);
    }
}
