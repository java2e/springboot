package invitaz.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import invitaz.core.entity.BaseEntity;

@Component
@SuppressWarnings(value = { "rawtypes", "unchecked", "serial" })
public class BaseDaoImpl<E extends BaseEntity> implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LogManager.getLogger(BaseDaoImpl.class);

	private String logIdHeader = "  id: [";
	private Class beType;

	@PersistenceContext(unitName = "PERSISTENCE_JPA")
	private transient EntityManager entityManager;

	/**
	 * Getter for entityManager in case it is necessary to be directly accessed
	 * from specialized sub DAO classes.
	 * 
	 * @return {@link EntityManager}
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Setter for entity manager
	 * 
	 * @param entityManager
	 *            entity manager to be set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Retrieves entity by ID, Skips soft deleted entities
	 * 
	 * @param pk
	 *            primaryKey of the Entity
	 * @return {@link BaseEntity}
	 */
	public E getEntity(final Serializable pk) {
		beType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		LOGGER.info(beType.getSimpleName() + logIdHeader + pk + "]");
		E entity = (E) entityManager.find(beType, pk);
		if (entity != null && !entity.getIsDeleted()) {
			return entity;
		}
		return null;
	}
	
	  /**
     * Retrieves all entities without any criteria , Skips soft deleted entities
     * 
     * @return List of {@link BaseEntity}
     */
    public List<E> getEntityList()
    {
	beType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	LOGGER.info(beType.getSimpleName());
	String query = "SELECT BE FROM " + beType.getSimpleName() + " BE WHERE BE.isDeleted is false";
	return entityManager.createQuery(query).getResultList();
    }


}
