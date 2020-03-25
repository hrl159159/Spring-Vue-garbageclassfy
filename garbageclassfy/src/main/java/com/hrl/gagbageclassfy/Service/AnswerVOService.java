package com.hrl.gagbageclassfy.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface AnswerVOService {

    IPage<com.hrl.gagbageclassfy.VO.AnswerVO> findAll(Page page);
}
