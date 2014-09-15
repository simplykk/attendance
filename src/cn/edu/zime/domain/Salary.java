package cn.edu.zime.domain;

import java.io.Serializable;

import java.util.Date;


public class Salary implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1111123193107168282L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SALARY.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SALARY.STU_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String stuCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SALARY.CLASS_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer classId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SALARY.MARK_DATE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Date markDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SALARY.TIME_STEP
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String timeStep;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SALARY.PERIOD
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer period;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SALARY.TYPE_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String typeCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SALARY.REASON
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String reason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SALARY.MARKER_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String markerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SALARY.ID
     *
     * @return the value of SALARY.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SALARY.ID
     *
     * @param id the value for SALARY.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SALARY.STU_CODE
     *
     * @return the value of SALARY.STU_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getStuCode() {
        return stuCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SALARY.STU_CODE
     *
     * @param stuCode the value for SALARY.STU_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setStuCode(String stuCode) {
        this.stuCode = stuCode == null ? null : stuCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SALARY.CLASS_ID
     *
     * @return the value of SALARY.CLASS_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SALARY.CLASS_ID
     *
     * @param classId the value for SALARY.CLASS_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SALARY.MARK_DATE
     *
     * @return the value of SALARY.MARK_DATE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Date getMarkDate() {
        return markDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SALARY.MARK_DATE
     *
     * @param markDate the value for SALARY.MARK_DATE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setMarkDate(Date markDate) {
        this.markDate = markDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SALARY.TIME_STEP
     *
     * @return the value of SALARY.TIME_STEP
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getTimeStep() {
        return timeStep;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SALARY.TIME_STEP
     *
     * @param timeStep the value for SALARY.TIME_STEP
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setTimeStep(String timeStep) {
        this.timeStep = timeStep == null ? null : timeStep.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SALARY.PERIOD
     *
     * @return the value of SALARY.PERIOD
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SALARY.PERIOD
     *
     * @param period the value for SALARY.PERIOD
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SALARY.TYPE_CODE
     *
     * @return the value of SALARY.TYPE_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SALARY.TYPE_CODE
     *
     * @param typeCode the value for SALARY.TYPE_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SALARY.REASON
     *
     * @return the value of SALARY.REASON
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SALARY.REASON
     *
     * @param reason the value for SALARY.REASON
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SALARY.MARKER_ID
     *
     * @return the value of SALARY.MARKER_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getMarkerId() {
        return markerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SALARY.MARKER_ID
     *
     * @param markerId the value for SALARY.MARKER_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setMarkerId(String markerId) {
        this.markerId = markerId == null ? null : markerId.trim();
    }
}