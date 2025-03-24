package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 研讨学术
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-07 19:22:55
 */
@TableName("yantaoxueshu")
public class YantaoxueshuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YantaoxueshuEntity() {
		
	}
	
	public YantaoxueshuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 报告主题
	 */
					
	private String baogaozhuti;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：报告主题
	 */
	public void setBaogaozhuti(String baogaozhuti) {
		this.baogaozhuti = baogaozhuti;
	}
	/**
	 * 获取：报告主题
	 */
	public String getBaogaozhuti() {
		return baogaozhuti;
	}
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
