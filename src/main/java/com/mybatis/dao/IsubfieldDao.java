package com.mybatis.dao;

import com.mybatis.domain.fieldList;
import com.mybatis.domain.subfield;

import java.util.List;

public interface IsubfieldDao {
    subfield findSubfieldByTitle(String title);
}