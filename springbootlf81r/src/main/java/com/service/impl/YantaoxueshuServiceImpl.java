package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YantaoxueshuDao;
import com.entity.YantaoxueshuEntity;
import com.service.YantaoxueshuService;
import com.entity.vo.YantaoxueshuVO;
import com.entity.view.YantaoxueshuView;

@Service("yantaoxueshuService")
public class YantaoxueshuServiceImpl extends ServiceImpl<YantaoxueshuDao, YantaoxueshuEntity> implements YantaoxueshuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YantaoxueshuEntity> page = this.selectPage(
                new Query<YantaoxueshuEntity>(params).getPage(),
                new EntityWrapper<YantaoxueshuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YantaoxueshuEntity> wrapper) {
		  Page<YantaoxueshuView> page =new Query<YantaoxueshuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YantaoxueshuVO> selectListVO(Wrapper<YantaoxueshuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YantaoxueshuVO selectVO(Wrapper<YantaoxueshuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YantaoxueshuView> selectListView(Wrapper<YantaoxueshuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YantaoxueshuView selectView(Wrapper<YantaoxueshuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
