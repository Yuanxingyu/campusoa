package org.stary.campusoa.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 教师表
 * 
 * @author stary
 * @email 3303521941@qq.com
 * @date 2019-04-21 01:03:37
 */
public class TeacherDO implements Serializable {
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
	//系统所有用户的维护表中的id（用户的唯一表示id）
	private Long userid;
	//教师姓名
	private String jsname;
	//教工号
	private String jgh;
	//所属学院
	private Integer ssxyid;
	//职称
	private Integer zc;
	//介绍主要工作内容
	private String zygz;

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
	 * 设置：系统所有用户的维护表中的id（用户的唯一表示id）
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：系统所有用户的维护表中的id（用户的唯一表示id）
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJsname(String jsname) {
		this.jsname = jsname;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJsname() {
		return jsname;
	}
	/**
	 * 设置：教工号
	 */
	public void setJgh(String jgh) {
		this.jgh = jgh;
	}
	/**
	 * 获取：教工号
	 */
	public String getJgh() {
		return jgh;
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
	 * 设置：职称
	 */
	public void setZc(Integer zc) {
		this.zc = zc;
	}
	/**
	 * 获取：职称
	 */
	public Integer getZc() {
		return zc;
	}
	/**
	 * 设置：介绍主要工作内容
	 */
	public void setZygz(String zygz) {
		this.zygz = zygz;
	}
	/**
	 * 获取：介绍主要工作内容
	 */
	public String getZygz() {
		return zygz;
	}
}
