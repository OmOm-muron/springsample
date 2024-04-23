package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.Diary;

@Mapper
public interface DiaryMapper {
    @Select("SELECT * FROM diary")
    List<Diary> getAllDiary();

    @Select("SELECT * FROM diary WHERE id = #{id}")
    Diary getDiary(Long id);

    @Insert("INSERT INTO diary(title, content, upddate) VALUES(#{title}, #{content}, #{upddate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertDiary(Diary diary);

    @Update("UPDATE diary SET title = #{title}, content = #{content}, upddate = #{upddate} WHERE id = #{id}")
    void updateDiary(Diary diary);

    @Delete("DELETE FROM diary WHERE id = #{id}")
    void deleteDiary(Long id);
}
