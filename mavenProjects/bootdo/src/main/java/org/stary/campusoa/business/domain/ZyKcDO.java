package org.stary.campusoa.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 专业-课程联系表（定义各专业的开课课程，用来做各个专业的教学计划）
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
public class ZyKcDO implements Serializable {
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
	//专业id
	private Integer zyid;
	//课程id
	private Integer jxjhid;
	//各专业的开课学期
	private Integer kkxq;
	//任课教师id
	private Integer rkjsid;
	//上课时间段（1、8:00-9:40,2、10:10-11:50，3、13:30-15:10,4、15:40-17:20,5、18:30-20:10）
	private String sksjd;
	//上课地点（数据字典维护）
	private String skdd;

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
	 * 设置：专业id
	 */
	public void setZyid(Integer zyid) {
		this.zyid = zyid;
	}
	/**
	 * 获取：专业id
	 */
	public Integer getZyid() {
		return zyid;
	}
	/**
	 * 设置：课程id
	 */
	public void setJxjhid(Integer jxjhid) {
		this.jxjhid = jxjhid;
	}
	/**
	 * 获取：课程id
	 */
	public Integer getJxjhid() {
		return jxjhid;
	}
	/**
	 * 设置：各专业的开课学期
	 */
	public void setKkxq(Integer kkxq) {
		this.kkxq = kkxq;
	}
	/**
	 * 获取：各专业的开课学期
	 */
	public Integer getKkxq() {
		return kkxq;
	}
	/**
	 * 设置：任课教师id
	 */
	public void setRkjsid(Integer rkjsid) {
		this.rkjsid = rkjsid;
	}
	/**
	 * 获取：任课教师id
	 */
	public Integer getRkjsid() {
		return rkjsid;
	}
	/**
	 * 设置：上课时间段（1、8:00-9:40,2、10:10-11:50，3、13:30-15:10,4、15:40-17:20,5、18:30-20:10）
	 */
	public void setSksjd(String sksjd) {
		this.sksjd = sksjd;
	}
	/**
	 * 获取：上课时间段（1、8:00-9:40,2、10:10-11:50，3、13:30-15:10,4、15:40-17:20,5、18:30-20:10）
	 */
	public String getSksjd() {
		return sksjd;
	}
	/**
	 * 设置：上课地点（数据字典维护）
	 */
	public void setSkdd(String skdd) {
		this.skdd = skdd;
	}
	/**
	 * 获取：上课地点（数据字典维护）
	 */
	public String getSkdd() {
		return skdd;
	}
}
