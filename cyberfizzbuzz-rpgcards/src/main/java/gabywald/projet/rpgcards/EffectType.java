package gabywald.projet.rpgcards;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Gabriel Chandesris (2021)
 */
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
	
	public static EffectType getType(String name) {
		for (EffectType type : EffectType.values()) {
			if (name.equals(type.getName())) {
				return type;
			}
		}
		return null;
	}
}