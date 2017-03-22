package invitaz.core.converter.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

/**
 * 
 * @author mdemircioglu
 *
 */

public class DozerMapperHolder 
{
	private static final DozerMapperHolder INSTANCE = new DozerMapperHolder();
	private static DozerBeanMapper mapper = new DozerBeanMapper();
	  
    private DozerMapperHolder()
    {}

    public static DozerMapperHolder getInstance()
    {
        return INSTANCE;
    }
    
    public DozerBeanMapper getMapper()
    {    	
    	return mapper;
    }
    
    public synchronized boolean insertMapping(BeanMappingBuilder mappingBuilder)
    {
    	mapper.addMapping(mappingBuilder);
    	return true;
    }
}