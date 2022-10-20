package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.DemandeAmis;
import fr.solutec.entities.User;


  public interface DemandeAmisRepository extends CrudRepository<DemandeAmis,
  Long> { public List<DemandeAmis> findByDemandeur(User demandeur); public
  List<DemandeAmis> findByReceveur(User receveur);
  
  @Query(value =
  "SELECT a FROM DemandeAmis a WHERE a.receveur.id = ?1 OR a.demandeur.id = ?1 AND a.acceptation = true"
  ) public List<DemandeAmis> getMesAmis(Long id); }
 