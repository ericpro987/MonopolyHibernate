package DAO;

import Classes.CompanyiaServeis;

public interface ICompanyiaServeisDAO extends IPropietatDAO<CompanyiaServeis, Integer>{

	int calcularLloguerCompanyia(CompanyiaServeis companyia, int resultatDaus);
	
}
