package com.prf.inventario.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="T004_SISTEMA")
public class Sistema implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="T004_ID_SISTEMA")
	private long T004_ID_SISTEMA;	
	
	@Column(name="T004_NO_SISTEMA")
	private String T004_NO_SISTEMA;
	@Column(name="T004_DE_SISTEMA")
	private String T004_DE_SISTEMA;
	@Column(name="T004_DT_PRODUCAO")
	private Date T004_DT_PRODUCAO;
	@Column(name="T004_DT_DESATIVACAO")
	private Date T004_DT_DESATIVACAO;
	@Column(name="T004_IS_ATIVO")
	private boolean T004_IS_ATIVO;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "sistemas")
	private List<Schema> schemas = new ArrayList<>();
	

	
	
}