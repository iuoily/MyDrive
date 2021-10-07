package com.iuoly.dao;

import com.iuoly.entity.Files;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FileDao {
    /**
     * 查询文件列表信息
     * @return 所有文件的列表
     */
    @Select("select * from files")
    List<Files> AllFile();

    /**
     * 保存文件信息
     * @param file
     * @return
     */
    @Insert("insert into files(fname, fsize, uploader) values(#{fname}, #{fsize}, #{uploader})")
    int save(Files file);


}
