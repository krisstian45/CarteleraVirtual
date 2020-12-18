package ttps.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAOS.TagDAO;
import ttps.spring.model.Tag;

@Service
public class TagService {
	
	@Autowired
	TagDAO tag;

	public List<Tag> findAllTags() {
		return tag.listar();

	}

	public Tag findById(long id) {
		// TODO Auto-generated method stub
		return tag.encontrarPorId(id);
	}

	public boolean isTagExist(Tag tag2) {
		// TODO Auto-generated method stub
		return tag.existePorNombre(tag2.getNombreTag());
	}

	public void saveTag(Tag tag2) {
		// TODO Auto-generated method stub
		tag.persistir(tag2);
		
	}

	public void updateTag(Tag currentTag) {
		// TODO Auto-generated method stub
		tag.actualizar(currentTag);
	}

}
