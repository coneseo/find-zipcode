package com.example.demo.controller;

import com.example.demo.domain.PostInfo;
import com.example.demo.service.SearchPostNumService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SearchPostInfoAPIController {
    private final SearchPostNumService searchPostNumService;

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> getPostInfos(@RequestParam(name = "searchWord") String searchWord,
                                      @RequestParam(name = "page" , defaultValue = "1") int page){

        Map<String, Object> results;
        if (searchWord.contains(" ")) {
            String[] arr = searchWord.split(" ");
                results = searchPostNumService.searchDongAndBuilding(arr, page);
        }else {
             results = searchPostNumService.searchPostInfo(searchWord, page);
        }

        if(results.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(results, HttpStatus.OK);
    }
}
