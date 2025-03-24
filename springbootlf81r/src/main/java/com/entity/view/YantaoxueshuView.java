package com.entity.view;

import com.entity.YantaoxueshuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 研讨学术
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-07 19:22:55
 */
@TableName("yantaoxueshu")
public class YantaoxueshuView  extends YantaoxueshuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YantaoxueshuView(){
	}
 
 	public YantaoxueshuView(YantaoxueshuEntity yantaoxueshuEntity){
 	try {
			BeanUtils.copyProperties(this, yantaoxueshuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
