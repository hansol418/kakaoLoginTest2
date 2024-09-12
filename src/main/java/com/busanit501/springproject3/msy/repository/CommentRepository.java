package com.busanit501.springproject3.msy.repository;
//
import com.busanit501.springproject3.msy.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardId(Long itemId);
}
