package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class ActionOnChatAdsInput {
    public Action action;
    public String chat_ads_id;

    public enum Action {
        Click,
        View,
        DontShow,
        Report
    }
}
