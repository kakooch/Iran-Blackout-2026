package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaActionOnRequestInput extends InstaInput {
    public ActionTypeEnum action;
    public String request_id;

    public enum ActionTypeEnum {
        Accept,
        Decline
    }

    public InstaActionOnRequestInput(String str) {
        this.request_id = str;
    }
}
