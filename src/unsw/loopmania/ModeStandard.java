package unsw.loopmania;
public class ModeStandard implements ModeReq{

    @Override
    public Mode setMode(String mode) {
        Mode mode1 = new Mode(mode, false, false, false, false);
        return mode1;

    }
}
