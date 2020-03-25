package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.hrl.gagbageclassfy.DAO.ScoreDAO;
import com.hrl.gagbageclassfy.Entity.Score;
import com.hrl.gagbageclassfy.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreDAO scoreDAO;
    @Override
    public int add(Score score) {
        return scoreDAO.add(score);
    }

    @Override
    public List<Score> findAll() {
        return scoreDAO.findAll();
    }

    @Override
    public List<Score> findById(Integer studentId) {
        return scoreDAO.findById(studentId);
    }
}
