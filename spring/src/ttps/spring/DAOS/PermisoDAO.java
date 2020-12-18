package ttps.spring.DAOS;

import ttps.spring.model.*;

public interface PermisoDAO extends GenericDAO<Permiso> {

	boolean existePorNombre(String tipoPermiso);

}
