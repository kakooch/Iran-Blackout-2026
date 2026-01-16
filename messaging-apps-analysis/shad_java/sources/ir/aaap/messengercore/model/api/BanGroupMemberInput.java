package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class BanGroupMemberInput {
    public ActionEnum action;
    public String group_guid;
    public String member_guid;

    public enum ActionEnum {
        Set,
        Unset
    }
}
