package com.example.demo.service;

import com.example.demo.domain.PostInfo;
import com.example.demo.repository.PostInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchPostNumServiceImplTest {


    @Autowired
    SearchPostNumService searchPostNumService;

    @Test
    public void 검색서비스_테스트() {
        Map<String, Object> postInfos = searchPostNumService.searchPostInfo("양평동", 3);


    }


    @Test
    public void 제발좀되라(){
        List<PostInfo> postInfos = searchPostNumService.searchTest("양평동", 3);
        for(PostInfo p : postInfos){
            System.out.println(p.getSido()+"시도"+p.getDongname()+"동"+p.getPostNum()+"우편번호");
        }
    }
}