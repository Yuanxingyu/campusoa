package org.stary.campusoa.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 班级表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
public class BjDO implements Serializable {
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
	//所属学院id
	private Integer ssxyid;
	//所属专业id
	private Integer sszyid;
	//班级名称
	private String bjmc;
	//学期
	private Integer xq;
	//班级代码
	private String bjdm;

	private String ssxy;

	private String sszy;

	public String getBjdm() {
		return bjdm;
	}

	public void setBjdm(String bjdm) {
		this.bjdm = bjdm;
	}

	public String getSszy() {
		return sszy;
	}

	public void setSszy(String sszy) {
		this.sszy = sszy;
	}

	public String getSsxy() {
		return ssxy;
	}

	public void setSsxy(String ssxy) {
		this.ssxy = ssxy;
	}

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
	 * 设置：所属学院id
	 */
	public void setSsxyid(Integer ssxyid) {
		this.ssxyid = ssxyid;
	}
	/**
	 * 获取：所属学院id
	 */
	public Integer getSsxyid() {
		return ssxyid;
	}
	/**
	 * 设置：所属专业id
	 */
	public void setSszyid(Integer sszyid) {
		this.sszyid = sszyid;
	}
	/**
	 * 获取：所属专业id
	 */
	public Integer getSszyid() {
		return sszyid;
	}
	/**
	 * 设置：班级名称
	 */
	public void setBjmc(String bjmc) {
		this.bjmc = bjmc;
	}
	/**
	 * 获取：班级名称
	 */
	public String getBjmc() {
		return bjmc;
	}
	/**
	 * 设置：学期
	 */
	public void setXq(Integer xq) {
		this.xq = xq;
	}
	/**
	 * 获取：学期
	 */
	public Integer getXq() {
		return xq;
	}
}
