package com.lgx.tree.dao;

import com.lgx.tree.entity.InstitutionEntity;

import java.util.List;

public interface IInstitutionDAO {

    public List<InstitutionEntity> queryInstitution();

    public List<InstitutionEntity> queryInsIDByInsName(String institution_name);

    public InstitutionEntity queryInsByInsID(int institution_id);
}
