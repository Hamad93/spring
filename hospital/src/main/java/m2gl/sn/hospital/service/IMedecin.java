package m2gl.sn.hospital.service;

import m2gl.sn.hospital.model.Medecin;
import m2gl.sn.hospital.model.Specialite;

import org.springframework.data.repository.CrudRepository;

public interface IMedecin extends CrudRepository<Medecin, Integer> {

	public Medecin findByMatricule (String libelle);
}
