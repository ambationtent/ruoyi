package com.ruoyi.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.test.domain.FirstCom;
import com.ruoyi.test.mapper.FirstComMapper;
import com.ruoyi.test.service.IFirstComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 第一个Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-08
 */
@Service
public class FirstComServiceImpl implements IFirstComService
{
    @Autowired
    private FirstComMapper firstComMapper;

    /**
     * 查询第一个
     * 
     * @param id 第一个主键
     * @return 第一个
     */
    @Override
    public FirstCom selectFirstComById(String id)
    {
        return firstComMapper.selectById(id);
    }

    /**
     * 查询第一个列表
     * 
     * @param firstCom 第一个
     * @return 第一个
     */
    @Override
    public List<FirstCom> selectFirstComList(FirstCom firstCom)
    {
        return firstComMapper.selectFirstComList(firstCom);
    }

    /**
     * 新增第一个
     * 
     * @param firstCom 第一个
     * @return 结果
     */
    @Override
    public int insertFirstCom(FirstCom firstCom)
    {
        return firstComMapper.insertFirstCom(firstCom);
    }

    /**
     * 修改第一个
     * 
     * @param firstCom 第一个
     * @return 结果
     */
    @Override
    public int updateFirstCom(FirstCom firstCom)
    {
        return firstComMapper.updateFirstCom(firstCom);
    }

    /**
     * 批量删除第一个
     * 
     * @param ids 需要删除的第一个主键
     * @return 结果
     */
    @Override
    public int deleteFirstComByIds(String ids)
    {
        List<String> idList = Arrays.asList(ids.split(","));
        return firstComMapper.deleteBatchIds(idList);
    }

    /**
     * 删除第一个信息
     * 
     * @param id 第一个主键
     * @return 结果
     */
    @Override
    public int deleteFirstComById(String id)
    {
        LambdaQueryWrapper<FirstCom> firstComQW = new LambdaQueryWrapper<>();
        firstComQW.eq(FirstCom::getId, id);
        return firstComMapper.delete(firstComQW);
    }
}
