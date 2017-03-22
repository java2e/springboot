package invitaz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import invitaz.core.rest.ResponseItemMessage;
import invitaz.core.rest.ResponseMessage;
import invitaz.core.rest.Status;
import invitaz.dto.CountryDTO;
import invitaz.service.CountryService;

/**
 * 
 * @author mdemircioglu
 *
 */

@RestController
@RequestMapping(value = "/rest/country")
public class CountryRest {

	@Autowired
	private CountryService countryService;

	
	@RequestMapping(path="/getCountryName",method=RequestMethod.GET)
	public CountryDTO countryName(@RequestParam(value="id",defaultValue="1")Long id)
	{
		return countryService.getCountry(id);
	}
	
	@RequestMapping(path="/getCountryList",method=RequestMethod.GET)
	public List<CountryDTO> getCountryList()
	{
		return countryService.getCountryList();
	}
	
	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, produces = { "application/json", "application/xml" }, consumes = {
		    "application/json", "application/xml" })
	public  ResponseEntity<ResponseItemMessage<CountryDTO>>  add(@RequestBody CountryDTO countryDTO)
	{
		
	 return new ResponseEntity<ResponseItemMessage<CountryDTO>>(ResponseMessage.create(countryDTO, Status.SUCCESS),	HttpStatus.OK);
		
	}
	
	
	

}
