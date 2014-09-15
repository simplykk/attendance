package cn.edu.zime.domain;

import java.io.Serializable;

import cn.edu.zime.base.domain.ComStuPermission;
import cn.edu.zime.base.domain.UserBase;


public class Student extends UserBase implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3552323560306173682L;
	
	public Student () {
		setUserPermission(new ComStuPermission());
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STUDENT.STU_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String stuCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STUDENT.STU_NAME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String stuName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STUDENT.CLASS_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer classId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STUDENT.PHONE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STUDENT.SEX
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STUDENT.PASS_WORD
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String passWord;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STUDENT.GID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer gid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STUDENT.STU_CODE
     *
     * @return the value of STUDENT.STU_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getStuCode() {
        return stuCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STUDENT.STU_CODE
     *
     * @param stuCode the value for STUDENT.STU_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setStuCode(String stuCode) {
        this.stuCode = stuCode == null ? null : stuCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STUDENT.STU_NAME
     *
     * @return the value of STUDENT.STU_NAME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STUDENT.STU_NAME
     *
     * @param stuName the value for STUDENT.STU_NAME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STUDENT.CLASS_ID
     *
     * @return the value of STUDENT.CLASS_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STUDENT.CLASS_ID
     *
     * @param classId the value for STUDENT.CLASS_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STUDENT.PHONE
     *
     * @return the value of STUDENT.PHONE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STUDENT.PHONE
     *
     * @param phone the value for STUDENT.PHONE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STUDENT.SEX
     *
     * @return the value of STUDENT.SEX
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STUDENT.SEX
     *
     * @param sex the value for STUDENT.SEX
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STUDENT.PASS_WORD
     *
     * @return the value of STUDENT.PASS_WORD
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STUDENT.PASS_WORD
     *
     * @param passWord the value for STUDENT.PASS_WORD
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STUDENT.GID
     *
     * @return the value of STUDENT.GID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STUDENT.GID
     *
     * @param gid the value for STUDENT.GID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }
}