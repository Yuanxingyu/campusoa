package org.stary.campusoa.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 学院信息
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
public class XyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识id
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
	//学院名称
	private String xymc;
	//学院代码（人员设置的可见的学院识别码）
	private String xydm;

	/**
	 * 设置：唯一标识id
	 */
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	/**
	 * 获取：唯一标识id
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
	 * 设置：学院名称
	 */
	public void setXymc(String xymc) {
		this.xymc = xymc;
	}
	/**
	 * 获取：学院名称
	 */
	public String getXymc() {
		return xymc;
	}
	/**
	 * 设置：学院代码（人员设置的可见的学院识别码）
	 */
	public void setXydm(String xydm) {
		this.xydm = xydm;
	}
	/**
	 * 获取：学院代码（人员设置的可见的学院识别码）
	 */
	public String getXydm() {
		return xydm;
	}
}
