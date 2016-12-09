import java.util.Random;

public class Edible extends Item{
	// creates an item that can be consumed
	public static final String[] ENAMES = {"bread", "cookie", "potion", "sludge", "soda",
			"slushie", "spam", "power bar", "hair ball", "drink", "cake", "pie", "candy",
			"bread", "sauce"};
	
	public Edible(){
		Random rand = new Random();
		name = ENAMES[rand.nextInt(ENAMES.length)];
		name = applyAdjectives();
	}
	
	// looks at an edible object
	@Override
	public String lookAt(){
		return "It looks like a " + name + ". It looks like you can eat it";
	}
	
	//eats an edible object, and calls mixDirections on player
	@Override
	public String Use(Player player, Enemy e){
		//removes the item from the player's inventory
		player.remove(this);
		//determines the effect of the edible, enhancing/diminishing senses
		Random rand = new Random();
		int change = rand.nextInt(7) - 3;
		
		//applys affect and corrects noise to remain between 0-3
		e.noise += change;
		if(e.noise > 3){
			e.noise = 3;
		} else if(e.noise < 0){
			e.noise = 0;
		}
		
		//determines message to return
		String effect = "";
		if(change < 0){
			effect = "feel like you cant hear as well.";
		} else if(change == 0){
			effect = "nothing happens.";
		} else {
			effect = "you can feel your senses hightening.";
		}
		// returns message	
		//System.out.println(e.noise);
		return "You eat the " + name + " and " + effect;
		
	}
}
