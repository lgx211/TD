package com.lgx.tree.entity;

public class InstitutionEntity {
    private int institution_id;         //机构id
    private String institution_name;    //机构名称
    private int parent_institution_id;  //父机构id

    public int getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(int institution_id) {
        this.institution_id = institution_id;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public int getParent_institution_id() {
        return parent_institution_id;
    }

    public void setParent_institution_id(int parent_institution_id) {
        this.parent_institution_id = parent_institution_id;
    }
}
