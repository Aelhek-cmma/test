package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

public class SYS_PARAM_LANGUAGESVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SYS_PARAM_LANGUAGES.LANG_CODE
     */
    private String LANG_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_LANGUAGES.LANG_CODE
     *
     * @return the value of SYS_PARAM_LANGUAGES.LANG_CODE
     */
    public String getLANG_CODE() {
        return LANG_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_LANGUAGES.LANG_CODE
     *
     * @param LANG_CODE the value for SYS_PARAM_LANGUAGES.LANG_CODE
     */
    public void setLANG_CODE(String LANG_CODE) {
        this.LANG_CODE = LANG_CODE == null ? null : LANG_CODE.trim();
    }
}