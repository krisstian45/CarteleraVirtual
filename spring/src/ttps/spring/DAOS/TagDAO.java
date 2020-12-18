package ttps.spring.DAOS;

import ttps.spring.model.*;

public interface TagDAO extends GenericDAO<Tag> {

	boolean existePorNombre(String nombreTag);

}
