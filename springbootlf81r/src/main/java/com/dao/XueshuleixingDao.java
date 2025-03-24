package com.dao;

import com.entity.XueshuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshuleixingVO;
import com.entity.view.XueshuleixingView;


/**
 * 学术类型
 * 
 * @author 
 * @email 
 * @date 2023-02-07 19:22:55
 */
public interface XueshuleixingDao extends BaseMapper<XueshuleixingEntity> {
	
	List<XueshuleixingVO> selectListVO(@Param("ew") Wrapper<XueshuleixingEntity> wrapper);
	
	XueshuleixingVO selectVO(@Param("ew") Wrapper<XueshuleixingEntity> wrapper);
	
	List<XueshuleixingView> selectListView(@Param("ew") Wrapper<XueshuleixingEntity> wrapper);

	List<XueshuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<XueshuleixingEntity> wrapper);
	
	XueshuleixingView selectView(@Param("ew") Wrapper<XueshuleixingEntity> wrapper);
	

}
