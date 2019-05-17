package org.stary.campusoa.business.domain;

import org.stary.campusoa.activiti.domain.TaskDO;
import org.stary.campusoa.activiti.vo.TaskVO;

import java.io.Serializable;
import java.util.Date;



/**
 * 设备报修事务表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-05-13 14:49:57
 */
public class SbbxDO extends TaskDO implements Serializable {
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
	//申报学生id
	private Integer xsid;
	//学生姓名
	private String xsname;
	//申报原因
	private String qjyy;
	//流程状态
	private String processstate;

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
	 * 设置：申报学生id
	 */
	public void setXsid(Integer xsid) {
		this.xsid = xsid;
	}
	/**
	 * 获取：申报学生id
	 */
	public Integer getXsid() {
		return xsid;
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
	 * 设置：申报原因
	 */
	public void setQjyy(String qjyy) {
		this.qjyy = qjyy;
	}
	/**
	 * 获取：申报原因
	 */
	public String getQjyy() {
		return qjyy;
	}
	/**
	 * 设置：流程状态
	 */
	public void setProcessstate(String processstate) {
		this.processstate = processstate;
	}
	/**
	 * 获取：流程状态
	 */
	public String getProcessstate() {
		return processstate;
	}
}
