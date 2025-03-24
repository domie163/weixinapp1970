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


import com.dao.XueshuleixingDao;
import com.entity.XueshuleixingEntity;
import com.service.XueshuleixingService;
import com.entity.vo.XueshuleixingVO;
import com.entity.view.XueshuleixingView;

@Service("xueshuleixingService")
public class XueshuleixingServiceImpl extends ServiceImpl<XueshuleixingDao, XueshuleixingEntity> implements XueshuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshuleixingEntity> page = this.selectPage(
                new Query<XueshuleixingEntity>(params).getPage(),
                new EntityWrapper<XueshuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshuleixingEntity> wrapper) {
		  Page<XueshuleixingView> page =new Query<XueshuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshuleixingVO> selectListVO(Wrapper<XueshuleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshuleixingVO selectVO(Wrapper<XueshuleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshuleixingView> selectListView(Wrapper<XueshuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshuleixingView selectView(Wrapper<XueshuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
