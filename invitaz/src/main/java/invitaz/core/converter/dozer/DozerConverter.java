package invitaz.core.converter.dozer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import invitaz.core.converter.DrogonConverter;
import invitaz.core.dto.BaseDTO;
import invitaz.core.entity.BaseEntity;

/**
 * 
 * @author mdemircioglu
 *
 *Convert from Data Transfer Object to Base Entity or BE to BD
 *
 * @param <BE>
 * @param <BD>
 */

public class DozerConverter<BE extends BaseEntity, BD extends BaseDTO> extends DrogonConverter<BE,BD>
{
	private DozerMapperHolder dozerMapperHolder = DozerMapperHolder.getInstance();
	private Class<?> beType,bdType;

	public DozerConverter(Class<?> entity,Class<?> baseDTO, BeanMappingBuilder mappingBuilder)
	{
		super(entity.getSimpleName().toUpperCase() + "_" + baseDTO.getSimpleName().toUpperCase());
		beType = entity;
		bdType = baseDTO;
		if(mappingBuilder == null)
		{
			BeanMappingBuilder mappingBuilderIn = new BeanMappingBuilder() 
			{
			    @SuppressWarnings("unused")
				@Override
			    protected void configure() 
			    {
			    	String mappingName = beType.getSimpleName().toUpperCase()+"_"+bdType.getSimpleName().toUpperCase();
			        //String dateFormat = "dd/MM/yyyy HH:mm:ss";
			        TypeMappingBuilder mapping = mapping(beType, bdType,
			        								TypeMappingOptions.mapNull(false),
			        								TypeMappingOptions.wildcard(true),
			        								TypeMappingOptions.mapId(mappingName)
			        								/*,
						        					TypeMappingOptions.dateFormat(dateFormat)*/);
													//if contains any dto
													//mapping.fields("dateString", "dateObject");								     
			    }
			};
			dozerMapperHolder.insertMapping(mappingBuilderIn);
		}
		else
		{
			dozerMapperHolder.insertMapping(mappingBuilder);
		}
	}
	
	/**
	 * Maps from DTO to entity
	 * @param bd object to be converted from
	 * @param mappingId which dozer mapping will be used (application scoped) null to do a default mapping eg. BeanNameDTO to BeanName 
	 * @return entity of type BE
	 */
	public BE convertToEntity(BaseDTO bd)
	{
		BE entity = newEntity();
		dozerMapperHolder.getMapper().map(bd, entity, mappingId);		
		return entity;
	}
	
	/**
	 * Maps from entity to DTO
	 * @param be Base entity to be converted from
	 * @param mappingId which dozer mapping will be used (application scoped) null to do a default mapping eg. BeanName to BeanNameDTO
	 * @return converted object that extends BaseDTO
	 */
	public BD convertToDTO(BaseEntity be)
	{
		BD baseDTO = newDTO();
		dozerMapperHolder.getMapper().map(be, baseDTO, mappingId);		
		return baseDTO;
	}
	
	/**
	 * Maps entity list to DTO list
	 * @param entityList consisting of objects of BaseEntity type
	 * @param mappingId which dozer mapping will be used (application scoped) null to do a default mapping eg. BeanName to BeanNameDTO
	 * @return list of items of BD type
	 */
	public List<BD> mapListEntityToDTO(Collection<BE> entityList)
	{
		List<BD> toReturn = new ArrayList();
		for(BE be:entityList)
		{		
			BD bd = newDTO();
			dozerMapperHolder.getMapper().map(be, bd, mappingId);	
			toReturn.add(bd);
		}
		return toReturn;
	}
	
	/**
	 * Maps DTO list to entity list
	 * @param dtoList list to be converted from
	 * @param mappingId which dozer mapping will be used (application scoped) null to do a default mapping eg. BeanNameDTO to BeanName
	 * @return list of items of BE type
	 */
	public List<BE> mapListDTOtoEntity(Collection<BD> dtoList)
	{
		List<BE> toReturn = new ArrayList();
		for(BD bd:dtoList)
		{		
			BE be = newEntity();
			dozerMapperHolder.getMapper().map(bd, be, mappingId);			
			toReturn.add(be);
		}
		return toReturn;
	}
	
	@SuppressWarnings("unchecked")
	private BD newDTO()
	{		
		BD toReturn = null;
		try 
		{
			toReturn = (BD)Class.forName(bdType.getName()).newInstance();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			//System.out.println("Error finding/assigning/initializing to a proper DTO instance" + bdType.getName());
		}
		return toReturn;
	}
	
	@SuppressWarnings("unchecked")
	private BE newEntity()
	{
		BE toReturn = null;
		try 
		{
			toReturn = (BE)Class.forName(beType.getName()).newInstance();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			//System.out.println("Error finding/assigning/initializing to a proper DTO instance" + bdType.getName());
		}
		return toReturn;
	}
	
	/**
	 * Inserts external mapping builder to the mapper holder
	 * @param mappingBuilder
	 * @return
	 */
	public boolean insertMapping(BeanMappingBuilder mappingBuilder)
	{
		dozerMapperHolder.insertMapping(mappingBuilder);		
		return true;
	}
}
