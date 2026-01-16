package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaSetBlockProfileInput extends InstaInput {
    public BlockActionEnum action;
    public String blocked_id;

    public enum BlockActionEnum {
        Block,
        Unblock
    }

    public InstaSetBlockProfileInput(String str) {
        this.blocked_id = str;
    }
}
