package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class JoinChannelActionInput {
    public Action action;
    public String channel_guid;

    public enum Action {
        Join,
        Leave
    }
}
