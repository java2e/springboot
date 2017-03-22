package invitaz.core.converter;

import java.util.Collection;

import invitaz.core.dto.BaseDTO;
import invitaz.core.entity.BaseEntity;

public abstract class DrogonConverter<BE extends BaseEntity,BD extends BaseDTO>
{

	protected String mappingId;	
	
	public DrogonConverter(String mappingId)
	{
		if("CustomConverter".equalsIgnoreCase(mappingId))
		{
			this.mappingId = getClass().getSimpleName();
		}
		else
		{
			this.mappingId = mappingId;
		}
	}
	
	public String getMappingId() 
	{		
		return mappingId;
	}
	
	public void setMappingId(String mappingId) 
	{
		this.mappingId = mappingId;
	}
	
	public abstract BE convertToEntity(BD bd);	
	public abstract BD convertToDTO(BE be);
	public abstract Collection<BD> mapListEntityToDTO(Collection<BE> entityList);
	public abstract Collection<BE> mapListDTOtoEntity(Collection<BD> dtoList);	
	

}
