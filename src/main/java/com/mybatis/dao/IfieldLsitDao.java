package com.mybatis.dao;

import com.mybatis.domain.fieldList;

import java.util.List;

public interface IfieldLsitDao {
    List<fieldList> findSubfieldListByUid(String Uid);
}
