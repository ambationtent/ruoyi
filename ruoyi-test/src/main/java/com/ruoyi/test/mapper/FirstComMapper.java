package com.ruoyi.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.test.domain.FirstCom;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 第一个Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-08
 */
@Component
public interface FirstComMapper extends BaseMapper<FirstCom>
{
    /**
     * 查询第一个
     * 
     * @param id 第一个主键
     * @return 第一个
     */
    public FirstCom selectFirstComById(String id);

    /**
     * 查询第一个列表
     * 
     * @param firstCom 第一个
     * @return 第一个集合
     */
    public List<FirstCom> selectFirstComList(FirstCom firstCom);

    /**
     * 新增第一个
     * 
     * @param firstCom 第一个
     * @return 结果
     */
    public int insertFirstCom(FirstCom firstCom);

    /**
     * 修改第一个
     * 
     * @param firstCom 第一个
     * @return 结果
     */
    public int updateFirstCom(FirstCom firstCom);

    /**
     * 删除第一个
     * 
     * @param id 第一个主键
     * @return 结果
     */
    public int deleteFirstComById(String id);

    /**
     * 批量删除第一个
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFirstComByIds(String[] ids);
}
