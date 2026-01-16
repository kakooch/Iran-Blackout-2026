package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class SetBlockUserInput {
    public BlockActionEnum action;
    public String user_guid;

    public enum BlockActionEnum {
        Block,
        Unblock
    }
}
