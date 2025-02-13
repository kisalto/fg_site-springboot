package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Fighter;
import app.repository.FighterRepository;

@Service
public class FighterService {

	@Autowired
	private FighterRepository fighterRepository;
	
	public String save (Fighter fighter) {
		this.fighterRepository.save(fighter);
		return "Personagem Cadastrado";
	}
	
	public String update (Fighter fighter, long id) {
		fighter.setId(id);
		this.fighterRepository.save(fighter);
		return "Personagem Atualizado";
	}
	
	public Fighter findById (long id) {
		
		Optional<Fighter> optional = this.fighterRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
		
	}
	
	public List<Fighter> findAll () {
		
		return this.fighterRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.fighterRepository.deleteById(id);
		return "Personagem Deletado";
	}
	public Fighter findByNome(String nome){
		return this.fighterRepository.findByNome(nome);
	}
	public List<Fighter> findByGameNome(String Gamenome){
		return this.fighterRepository.findByGameNomeContainsOrderByNomeAsc(Gamenome);
	}
	
}
