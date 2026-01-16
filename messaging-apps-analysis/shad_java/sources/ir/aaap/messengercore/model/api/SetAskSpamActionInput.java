package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class SetAskSpamActionInput {
    public Action action;
    public String object_guid;

    public enum Action {
        Cancel,
        BlockUser,
        AddToContact,
        ReportAndLeave
    }

    public SetAskSpamActionInput(String str, Action action) {
        this.object_guid = str;
        this.action = action;
    }
}
