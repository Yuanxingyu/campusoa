package org.stary.campusoa.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 学生选课表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
public class XsKcDO implements Serializable {
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
	//专业-课程表的tid
	private Integer zykcid;
	//学生id
	private Integer xsid;
	//成绩
	private Double score;

	private String zymc;
	private String kcmc;
	private String xsname;
	private String kcdm;
	private Integer xf;

	public String getKcdm() {
		return kcdm;
	}

	public void setKcdm(String kcdm) {
		this.kcdm = kcdm;
	}

	public Integer getXf() {
		return xf;
	}

	public void setXf(Integer xf) {
		this.xf = xf;
	}

	public String getZymc() {
		return zymc;

	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	public String getKcmc() {
		return kcmc;
	}

	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}

	public String getXsname() {
		return xsname;
	}

	public void setXsname(String xsname) {
		this.xsname = xsname;
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
	 * 设置：专业-课程表的tid
	 */
	public void setZykcid(Integer zykcid) {
		this.zykcid = zykcid;
	}
	/**
	 * 获取：专业-课程表的tid
	 */
	public Integer getZykcid() {
		return zykcid;
	}
	/**
	 * 设置：学生id
	 */
	public void setXsid(Integer xsid) {
		this.xsid = xsid;
	}
	/**
	 * 获取：学生id
	 */
	public Integer getXsid() {
		return xsid;
	}
	/**
	 * 设置：成绩
	 */
	public void setScore(Double score) {
		this.score = score;
	}
	/**
	 * 获取：成绩
	 */
	public Double getScore() {
		return score;
	}
}
