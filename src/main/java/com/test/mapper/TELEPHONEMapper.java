package com.test.mapper;

import com.test.pojo.TELEPHONE;
import java.util.List;

public interface TELEPHONEMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TELEPHONE record);

    TELEPHONE selectByPrimaryKey(Integer id);

    List<TELEPHONE> selectAll();

    int updateByPrimaryKey(TELEPHONE record);
}