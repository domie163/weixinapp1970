package com.entity.view;

import com.entity.XueshuleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学术类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-07 19:22:55
 */
@TableName("xueshuleixing")
public class XueshuleixingView  extends XueshuleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueshuleixingView(){
	}
 
 	public XueshuleixingView(XueshuleixingEntity xueshuleixingEntity){
 	try {
			BeanUtils.copyProperties(this, xueshuleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
