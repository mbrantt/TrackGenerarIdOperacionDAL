package com.nobelti.cl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESB_PROJECT_OPERATION", schema = "dbo")
public class Operacion {
	@Id
	@Column(name = "ID_OPERATION")
	private int idOperation;
	@Column(name = "PS_NAME")
	private String proxyName;
	@Column(name = "ID_PROJECT_ESB")
	private int idProject;
	public int getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}
	public String getProxyName() {
		return proxyName;
	}
	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}
	public int getIdProject() {
		return idProject;
	}
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	
	

}
