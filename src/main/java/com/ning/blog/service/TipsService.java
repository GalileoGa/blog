package com.ning.blog.service;

import com.ning.blog.domain.Tips;
import com.ning.blog.repository.TipsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用途：
 * 作者：郭桐宁
 * 时间：2018/9/27 9:51
 * Version:1.0
 */
@Service
public class TipsService {

    @Resource
    private TipsMapper tipsMapper;

    public List<Tips> getTipsByUserId(int userId) {
        return tipsMapper.getTipsByUserId(userId);
    }

    public Tips getTipsById(int id) {
        return tipsMapper.getTipsById(id);
    }

    public int addTips(Tips tips) {
        tips.setLikeNum(0);
        tips.setDislikeNum(0);
        tips.setWeight(0);
        return tipsMapper.insertTips(tips);
    }

    public int deleteTips(int id) {
        return tipsMapper.deleteTips(id);
    }

    public int updateTips(Tips tips) {
        return tipsMapper.updateTips(tips);
    }

}
