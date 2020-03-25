package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.hrl.gagbageclassfy.DAO.PaperManageDAO;
import com.hrl.gagbageclassfy.Entity.PaperManage;
import com.hrl.gagbageclassfy.Service.PaperManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaperManageServiceImpl implements PaperManageService {
    @Autowired
    private PaperManageDAO paperManageDAO;
    @Override
    public List<PaperManage> findAll() {
        return paperManageDAO.findAll();
    }

    @Override
    public int add(PaperManage paperManage) {
        return paperManageDAO.add(paperManage);
    }
}
