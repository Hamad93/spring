package hd.udb.formation.service;

import org.springframework.data.repository.CrudRepository;

import hd.udb.formation.model.Enseignant;


public interface IEnseignant extends CrudRepository<Enseignant, Integer> {

	public Enseignant findByTel(String tel);
}
