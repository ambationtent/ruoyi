package com.ruoyi.test.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 第一个对象 first_com
 * 
 * @author ruoyi
 * @date 2023-08-08
 */
@Data
public class FirstCom
{
    private static final long serialVersionUID = 1L;

    /** 第一个id */
    @TableId
    private String id;

    /** 第一个name */
    @Excel(name = "第一个name")
    private String firstName;

    /** 第一个提示 */
    @Excel(name = "第一个提示")
    private String firstRemark;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date firstTime;

    /** 区域 */
    @Excel(name = "区域")
    private String firstArea;

    /** 省份 */
    @Excel(name = "省份")
    private String firstProvince;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long firstMoney;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getFirstName() 
    {
        return firstName;
    }
    public void setFirstRemark(String firstRemark) 
    {
        this.firstRemark = firstRemark;
    }

    public String getFirstRemark() 
    {
        return firstRemark;
    }
    public void setFirstTime(Date firstTime) 
    {
        this.firstTime = firstTime;
    }

    public Date getFirstTime() 
    {
        return firstTime;
    }
    public void setFirstArea(String firstArea) 
    {
        this.firstArea = firstArea;
    }

    public String getFirstArea() 
    {
        return firstArea;
    }
    public void setFirstProvince(String firstProvince) 
    {
        this.firstProvince = firstProvince;
    }

    public String getFirstProvince() 
    {
        return firstProvince;
    }
    public void setFirstMoney(Long firstMoney) 
    {
        this.firstMoney = firstMoney;
    }

    public Long getFirstMoney() 
    {
        return firstMoney;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("firstName", getFirstName())
            .append("firstRemark", getFirstRemark())
            .append("firstTime", getFirstTime())
            .append("firstArea", getFirstArea())
            .append("firstProvince", getFirstProvince())
            .append("firstMoney", getFirstMoney())
            .toString();
    }
}
