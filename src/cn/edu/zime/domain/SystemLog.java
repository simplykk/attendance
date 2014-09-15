package cn.edu.zime.domain;

import java.io.Serializable;

import java.util.Date;


public class SystemLog implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5052866783163444133L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEMLOG.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEMLOG.OPERATOR_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String operatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEMLOG.OPERATE_TYPE_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String operateTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEMLOG.USER_IP
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String userIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEMLOG.USER_IP_REALADD
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String userIpRealadd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEMLOG.OPERATE_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Date operateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEMLOG.ACADEMY_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer academyId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEMLOG.ID
     *
     * @return the value of SYSTEMLOG.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEMLOG.ID
     *
     * @param id the value for SYSTEMLOG.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEMLOG.OPERATOR_ID
     *
     * @return the value of SYSTEMLOG.OPERATOR_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEMLOG.OPERATOR_ID
     *
     * @param operatorId the value for SYSTEMLOG.OPERATOR_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEMLOG.OPERATE_TYPE_ID
     *
     * @return the value of SYSTEMLOG.OPERATE_TYPE_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getOperateTypeId() {
        return operateTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEMLOG.OPERATE_TYPE_ID
     *
     * @param operateTypeId the value for SYSTEMLOG.OPERATE_TYPE_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setOperateTypeId(String operateTypeId) {
        this.operateTypeId = operateTypeId == null ? null : operateTypeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEMLOG.USER_IP
     *
     * @return the value of SYSTEMLOG.USER_IP
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEMLOG.USER_IP
     *
     * @param userIp the value for SYSTEMLOG.USER_IP
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEMLOG.USER_IP_REALADD
     *
     * @return the value of SYSTEMLOG.USER_IP_REALADD
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getUserIpRealadd() {
        return userIpRealadd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEMLOG.USER_IP_REALADD
     *
     * @param userIpRealadd the value for SYSTEMLOG.USER_IP_REALADD
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setUserIpRealadd(String userIpRealadd) {
        this.userIpRealadd = userIpRealadd == null ? null : userIpRealadd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEMLOG.OPERATE_TIME
     *
     * @return the value of SYSTEMLOG.OPERATE_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEMLOG.OPERATE_TIME
     *
     * @param operateTime the value for SYSTEMLOG.OPERATE_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEMLOG.ACADEMY_ID
     *
     * @return the value of SYSTEMLOG.ACADEMY_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getAcademyId() {
        return academyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEMLOG.ACADEMY_ID
     *
     * @param academyId the value for SYSTEMLOG.ACADEMY_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }
}