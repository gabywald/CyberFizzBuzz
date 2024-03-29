package gabywald.projet.rpgcards;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gabriel Chandesris (2021)
 */
public class Card {
	private String id;
	private int mana;
	private List<Effect> effects;
	
	public Card(String id, int mana) {
		this.id = id;
		this.mana = mana;
		this.effects = new ArrayList<Effect>();
	}
	
	public Card(String id, int mana, List<Effect> effects) {
		this.id = id;
		this.mana = mana;
		this.effects = effects;
	}
	
	public String getID() {
		return this.id;
	}
	
	public int getMana() {
		return this.mana;
	}
	
	public void addEffect(Effect effect) {
		this.effects.add(effect);
	}

	public List<Effect> getEffects() {
		return this.effects;
	}
	
	@Override
	public String toString() {
		StringBuilder sbToReturn = new StringBuilder();
		sbToReturn.append(this.id).append("::").append(this.mana)
			.append(" (").append(this.effects.size()).append(")").append("\n");
		this.effects.stream().forEach( e -> {
			sbToReturn.append("\t").append( e.toString() ).append("\n");
		});
		return sbToReturn.toString();
	}

}
