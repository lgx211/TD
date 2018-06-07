package com.lgx.tree.service;

import com.lgx.tree.dto.InstitutionDTO;

import java.util.List;
import java.util.Map;

public interface IInstitutionService {

    public List<Map<String, Object>> getInstitutionTree();

    public String queryInsIDByInsName(String institutionName);

    public InstitutionDTO queryInsByInsID(int institutionID);

}
