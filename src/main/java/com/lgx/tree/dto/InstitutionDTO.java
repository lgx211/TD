package com.lgx.tree.dto;

public class InstitutionDTO {
    private int institutionID;         //机构id
    private String institutionName;    //机构名称
    private int parentInstitutionID;  //父机构id

    private String parentInstitutionName;    //机构名称

    public int getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(int institutionID) {
        this.institutionID = institutionID;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public int getParentInstitutionID() {
        return parentInstitutionID;
    }

    public void setParentInstitutionID(int parentInstitutionID) {
        this.parentInstitutionID = parentInstitutionID;
    }

    public String getParentInstitutionName() {
        return parentInstitutionName;
    }

    public void setParentInstitutionName(String parentInstitutionName) {
        this.parentInstitutionName = parentInstitutionName;
    }
}
