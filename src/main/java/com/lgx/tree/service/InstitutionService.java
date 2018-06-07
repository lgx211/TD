package com.lgx.tree.service;

import com.lgx.tree.dao.IInstitutionDAO;
import com.lgx.tree.dto.InstitutionDTO;
import com.lgx.tree.entity.InstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InstitutionService implements IInstitutionService {

    @Autowired
    private IInstitutionDAO institutionDAO;

    public List<Map<String, Object>> getInstitutionTree() {
        List<Map<String, Object>> institutionTree = new ArrayList<Map<String, Object>>();

        // 获取所有的机构信息
        List<InstitutionEntity> institutionEntityList = this.institutionDAO
                .queryInstitution();

        // 将机构信息封装成树结构
        for (int i = 0; i < institutionEntityList.size(); i++) {
            Map<String, Object> map = null;
            InstitutionEntity institutionEntity = institutionEntityList.get(i);
            //如果是根节点
            if (institutionEntity.getParent_institution_id() == 0) {
                map = new HashMap<String, Object>();
                // 将id、name等转换成前台界面的显示形式id、text。第一级菜单默认展开
                map.put("id", institutionEntityList.get(i).getInstitution_id());
                map.put("name", institutionEntityList.get(i).getInstitution_name());
                map.put("children", getInstitutionChildTree(institutionEntityList,
                        institutionEntity.getInstitution_id()));
            }
            //如果有树节点信息。封装成map形式了。
            if (map != null) {
                institutionTree.add(map);
            }
        }
        return institutionTree;
    }

    // 递归调用，创建子树节点信息。
    private List<Map<String, Object>> getInstitutionChildTree(
            List<InstitutionEntity> institutionEntityList, long pID) {
        List<Map<String, Object>> institutionChildTree = new ArrayList<Map<String, Object>>();

        for (int j = 0; j < institutionEntityList.size(); j++) {
            Map<String, Object> map = null;
            InstitutionEntity institutionEntity = institutionEntityList.get(j);
            if (institutionEntity.getParent_institution_id() == pID) {
                map = new HashMap<String, Object>();
                map.put("id", institutionEntityList.get(j).getInstitution_id());
                map.put("name", institutionEntityList.get(j).getInstitution_name());
                map.put("children", getInstitutionChildTree(institutionEntityList,
                        institutionEntity.getInstitution_id()));

                List list = getInstitutionChildTree(institutionEntityList,
                        institutionEntity.getInstitution_id());

                // 如果不是最后一级菜单，默认不展开
                if (list != null && !list.isEmpty()) {
                    map.put("open", "false");
                }
            }
            if (map != null)
                institutionChildTree.add(map);
        }
        return institutionChildTree;
    }


    //根据机构名称查询机构
    public String queryInsIDByInsName(String institutionName) {
        List<InstitutionEntity> institutionEntityList = this.institutionDAO.queryInsIDByInsName(institutionName);
        if (institutionEntityList.size() >= 1) {
            String institutionID = String.valueOf(institutionEntityList.get(0).getInstitution_id());
            return institutionID;
        } else {
            return null;
        }
    }

    //根据机构ID查询机构
    public InstitutionDTO queryInsByInsID(int institutionID) {
        InstitutionEntity institutionEntity = this.institutionDAO.queryInsByInsID(institutionID);

        InstitutionDTO institutionDTO = new InstitutionDTO();
        institutionDTO.setInstitutionID(institutionEntity.getInstitution_id());
        institutionDTO.setInstitutionName(institutionEntity.getInstitution_name());
        institutionDTO.setParentInstitutionID(institutionEntity.getParent_institution_id());


        if (institutionEntity.getParent_institution_id() != 0) {
            institutionDTO.setParentInstitutionName(this.institutionDAO.queryInsByInsID(institutionEntity.getParent_institution_id()).getInstitution_name());
        } else {
            institutionDTO.setParentInstitutionName(" ");
        }

        return institutionDTO;
    }

}
