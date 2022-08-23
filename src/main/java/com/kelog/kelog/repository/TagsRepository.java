package com.kelog.kelog.repository;

import com.kelog.kelog.domain.Post;
import com.kelog.kelog.domain.Tags;
import com.kelog.kelog.tag.TagNameAndCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagsRepository extends JpaRepository<Tags, Long> {



    // 유저 마이페이지 태그 정보
    @Query("select new com.kelog.kelog.tag.TagNameAndCount(t.post.member.id, t.tagId, t.tagName,t.post ,count(t.tagName)) " +
            "from Tags t " +
            "where t.post.member.id =:memberId  " +
            "group by t.tagName order by count(t.tagName) desc ")
    List<TagNameAndCount> findAll(Long memberId);

    // 중복 태그
    Tags findTagsByTagNameAndPost(String tagName, Post post);

    // 디테일 , 업데이트, 딜리트 태그 정보
    List<Tags> findAllByPost(Post post);

    // 태그 검색
    List<Tags> findAllByTagName(String tagName);

    //수정
    void deleteByPost(Post post);

}
