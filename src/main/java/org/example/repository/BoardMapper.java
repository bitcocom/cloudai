package org.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Board;

import java.util.List;

//@Mapper
public interface BoardMapper { // public class  SqlSessionFactoryBean  implements BoardMapper

    // 전체게시물을 가져오는 기능(TDD)
    public List<Board> boardList();
    public int boardInsert(Board board); // 1, 0
    public  int boardDelete(Long num);

}
