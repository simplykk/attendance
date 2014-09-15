package cn.edu.zime.domain;

import java.io.Serializable;



public class Profession implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6232923054684908776L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PROFESSION.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PROFESSION.PRO_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String proCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PROFESSION.PRO_NAME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private String proName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PROFESSION.DEP_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    private Integer depId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PROFESSION.ID
     *
     * @return the value of PROFESSION.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PROFESSION.ID
     *
     * @param id the value for PROFESSION.ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PROFESSION.PRO_CODE
     *
     * @return the value of PROFESSION.PRO_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getProCode() {
        return proCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PROFESSION.PRO_CODE
     *
     * @param proCode the value for PROFESSION.PRO_CODE
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PROFESSION.PRO_NAME
     *
     * @return the value of PROFESSION.PRO_NAME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public String getProName() {
        return proName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PROFESSION.PRO_NAME
     *
     * @param proName the value for PROFESSION.PRO_NAME
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PROFESSION.DEP_ID
     *
     * @return the value of PROFESSION.DEP_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public Integer getDepId() {
        return depId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PROFESSION.DEP_ID
     *
     * @param depId the value for PROFESSION.DEP_ID
     *
     * @mbggenerated Sun Sep 07 10:33:37 CST 2014
     */
    public void setDepId(Integer depId) {
        this.depId = depId;
    }
}