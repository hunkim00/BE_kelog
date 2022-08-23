package com.kelog.kelog.repository;

import com.kelog.kelog.domain.Post;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAndTitleContainsOrContentContainsOrderByCreatedAtDesc(String title, String content, Pageable pageable);

    // 내 게시물 조회
    @Query("select DISTINCT p from Post p join fetch p.tags t join fetch p.member m  where p.member.id = :memberId")
    List<Post> findAllByMyPage(Long memberId);

    // 전체조회
    @Query("select p from Post p join fetch p.member")
    List<Post> findAllByPaging(PageRequest createdAt);


    // 회원 게시물 조회
    @Query("select p from Post p " +
            "join fetch p.member m " +
            "where p.member.id = :memberId  "
             )
    List<Post> findAllMemberId(Long memberId, Pageable pageable);

}
