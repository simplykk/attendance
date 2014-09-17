package cn.edu.zime.domain;

import java.io.Serializable;

import java.util.Date;


public class Request implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8903389691613619807L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.STU_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String stuCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.TRANSACTOR_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String transactorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.REQUEST_REASON
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String requestReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.BEGIN_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String beginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.END_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.REQUEST_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String requestTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.CHECK_STATE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String checkState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.CHECK_REMARK
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String checkRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REQUEST.REQUEST_TYPE_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String requestTypeCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.ID
     *
     * @return the value of REQUEST.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.ID
     *
     * @param id the value for REQUEST.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.STU_CODE
     *
     * @return the value of REQUEST.STU_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getStuCode() {
        return stuCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.STU_CODE
     *
     * @param stuCode the value for REQUEST.STU_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setStuCode(String stuCode) {
        this.stuCode = stuCode == null ? null : stuCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.TRANSACTOR_ID
     *
     * @return the value of REQUEST.TRANSACTOR_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getTransactorId() {
        return transactorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.TRANSACTOR_ID
     *
     * @param transactorId the value for REQUEST.TRANSACTOR_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setTransactorId(String transactorId) {
        this.transactorId = transactorId == null ? null : transactorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.REQUEST_REASON
     *
     * @return the value of REQUEST.REQUEST_REASON
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getRequestReason() {
        return requestReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.REQUEST_REASON
     *
     * @param requestReason the value for REQUEST.REQUEST_REASON
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason == null ? null : requestReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.BEGIN_TIME
     *
     * @return the value of REQUEST.BEGIN_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.BEGIN_TIME
     *
     * @param beginTime the value for REQUEST.BEGIN_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.END_TIME
     *
     * @return the value of REQUEST.END_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.END_TIME
     *
     * @param endTime the value for REQUEST.END_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.REQUEST_TIME
     *
     * @return the value of REQUEST.REQUEST_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getRequestTime() {
        return requestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.REQUEST_TIME
     *
     * @param requestTime the value for REQUEST.REQUEST_TIME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.CHECK_STATE
     *
     * @return the value of REQUEST.CHECK_STATE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getCheckState() {
        return checkState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.CHECK_STATE
     *
     * @param checkState the value for REQUEST.CHECK_STATE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setCheckState(String checkState) {
        this.checkState = checkState == null ? null : checkState.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.CHECK_REMARK
     *
     * @return the value of REQUEST.CHECK_REMARK
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getCheckRemark() {
        return checkRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.CHECK_REMARK
     *
     * @param checkRemark the value for REQUEST.CHECK_REMARK
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REQUEST.REQUEST_TYPE_CODE
     *
     * @return the value of REQUEST.REQUEST_TYPE_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getRequestTypeCode() {
        return requestTypeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REQUEST.REQUEST_TYPE_CODE
     *
     * @param requestTypeCode the value for REQUEST.REQUEST_TYPE_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setRequestTypeCode(String requestTypeCode) {
        this.requestTypeCode = requestTypeCode == null ? null : requestTypeCode.trim();
    }
}