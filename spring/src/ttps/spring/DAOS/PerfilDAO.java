package ttps.spring.DAOS;

import ttps.spring.model.*;

public interface PerfilDAO extends GenericDAO<Perfil> {

	boolean existePorNombre(String tipoPerfil);

}
