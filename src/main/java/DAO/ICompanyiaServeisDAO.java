package DAO;

import Classes.CompanyiaServeis;

public interface ICompanyiaServeisDAO extends IGenericDAO<CompanyiaServeis, Integer>{

	int calcularLloguerCompanyia(CompanyiaServeis companyia, int resultatDaus);
	
}
