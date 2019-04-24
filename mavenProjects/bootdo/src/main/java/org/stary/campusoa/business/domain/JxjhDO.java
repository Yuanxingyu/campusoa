package org.stary.campusoa.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 教学计划表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
public class JxjhDO implements Serializable {
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
	//课程名称
	private String kcmc;
	//课程类别
	private String kclb;
	//课程性质
	private String kcxz;
	//学分
	private Integer xf;
	//学时（单位可能是'时'或者'周'）
	private String xqxs;
	//讲课学时
	private String jkxs;
	//实验学时（syxs+jkxs=xqxs）
	private String syxs;
	//开课学院
	private Integer kkxy;
	//课程代码（人员设定的可见的课程识别码）
	private String kcdm;

	private String kkxymc;

	public String getKkxymc() {
		return kkxymc;
	}

	public void setKkxymc(String kkxymc) {
		this.kkxymc = kkxymc;
	}

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
	 * 设置：课程名称
	 */
	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}
	/**
	 * 获取：课程名称
	 */
	public String getKcmc() {
		return kcmc;
	}
	/**
	 * 设置：课程类别
	 */
	public void setKclb(String kclb) {
		this.kclb = kclb;
	}
	/**
	 * 获取：课程类别
	 */
	public String getKclb() {
		return kclb;
	}
	/**
	 * 设置：课程性质
	 */
	public void setKcxz(String kcxz) {
		this.kcxz = kcxz;
	}
	/**
	 * 获取：课程性质
	 */
	public String getKcxz() {
		return kcxz;
	}
	/**
	 * 设置：学分
	 */
	public void setXf(Integer xf) {
		this.xf = xf;
	}
	/**
	 * 获取：学分
	 */
	public Integer getXf() {
		return xf;
	}
	/**
	 * 设置：学时（单位可能是'时'或者'周'）
	 */
	public void setXqxs(String xqxs) {
		this.xqxs = xqxs;
	}
	/**
	 * 获取：学时（单位可能是'时'或者'周'）
	 */
	public String getXqxs() {
		return xqxs;
	}
	/**
	 * 设置：讲课学时
	 */
	public void setJkxs(String jkxs) {
		this.jkxs = jkxs;
	}
	/**
	 * 获取：讲课学时
	 */
	public String getJkxs() {
		return jkxs;
	}
	/**
	 * 设置：实验学时（syxs+jkxs=xqxs）
	 */
	public void setSyxs(String syxs) {
		this.syxs = syxs;
	}
	/**
	 * 获取：实验学时（syxs+jkxs=xqxs）
	 */
	public String getSyxs() {
		return syxs;
	}
	/**
	 * 设置：开课学院
	 */
	public void setKkxy(Integer kkxy) {
		this.kkxy = kkxy;
	}
	/**
	 * 获取：开课学院
	 */
	public Integer getKkxy() {
		return kkxy;
	}
	/**
	 * 设置：课程代码（人员设定的可见的课程识别码）
	 */
	public void setKcdm(String kcdm) {
		this.kcdm = kcdm;
	}
	/**
	 * 获取：课程代码（人员设定的可见的课程识别码）
	 */
	public String getKcdm() {
		return kcdm;
	}
}
