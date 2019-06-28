package com.example.demo.repository;


import java.util.Map;

public interface PostInfoRepositoryCustom {
    Map<String, Object> getPostInfos(String searchWord, int start, int limit);

    Map<String, Object> getPostInfoByDongAndBuilding(String searchWord1, String searchWord2, int start, int limit);
}
