package gabywald.projet.rpgcards;

/**
 * 
 * @author Gabriel Chandesris (2021)
 */
public class DurationCounter {
	private int duration;
	private int damage;
	
	DurationCounter(int duration, int damage) {
		this.duration = duration;
		this.damage = damage;
	}

	public int getDuration() {
		return this.duration;
	}

	public int getDamage() {
		return this.damage;
	}
	
	public void durationLess() {
		this.duration--;
	}
	
	public boolean isDurationApply() {
		return (this.duration > 0);
	}

}
