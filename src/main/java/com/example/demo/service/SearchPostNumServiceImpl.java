package com.example.demo.service;

import com.example.demo.domain.PostInfo;
import com.example.demo.repository.PostInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SearchPostNumServiceImpl implements SearchPostNumService {

    private final PostInfoRepository postInfoRepository;

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> searchPostInfo(String searchWord, int page) {
        int limit = 20;
        int start = page * limit - limit;

        return postInfoRepository.getPostInfos(searchWord, start, limit);
    }


    @Override
    @Transactional
    public List<PostInfo> searchTest(String searchWord, int page) {

        int start = page * 10 - 10;
        Pageable pageable = PageRequest.of(start,10);
        return postInfoRepository.getPostInfoBydong(searchWord, pageable);
    }

    @Override
    public Map<String, Object> searchDongAndBuilding(String[] searchWords, int page) {
        String searchWord1 =searchWords[0];
        String searchWord2 =searchWords[1];
        int limit = 20;
        int start = page * limit - limit;

        return postInfoRepository.getPostInfoByDongAndBuilding(searchWord1, searchWord2, start,limit);

    }


}
