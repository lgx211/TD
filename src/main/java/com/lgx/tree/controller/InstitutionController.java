package com.lgx.tree.controller;

import com.lgx.tree.dto.InstitutionDTO;
import com.lgx.tree.service.IInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class InstitutionController {
    @Autowired
    private IInstitutionService institutionService;

    //跳转到组织机构管理的页面
    @RequestMapping("institution.do")
    public ModelAndView jumpToInstitutionJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("tree/institution");
        return mov;
    }

    //初始化机构树信息
    @RequestMapping("institutionTree.ajax")
    @ResponseBody
    public List<Map<String, Object>> getInstitutionTree() {
        //ajax异步刷新，无需指定跳转的页面
        return this.institutionService.getInstitutionTree();
    }

    //定位某一个机构
    @RequestMapping("locateInstitution.ajax")
    @ResponseBody
    public String locateInstitution(InstitutionDTO institution) {
        return this.institutionService.queryInsIDByInsName(institution.getInstitutionName());
    }

    //点击机构树，查询具体信息
    @RequestMapping("clickInstitutionTree.ajax")
    @ResponseBody
    public InstitutionDTO clickInstitutionTree(InstitutionDTO institution) {
        return this.institutionService.queryInsByInsID(institution.getInstitutionID());
    }


}
