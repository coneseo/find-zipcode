package com.example.demo.repository;

import com.example.demo.domain.PostInfo;
import com.example.demo.domain.QPostInfo;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostInfoRepositoryCustomImpl extends QuerydslRepositorySupport implements PostInfoRepositoryCustom{


    public PostInfoRepositoryCustomImpl() {
        super(PostInfo.class);
    }

    @Override
    public Map<String, Object> getPostInfos(String searchWord, int start, int limit) {
        QPostInfo qPostInfo = QPostInfo.postInfo;
        JPQLQuery<PostInfo> jpqlQuery = getPostInfoJPQLQuery(qPostInfo, searchWord);

        jpqlQuery.orderBy(qPostInfo.id.desc());
        jpqlQuery.offset(start).limit(limit);
        Long count = jpqlQuery.fetchCount();
        List<PostInfo> searchResults = jpqlQuery.fetch();
        Map<String, Object> result = new HashMap<>();
        result.put("totalCount", count);
        result.put("results", searchResults);

        return result;
    }

    @Override
    public Map<String, Object> getPostInfoByDongAndBuilding(String searchWord1, String searchWord2, int start, int limit) {
        QPostInfo qPostInfo = QPostInfo.postInfo;
        JPQLQuery<PostInfo> jpqlQuery = getDualPostInfoJPQLQuery(qPostInfo, searchWord1, searchWord2);
        jpqlQuery.orderBy(qPostInfo.id.desc());
        jpqlQuery.offset(start).limit(limit);
        Long count = jpqlQuery.fetchCount();
        List<PostInfo> searchResults = jpqlQuery.fetch();
        Map<String, Object> result = new HashMap<>();
        result.put("totalCount", count);
        result.put("results", searchResults);

        return result;
    }

    private JPQLQuery<PostInfo> getDualPostInfoJPQLQuery(QPostInfo qPostInfo, String searchWord1, String searchWord2) {
        JPQLQuery<PostInfo> jpqlQuery = from(qPostInfo).distinct();
        char lastChar = searchWord1.charAt(searchWord1.length() - 1);
        if(searchWord1 != null && searchWord2 != null && lastChar == '동'){
            jpqlQuery.where(qPostInfo.dongname.like(searchWord1+"%")
            .and(qPostInfo.sigunguBnum.like(searchWord2+"%")));
        }else if(searchWord1 != null && searchWord2 != null && lastChar == '로'){
            jpqlQuery.where(qPostInfo.roadname.like(searchWord1+"%")
                    .and(qPostInfo.sigunguBnum.like(searchWord2+"%")));
        }else{
            jpqlQuery.where(qPostInfo.dongname.like(searchWord1+"%")
                    .or(qPostInfo.roadname.like(searchWord2+"%"))
                    .and(qPostInfo.sigunguBnum.like(searchWord2+"%")));
        }

        return jpqlQuery;
    }


    private JPQLQuery<PostInfo> getPostInfoJPQLQuery(QPostInfo qPostInfo, String searchWord) {
        JPQLQuery<PostInfo> jpqlQuery = from(qPostInfo).distinct();

        if(searchWord != null){
            jpqlQuery.where(qPostInfo.dongname.like(searchWord+"%")
            .or(qPostInfo.roadname.like(searchWord+"%")
            .or(qPostInfo.eupmyun.like(searchWord+"%")
            .or(qPostInfo.sigunguBnum.like(searchWord+"%"))
            .or(qPostInfo.postNum.like(searchWord+"%")))));
        }

        return jpqlQuery;
    }


}
