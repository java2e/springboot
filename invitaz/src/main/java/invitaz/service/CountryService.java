package invitaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import invitaz.core.service.BaseService;
import invitaz.dao.CountryDao;
import invitaz.entity.Country;


@Service
@Transactional
public class CountryService implements BaseService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CountryDao countryDao;

	public String getCountryName(Long id)
	{
		Country country=countryDao.getEntity(id);
		
		return country.getName();
	}


}
