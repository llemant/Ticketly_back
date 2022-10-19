package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Amis;
import fr.solutec.repository.AmisRepository;

@RestController @CrossOrigin("*")
public class AmisRest {
	@Autowired
	private AmisRepository amisRepos;  
	
	@GetMapping("mes-amis/{monId}")
	public List<Amis> mesAmis(Long monId) {
		return amisRepos.getMesAmis(monId);
	}
	
}
