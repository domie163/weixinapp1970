package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YantaoxueshuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YantaoxueshuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YantaoxueshuView;


/**
 * 研讨学术
 *
 * @author 
 * @email 
 * @date 2023-02-07 19:22:55
 */
public interface YantaoxueshuService extends IService<YantaoxueshuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YantaoxueshuVO> selectListVO(Wrapper<YantaoxueshuEntity> wrapper);
   	
   	YantaoxueshuVO selectVO(@Param("ew") Wrapper<YantaoxueshuEntity> wrapper);
   	
   	List<YantaoxueshuView> selectListView(Wrapper<YantaoxueshuEntity> wrapper);
   	
   	YantaoxueshuView selectView(@Param("ew") Wrapper<YantaoxueshuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YantaoxueshuEntity> wrapper);
   	

}

