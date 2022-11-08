public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }
    @Override
    public boolean onLocation(){
        boolean showMenu= true;
        while (showMenu){
        System.out.println("-------------Mağazaya Hoşgeldiniz !-----------------");
        System.out.println("1- Silahlar" );
        System.out.println("2- Zırhlar" );
        System.out.println("3- Çıkış Yap" );
        System.out.println("Seçiminiz : ");
        int selectCase = Location.input.nextInt();
        while(selectCase < 1 || selectCase >3 ) {
            System.out.println(" Geçersiz değer, tekrar giriniz : ");
            selectCase = Location.input.nextInt();
        }

        switch (selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("Tekrar Mağazamıza Bekleriz...");
                showMenu=false;
                break;
        }
    }
        return true;
    }
    //Armor kod kısmı---------------------
    public void printArmor(){
        System.out.println("---------Zırhlar--------");
        System.out.println(" ");
        for (Armor a: Armor.armors()) {
            System.out.println(a.getId() + " - " +
                    a.getName() +
                    " <Para : " + a.getPrice() +
                    " , Zırh : " + a.getBlock() + " > ");

        }
    }
    public void buyArmor(){
        System.out.println("Bir Zırh Seçiniz : ");

        int selectArmorID = input.nextInt();
        while (selectArmorID<1 || selectArmorID> Armor.armors().length){
            System.out.println("Geçersiz bir değer girdiniz, tekrar giriniz!! ");
            selectArmorID= input.nextInt();
        }
        if ((selectArmorID!=0)){
        Armor selectedArmor = Armor.getArmorObjbuyID(selectArmorID);
        if (selectedArmor!= null){
            if (selectedArmor.getPrice()> this.getPlayer().getMoney()){
                System.out.println("Yeterli paranız bulunmamaktadır!!");
            }else {
                System.out.println(selectedArmor.getName() + " zırhını satın aldınız. ");
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Kalan Bakiye : " + this.getPlayer().getMoney());
            }
        }
        }
    }
    //--------------------------------


    //Weapon kod kısmı--------------------------------
    public void printWeapon(){
        System.out.println("-------Silahlar--------");
        System.out.println();
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getName() + " < Para : " + w.getPrice() + " < Hasar : " + w.getDamage());
        }
        System.out.println("0 - Çıkış Yap ");
    }
    public void  buyWeapon(){
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID <0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Geçersiz değer girdiniz, tekrar giriniz :");
            selectWeaponID = input.nextInt();
    }
        if (selectWeaponID != 0) {
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

        if (selectedWeapon != null) {

            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println(" ");
                System.out.println("Yeterli paranız bulunmamaktadır !");

            }else {
                // Satın almanın gerçekleştiği alan
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız. ");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println(" ");
                System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                System.out.println("Önceki Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
            }
            }
        }
    }
}

