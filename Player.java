import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private Scanner input = new Scanner(System.in);
    private int damage;
    private int originalHealth;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;


    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void selectChar(){
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        GameChar[] charList ={new Samurai(),new Archer(),new Knight()};

        System.out.println("------------------------------------------------");
        for (GameChar  gameChar : charList){
            System.out.println("ID : " + gameChar.getId() + " - " +
                    "Karakter: " + gameChar.getName() +
                    "\t\t\t\t\tHasar : " + gameChar.getDamage() +
                    "\t Sağlık : " + gameChar.getHealth() +
                    "\t Para : " + gameChar.getMoney());
        }
        System.out.println("------------------------------------------------");
        System.out.println("Lütfen bir karakter ID'sini seçiniz : ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }
       /* System.out.println(" Karakter : " + this.getCharName() +
              " Hasar : " + this.getDamage() +
                " Sağlık : " + this.getHealth() +
                " Para : " + this.getMoney() );*/
    }

    public void initPlayer(GameChar gameChar){
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setOriginalHealth(gameChar.getHealth());
    }
    public void prinyInfo(){
        System.out.println(" Silahınız: " + this.getInventory().getWeapon().getName()
                + " --   Zırhınız : " + this.getInventory().getArmor().getName()
                + " --  Bloklama Değeriniz : " + this.getInventory().getArmor().getBlock()
                + " --   Hasarınız: " + this.getTotalDamage()
        + " --   Sağlığınız: " + this.getHealth()
        + " --   Paranız: " + this.getMoney());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();

    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
