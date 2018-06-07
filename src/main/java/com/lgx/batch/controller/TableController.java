package com.lgx.batch.controller;

import com.lgx.batch.dto.TableDTO;
import com.lgx.batch.service.ITableService;
import com.lgx.tree.dto.UserBasicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TableController {
    @Autowired
    private ITableService tableService;

    //跳转到表格分页排序的页面
    @RequestMapping("table.do")
    public ModelAndView jumpToTableJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("batch/table");
        return mov;
    }

    @RequestMapping("tableUser.ajax")
    @ResponseBody
    public Map<String, Object> getTableUser(TableDTO tableDTO, UserBasicDTO userBasicDTO) {

        List<Map<String, Object>> mapList = this.tableService.getTableUser(tableDTO, userBasicDTO);
        Integer count = this.tableService.getTableUserCount(tableDTO, userBasicDTO);

        Map<String, Object> map = new HashMap();
        map.put("total", count);
        map.put("rows", mapList);
        return map;
    }

}