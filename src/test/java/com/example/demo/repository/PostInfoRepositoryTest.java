package com.example.demo.repository;

import com.example.demo.domain.PostInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PostInfoRepositoryTest {
    @Autowired
    private PostInfoRepository postInfoRepository;

    @Test
    public void 검색테스트(){
       Map<String, Object> postInfos = postInfoRepository.getPostInfos("양평동",0,5);
       List<PostInfo> postInfos1 = (List<PostInfo>) postInfos.get("results");
//       for(PostInfo p : postInfos1){
//            System.out.println(p.getDongname()+" "+p.getSido()+" "+p.getPostNum()+" "+p.getSigunguBnum());
//        }
        Assert.assertNotNull(postInfos);
    }

    @Test
    public void 여러개검색(){
        List<PostInfo> postInfos = postInfoRepository.getPostInfoByEup("화천");
        for(PostInfo p : postInfos){
            System.out.println("시도 : "+p.getSido()+"동/읍 : "+p.getDongname()+"우편번호 : "+p.getPostNum());
        }
    }

    @Test
    public void 검색_테스트(){
        Pageable page = PageRequest.of(1,10);
        List<PostInfo> postInfos = postInfoRepository.getPostInfoBydong("양평로", page);
        for(PostInfo p : postInfos){
            System.out.println("시도 : "+p.getSido()+"동/읍 : "+p.getDongname()+"우편번호 : "+p.getPostNum());
        }
    }
}