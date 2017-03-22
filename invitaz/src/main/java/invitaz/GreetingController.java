package invitaz;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import invitaz.service.CountryService;

@RestController
public class GreetingController {

	
	private static final String template="Hello, %s!";
	private final AtomicLong counter=new AtomicLong();
	
	@Autowired
	private CountryService countryService;
	
	
	public Greeting greeting(@RequestParam(value="name",defaultValue="World")String name)
	{
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}

	//@RequestMapping(path="/country")
    public String getCountry(@RequestParam(value="id",defaultValue="1")Long id)
	{
		return countryService.getCountryName(id);
	}
	
	public GreetingController() {
		// TODO Auto-generated constructor stub
	}

}
