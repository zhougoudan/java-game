package unsw.loopmania;


public class Mode {
    public boolean healthPotion = false;
    public boolean armour = false;
    public boolean helmets = false;
    public boolean shields = false;
    public String mode;
    public Mode(String mode, boolean healthPotion, boolean armour, boolean helmets, boolean shields) {
        this.mode = mode;
        this.healthPotion = true;
        this.armour = false;
        this.helmets = false;
        this.shields = false;

    }
    public Mode setMode(String mode2) {
        return null;
    }
    
}
