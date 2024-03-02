import java.util.*;

class Enemy {
    int HP, damage;
    boolean isAlive;
    Enemy (int health, int d){
    HP = health;
    damage = d;
    isAlive = true;
    }

    void takeDamage(int amount) {
        HP -= amount;
        if (HP <= 0) isAlive = false;
    }
}

class Hero {
    int HP, damage;
    boolean isAlive;
    Hero (int health, int d){
        HP = health;
        damage = d;
        isAlive = true;
    }

    void takeDamage(int amount) {
        HP -= amount;
        if (HP <= 0) isAlive = false;
    }
}

public class Testgame {

    static int numEnemies(Enemy[] enemies){

        int sum = 0;
        for( int i = 0; i < enemies.length; i ++){
            if(enemies[i].isAlive) sum++;
        }
        return sum;
    }

    static void printArray(Enemy[] enemies){
        for (int i = 0; i < enemies.length; i++){
            System.out.print("|"+enemies[i].HP);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int numEnemies;
        int enemyDamage, EnemyHP;
        int heroDamage, heroHP;
        int numEnemiesLeft;

        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the number of enemies: ");
            numEnemies = sc.nextInt();
        System.out.println("Enter the enemy damage: ");
            enemyDamage = sc.nextInt();
        System.out.println("Enter the hero's starting HP: ");
            heroHP = sc.nextInt();
        System.out.println("Enter the hero's damage: ");
            heroDamage = sc.nextInt();

        Enemy[] enemies = new Enemy[numEnemies];


        for (int i = 0; i < enemies.length; i++){
            enemies[i] = new Enemy(10 +(i*2), enemyDamage);
        }

        Hero hero = new Hero(heroHP, heroDamage);

        int roundCount = 1;
        do{

            for(int i = 0; i < enemies.length; i++){
                if(enemies[i].isAlive){
                    enemies[i].takeDamage(hero.damage);
                    hero.takeDamage(enemies[i].damage);
                }
            }
            System.out.println("==== After round " + roundCount + "====");
            numEnemiesLeft = numEnemies(enemies);
            System.out.println("Num enemies left: " + numEnemiesLeft);
            printArray(enemies);
            System.out.println("Hero HP: " + hero.HP);
            roundCount++;

        } while ((numEnemiesLeft > 0) && (hero.isAlive));
        if (hero.isAlive){
            System.out.println("Hero wins!");
        }
        else{
            System.out.println("Enemies win!");
        }
    }


}

