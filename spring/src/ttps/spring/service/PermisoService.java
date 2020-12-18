package ttps.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAOS.PermisoDAO;
import ttps.spring.model.Permiso;

@Service
public class PermisoService {
	@Autowired
	PermisoDAO permiso;
	
	public void updatePermiso(Permiso currentPermiso) {
		// TODO Auto-generated method stub
		permiso.actualizar(currentPermiso);
		
	}

	public Permiso findById(long id) {
		// TODO Auto-generated method stub
		return permiso.encontrarPorId(id);
	}

	public boolean isPermisoExist(Permiso permiso2) {
		// TODO Auto-generated method stub
		return permiso.existePorNombre(permiso2.getTipoPermiso());
	}

	public void savePermiso(Permiso permiso2) {
		// TODO Auto-generated method stub
		permiso.persistir(permiso2);
		
	}

	public List<Permiso> findAllPermisos() {
		// TODO Auto-generated method stub
		return permiso.listar();
	}

}
