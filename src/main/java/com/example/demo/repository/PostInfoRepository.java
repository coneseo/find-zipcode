package com.example.demo.repository;

import com.example.demo.domain.PostInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostInfoRepository extends JpaRepository<PostInfo, Long>, PostInfoRepositoryCustom {
    @Query("SELECT distinct p FROM PostInfo p WHERE p.postNum = :postnum")
    public PostInfo getPostInfoByPostNum(@Param("postnum") String postnum);

    @Query("SELECT p FROM PostInfo p WHERE p.eupmyun LIKE :searchWord%")
    public List<PostInfo> getPostInfoByEup(@Param("searchWord") String searchWord );

    @Query("SELECT p FROM PostInfo p WHERE p.dongname LIKE :searchWord% or p.eupmyun LIKE :searchWord% or p.roadname LIKE :searchWord%")
    public List<PostInfo> getPostInfoBydong(@Param("searchWord") String searchWord, Pageable pageable);
}
