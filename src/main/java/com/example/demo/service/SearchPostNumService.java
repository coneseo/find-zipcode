package com.example.demo.service;

import com.example.demo.domain.PostInfo;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Map;

public interface SearchPostNumService {

     Map<String, Object> searchPostInfo(String searchWord, int page);

     Map<String, Object> searchDongAndBuilding(String[] searchWords, int page);

     List<PostInfo> searchTest(String searchWord, int page);


}
