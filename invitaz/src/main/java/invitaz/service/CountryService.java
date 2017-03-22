package invitaz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import invitaz.core.converter.dozer.DozerConverter;
import invitaz.core.service.BaseService;
import invitaz.dao.CountryDao;
import invitaz.dto.CountryDTO;
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
	
	
	public CountryDTO getCountry(Long id)
	{
		Country country=countryDao.getEntity(id);
		
		CountryDTO countryDTO=new CountryDTO();
		countryDTO.setId(country.getId());
		countryDTO.setName(country.getName());
		
		return countryDTO;
	}
	
	
	public List<CountryDTO> getCountryList()
	{
		List<CountryDTO> countryDTOs=new ArrayList<CountryDTO>();
		
		DozerConverter<Country, CountryDTO> converter=new DozerConverter<Country, CountryDTO>(Country.class, CountryDTO.class, null);
		
		countryDTOs=converter.mapListEntityToDTO(countryDao.getEntityList());
	
		return countryDTOs;
		
		
	}


}
