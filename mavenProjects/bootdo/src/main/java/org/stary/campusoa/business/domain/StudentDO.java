package org.stary.campusoa.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 学生表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:36
 */
public class StudentDO implements Serializable {
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
	//系统所有用户的唯一识别id
	private Long userid;
	//学生姓名
	private String xsname;
	//学工号
	private String xgh;
	//所属学院
	private Integer ssxyid;
	//所属专业
	private Integer sszyid;
	//入学年份
	private Integer rxnf;
	//所属班级
	private Integer ssbjid;
	//学生状态（1:正常，2:留级，3:已毕业（销籍）。销籍状态下无权登陆系统）
	private Integer xszt;
	//学期（1,2,3,4,5,6,7,8）
	private Integer xq;

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
	 * 设置：系统所有用户的唯一识别id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：系统所有用户的唯一识别id
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXsname(String xsname) {
		this.xsname = xsname;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXsname() {
		return xsname;
	}
	/**
	 * 设置：学工号
	 */
	public void setXgh(String xgh) {
		this.xgh = xgh;
	}
	/**
	 * 获取：学工号
	 */
	public String getXgh() {
		return xgh;
	}
	/**
	 * 设置：所属学院
	 */
	public void setSsxyid(Integer ssxyid) {
		this.ssxyid = ssxyid;
	}
	/**
	 * 获取：所属学院
	 */
	public Integer getSsxyid() {
		return ssxyid;
	}
	/**
	 * 设置：所属专业
	 */
	public void setSszyid(Integer sszyid) {
		this.sszyid = sszyid;
	}
	/**
	 * 获取：所属专业
	 */
	public Integer getSszyid() {
		return sszyid;
	}
	/**
	 * 设置：入学年份
	 */
	public void setRxnf(Integer rxnf) {
		this.rxnf = rxnf;
	}
	/**
	 * 获取：入学年份
	 */
	public Integer getRxnf() {
		return rxnf;
	}
	/**
	 * 设置：所属班级
	 */
	public void setSsbjid(Integer ssbjid) {
		this.ssbjid = ssbjid;
	}
	/**
	 * 获取：所属班级
	 */
	public Integer getSsbjid() {
		return ssbjid;
	}
	/**
	 * 设置：学生状态（1:正常，2:留级，3:已毕业（销籍）。销籍状态下无权登陆系统）
	 */
	public void setXszt(Integer xszt) {
		this.xszt = xszt;
	}
	/**
	 * 获取：学生状态（1:正常，2:留级，3:已毕业（销籍）。销籍状态下无权登陆系统）
	 */
	public Integer getXszt() {
		return xszt;
	}
	/**
	 * 设置：学期（1,2,3,4,5,6,7,8）
	 */
	public void setXq(Integer xq) {
		this.xq = xq;
	}
	/**
	 * 获取：学期（1,2,3,4,5,6,7,8）
	 */
	public Integer getXq() {
		return xq;
	}
}
