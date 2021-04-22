package com.path.ws.omni.vo.common;

import java.io.Serializable;
import java.math.BigDecimal;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RequestBaseObject  implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private BigDecimal compCode;
    private BigDecimal channelId;
    private BigDecimal appId;
    public BigDecimal getCompCode()
    {
        return compCode;
    }
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }
    public BigDecimal getChannelId()
    {
        return channelId;
    }
    public void setChannelId(BigDecimal channelId)
    {
        this.channelId = channelId;
    }
    public BigDecimal getAppId()
    {
        return appId;
    }
    public void setAppId(BigDecimal appId)
    {
        this.appId = appId;
    }
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
  

    

   
    
}
