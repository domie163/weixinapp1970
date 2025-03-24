package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshuleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshuleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshuleixingView;


/**
 * 学术类型
 *
 * @author 
 * @email 
 * @date 2023-02-07 19:22:55
 */
public interface XueshuleixingService extends IService<XueshuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshuleixingVO> selectListVO(Wrapper<XueshuleixingEntity> wrapper);
   	
   	XueshuleixingVO selectVO(@Param("ew") Wrapper<XueshuleixingEntity> wrapper);
   	
   	List<XueshuleixingView> selectListView(Wrapper<XueshuleixingEntity> wrapper);
   	
   	XueshuleixingView selectView(@Param("ew") Wrapper<XueshuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshuleixingEntity> wrapper);
   	

}

