package unsw.loopmania;
public class ModeSurvial implements ModeReq{


    @Override
    public Mode setMode(String mode) {
        Mode mode1 = new Mode(mode, true, false, false, false);
        return mode1;

    }
}

