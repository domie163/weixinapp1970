package com.dao;

import com.entity.YantaoxueshuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YantaoxueshuVO;
import com.entity.view.YantaoxueshuView;


/**
 * 研讨学术
 * 
 * @author 
 * @email 
 * @date 2023-02-07 19:22:55
 */
public interface YantaoxueshuDao extends BaseMapper<YantaoxueshuEntity> {
	
	List<YantaoxueshuVO> selectListVO(@Param("ew") Wrapper<YantaoxueshuEntity> wrapper);
	
	YantaoxueshuVO selectVO(@Param("ew") Wrapper<YantaoxueshuEntity> wrapper);
	
	List<YantaoxueshuView> selectListView(@Param("ew") Wrapper<YantaoxueshuEntity> wrapper);

	List<YantaoxueshuView> selectListView(Pagination page,@Param("ew") Wrapper<YantaoxueshuEntity> wrapper);
	
	YantaoxueshuView selectView(@Param("ew") Wrapper<YantaoxueshuEntity> wrapper);
	

}
