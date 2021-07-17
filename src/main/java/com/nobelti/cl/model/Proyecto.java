package com.nobelti.cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESB_PROJECT", schema = "dbo")
public class Proyecto {
	@Id
	@Column(name = "ID_PROJECT")
	private int idProject;
	@Column(name = "PROJECT_NAME")
	private String projectName;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "COMPANY_OWNER")
	private String companyOwner;
	
	public int getIdProject() {
		return idProject;
	}
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCompanyOwner() {
		return companyOwner;
	}
	public void setCompanyOwner(String companyOwner) {
		this.companyOwner = companyOwner;
	}

}
