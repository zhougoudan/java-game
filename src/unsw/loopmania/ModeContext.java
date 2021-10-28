package unsw.loopmania;
public class ModeContext {
    private ModeReq ModeReq;
    public ModeContext(ModeReq ModeReq){
        this.ModeReq = ModeReq;
    }
    public Mode executeMode (String mode) {
        return ModeReq.setMode(mode);
    }
}