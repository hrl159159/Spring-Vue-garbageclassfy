package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.DAO.HazardousDAO;
import com.hrl.gagbageclassfy.Entity.Hazardous;
import com.hrl.gagbageclassfy.Entity.Householdfood;
import com.hrl.gagbageclassfy.Entity.Recyclable;
import com.hrl.gagbageclassfy.Entity.Residual;
import com.hrl.gagbageclassfy.Service.HazardousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HazardousServiceImpl implements HazardousService {
    @Autowired
    private HazardousDAO hazardousDAO;


    @Override
    public IPage<Recyclable> findAllRecylable(Page page) {
        return hazardousDAO.findAllRecylable(page);
    }

    @Override
    public IPage<Hazardous> findAllHazardous(Page page) {
        return hazardousDAO.findAllHazardous(page);
    }

    @Override
    public IPage<Householdfood> findAllhousehold(Page page) {
        return hazardousDAO.findAllhousehold(page);
    }

    @Override
    public IPage<Residual> findAllresidual(Page page) {
        return hazardousDAO.findAllresidual(page);
    }

    @Override
    public List<Recyclable> findByRecylableName(String name) {
        return hazardousDAO.findByRecylableName(name);
    }

    @Override
    public List<Hazardous> findByHazardousName(String name) {
        return hazardousDAO.findByHazardousName(name);
    }

    @Override
    public List<Householdfood> findByhouseholdName(String name) {
        return hazardousDAO.findByhouseholdName(name);
    }

    @Override
    public List<Residual> findByresidualName(String name) {
        return hazardousDAO.findByresidualName(name);
    }
}
