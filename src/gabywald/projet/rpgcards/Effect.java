package gabywald.projet.rpgcards;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gabriel Chandesris (2021)
 */
public class Effect {
	
	private EffectType type;
	
	private List<Integer> parameters = new ArrayList<Integer>();
	
	public Effect(EffectType type) {
		this.type = type;
	}
	
	public boolean isDamage() {
		return this.type.equals(EffectType.DAMAGE);
	}

	public boolean isModifier() {
		return this.type.equals(EffectType.MODIFIER);
	}
	
	public void addParameter(int parameter) {
		this.parameters.add(parameter);
	}
	
	public void addParameter(String parameter) {
		this.parameters.add(Integer.parseInt(parameter));
	}
	
	public boolean isValid() {
		return (this.type.getParameters().size() == this.parameters.size());
	}
	
	public int getDamage() {
		return (this.isDamage() ? this.parameters.get(0) : 0);
	}
	
	public int getDuration() {
		return (this.isDamage() ? this.parameters.get(1) : 1);
	}
	
	public int getAdd() {
		return (this.isModifier() ? this.parameters.get(0) : 0);
	}
	
	public int getFactor() {
		return (this.isModifier() ? this.parameters.get(1) : 1);
	}

}
