package gabywald.projet.rpgcards;

import java.util.Arrays;
import java.util.List;

public enum EffectType {
	DAMAGE("damage", new String[]{ "damage", "duration" } ), 
	MODIFIER("damage_modifier", new String[]{ "add", "factor" });

	private String name;
	private List<String> parameters;
	
	EffectType(String name, String... params) {
		this.name = name;
		this.parameters = Arrays.asList(params);
	}

	public String getName() {
		return this.name;
	}

	public List<String> getParameters() {
		return this.parameters;
	}
}
