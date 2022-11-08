import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println();
        System.out.println("Macera Oyununa Hoşgeldiniz!!");
        System.out.println(" ");
        System.out.print("Lütfen bir isim giriniz : ");
        System.out.println(" ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu karanlık sisli adaya hoşgeldin!!");
        System.out.println(" ");
        System.out.println("Neler yapacağımızın farkında mısın??");
        System.out.println(player.getName() + ", Lütfen oyuna başlamak için karakter seç !");
        player.selectChar();

        while (true){
            System.out.println(" ");
            player.prinyInfo();
            System.out.println();
            System.out.println("#############################################");
            System.out.println();
            Location location =null;
            System.out.println("Bölgeler");
            System.out.println("1- Güvenli ev---> Burası sizin için güvenlidir, düşman yok");
            System.out.println("2- Mağaza---> Buradan mühimmat alabilirsiniz");
            System.out.println("3 - Mağara---> <Ödül : Yemek> Mağaraya git fakat dikkatli ol :)");
            System.out.println("4 - Orman ---> <Ödül : Odun> Ormana git fakat dikkatli ol :)");
            System.out.println("5 - Nehir ---> <Ödül : Su> Nehire git fakat dikkatli ol :)");
            System.out.println("0- Çıkış Yap--> Oyunu Sonlandır.");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selectLoc = input.nextInt();

            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz ");
            }
            if (location == null){
                System.out.println("Oyundan çıkmak için çok acelecisin!!!");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!!!!!");
                break;
            }
        }
    }
}
