package com.iesalixar.servidor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.servidor.model.Departamento;
import com.iesalixar.servidor.repository.DepartamentoRepository;
@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	DepartamentoRepository deptRepo;
	
	@Override
	public List<Departamento> getAllDepartamentos() {
		List<Departamento> deptBD = deptRepo.findAll();
		if(deptBD !=null && deptBD.size()>0) {
			return deptBD;
		}
		return new ArrayList<Departamento>();
	}

}
