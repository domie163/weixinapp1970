package com.entity.model;

import com.entity.YantaoxueshuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 研讨学术
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-02-07 19:22:55
 */
public class YantaoxueshuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 学术类型
	 */
	
	private String xueshuleixing;
		
	/**
	 * 研究对象
	 */
	
	private String yanjiuduixiang;
		
	/**
	 * 报告内容
	 */
	
	private String baogaoneirong;
		
	/**
	 * 报告地点
	 */
	
	private String baogaodidian;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 报告人
	 */
	
	private String xingming;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：学术类型
	 */
	 
	public void setXueshuleixing(String xueshuleixing) {
		this.xueshuleixing = xueshuleixing;
	}
	
	/**
	 * 获取：学术类型
	 */
	public String getXueshuleixing() {
		return xueshuleixing;
	}
				
	
	/**
	 * 设置：研究对象
	 */
	 
	public void setYanjiuduixiang(String yanjiuduixiang) {
		this.yanjiuduixiang = yanjiuduixiang;
	}
	
	/**
	 * 获取：研究对象
	 */
	public String getYanjiuduixiang() {
		return yanjiuduixiang;
	}
				
	
	/**
	 * 设置：报告内容
	 */
	 
	public void setBaogaoneirong(String baogaoneirong) {
		this.baogaoneirong = baogaoneirong;
	}
	
	/**
	 * 获取：报告内容
	 */
	public String getBaogaoneirong() {
		return baogaoneirong;
	}
				
	
	/**
	 * 设置：报告地点
	 */
	 
	public void setBaogaodidian(String baogaodidian) {
		this.baogaodidian = baogaodidian;
	}
	
	/**
	 * 获取：报告地点
	 */
	public String getBaogaodidian() {
		return baogaodidian;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：报告人
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：报告人
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
			
}
