package unsw.loopmania;
import unsw.loopmania.Mode;

public interface ModeReq {


    
    public Mode setMode(String mode);


    // public ModeReq(String mode){
    //     this.mode = mode;
    //     this.healthPotion = false;
    //     this.armour = false;
    //     this.helmets = false;
    //     this.shields = false;
    //     if (mode.equals("survival")) {
    //         this.mode = mode;
    //         this.healthPotion = true;
    //         this.armour = false;
    //         this.helmets = false;
    //         this.shields = false;
    //     } else if (mode.equals("berserker")) {
    //         this.mode = mode;
    //         this.healthPotion = false;
    //         this.armour = true;
    //         this.helmets = true;
    //         this.shields = true;
    //     } else if (mode.equals("Standard")) {
    //         this.mode = mode;
    //         this.healthPotion = false;
    //         this.armour = false;
    //         this.helmets = false;
    //         this.shields = false;
    //     } 
    // }

}