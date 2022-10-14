package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Event;
import fr.solutec.entities.Lieu;

public interface LieuRepository extends CrudRepository<Lieu, Long> {

}
