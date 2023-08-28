package com.ruoyi.web.controller.first;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.FirstCom;
import com.ruoyi.test.service.IFirstComService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 第一个Controller
 * 
 * @author ruoyi
 * @date 2023-08-08
 */
@Controller
@RequestMapping("/test/com")
public class FirstComController extends BaseController
{
    private String prefix = "test/com";

    @Autowired
    private IFirstComService firstComService;

    @RequiresPermissions("test:com:view")
    @GetMapping()
    public String com()
    {
        return prefix + "/com";
    }

    /**
     * 查询第一个列表
     */
    @RequiresPermissions("test:com:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FirstCom firstCom)
    {
        startPage();
        List<FirstCom> list = firstComService.selectFirstComList(firstCom);
        return getDataTable(list);
    }

    /**
     * 导出第一个列表
     */
    @RequiresPermissions("test:com:export")
    @Log(title = "第一个", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FirstCom firstCom)
    {
        List<FirstCom> list = firstComService.selectFirstComList(firstCom);
        ExcelUtil<FirstCom> util = new ExcelUtil<FirstCom>(FirstCom.class);
        return util.exportExcel(list, "第一个数据");
    }

    /**
     * 新增第一个
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存第一个
     */
    @RequiresPermissions("test:com:add")
    @Log(title = "第一个", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FirstCom firstCom)
    {
        return toAjax(firstComService.insertFirstCom(firstCom));
    }

    /**
     * 修改第一个
     */
    @RequiresPermissions("test:com:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        FirstCom firstCom = firstComService.selectFirstComById(id);
        mmap.put("firstCom", firstCom);
        return prefix + "/edit";
    }

    /**
     * 修改保存第一个
     */
    @RequiresPermissions("test:com:edit")
    @Log(title = "第一个", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FirstCom firstCom)
    {
        return toAjax(firstComService.updateFirstCom(firstCom));
    }

    /**
     * 删除第一个
     */
    @RequiresPermissions("test:com:remove")
    @Log(title = "第一个", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(firstComService.deleteFirstComByIds(ids));
    }
}
