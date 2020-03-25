package com.hrl.gagbageclassfy.Service;

import com.hrl.gagbageclassfy.Entity.PaperManage;

import java.util.List;

public interface PaperManageService {


    List<PaperManage> findAll();

    int add(PaperManage paperManage);
}
