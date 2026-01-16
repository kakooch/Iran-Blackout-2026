package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class VerifyDeleteAccountInput {
    public String code;
    public String hash;

    public VerifyDeleteAccountInput(String str, String str2) {
        this.code = str;
        this.hash = str2;
    }
}
