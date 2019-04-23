package org.stary.campusoa.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 班级统一课表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
public class BjKbDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//表内唯一标识id
	private Integer tid;
	//创建者
	private String insertby;
	//修发者
	private String updateby;
	//创建时间
	private Date inserttime;
	//修改时间
	private Date updatetime;
	//逻辑删除：0存在，1删除
	private Integer logicaldeletecode;
	//班级id
	private Integer bjid;
	//对应的专业课程计划id
	private Integer zykcid;

	/**
	 * 设置：表内唯一标识id
	 */
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	/**
	 * 获取：表内唯一标识id
	 */
	public Integer getTid() {
		return tid;
	}
	/**
	 * 设置：创建者
	 */
	public void setInsertby(String insertby) {
		this.insertby = insertby;
	}
	/**
	 * 获取：创建者
	 */
	public String getInsertby() {
		return insertby;
	}
	/**
	 * 设置：修发者
	 */
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}
	/**
	 * 获取：修发者
	 */
	public String getUpdateby() {
		return updateby;
	}
	/**
	 * 设置：创建时间
	 */
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getInserttime() {
		return inserttime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：逻辑删除：0存在，1删除
	 */
	public void setLogicaldeletecode(Integer logicaldeletecode) {
		this.logicaldeletecode = logicaldeletecode;
	}
	/**
	 * 获取：逻辑删除：0存在，1删除
	 */
	public Integer getLogicaldeletecode() {
		return logicaldeletecode;
	}
	/**
	 * 设置：班级id
	 */
	public void setBjid(Integer bjid) {
		this.bjid = bjid;
	}
	/**
	 * 获取：班级id
	 */
	public Integer getBjid() {
		return bjid;
	}
	/**
	 * 设置：对应的专业课程计划id
	 */
	public void setZykcid(Integer zykcid) {
		this.zykcid = zykcid;
	}
	/**
	 * 获取：对应的专业课程计划id
	 */
	public Integer getZykcid() {
		return zykcid;
	}
}
