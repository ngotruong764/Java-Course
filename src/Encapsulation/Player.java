package Encapsulation;

public class Player {
    private String fullName;
    private int healthPercentage;
    private String weapon;

    public Player(String fullName, int health, String weapon) {
        this.fullName = fullName;
        if(health <= 0){
            this.healthPercentage = -1;
        } else if (health > 100) {
            this.healthPercentage = 100;
        } else{
            this.healthPercentage = health;
        }
        this.healthPercentage = health;
        this.weapon = weapon;
    }

    public Player(String fullName) {
        this(fullName, 100, "Sword");
    }

    public void loseHealth(int damage){
        healthPercentage = healthPercentage - damage;
        if(healthPercentage <= 0){
            System.out.println("Player knocked out of game");
        }
    }

    public int healthRemaining(){
        return healthPercentage;
    }

    public void restoreHealth(int extraHealth){
        healthPercentage = healthPercentage + extraHealth;
        if(healthPercentage > 100 ){
            System.out.println("Player restore to 100%");
        }
    }
}
