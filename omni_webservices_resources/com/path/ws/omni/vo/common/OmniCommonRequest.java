package com.path.ws.omni.vo.common;

import java.math.BigDecimal;

public class OmniCommonRequest extends RequestBaseObject
{
    private String parameterId;
    private String parameterName;
    private String paramNameList; //comma separated parameter names
    private String parameterGrp;
    private String crc_token;
    private BigDecimal groupCode; 
    private String actionType;
    private String name;
    private BigDecimal mappingId;
    private BigDecimal dataSaveId;
    private String appName;
    private String status;
    private int language_id;
    
    
    public String getParameterId()
    {
        return parameterId;
    }
    public void setParameterId(String parameterId)
    {
        this.parameterId = parameterId;
    }
    public String getParameterName()
    {
        return parameterName;
    }
    public void setParameterName(String parameterName)
    {
        this.parameterName = parameterName;
    }
    public String getParameterGrp()
    {
        return parameterGrp;
    }
    public void setParameterGrp(String parameterGrp)
    {
        this.parameterGrp = parameterGrp;
    }
    public String getParamNameList()
    {
        return paramNameList;
    }
    public void setParamNameList(String paramNameList)
    {
        this.paramNameList = paramNameList;
    }
    public String getCrc_token()
    {
        return crc_token;
    }
    public void setCrc_token(String crc_token)
    {
        this.crc_token = crc_token;
    }
	public BigDecimal getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(BigDecimal groupCode) {
		this.groupCode = groupCode;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMappingId() {
		return mappingId;
	}
	public void setMappingId(BigDecimal mappingId) {
		this.mappingId = mappingId;
	}
	public BigDecimal getDataSaveId() {
		return dataSaveId;
	}
	public void setDataSaveId(BigDecimal dataSaveId) {
		this.dataSaveId = dataSaveId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	
	
}