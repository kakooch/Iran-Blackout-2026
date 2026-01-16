package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class GetWalletTransactionMessageInput {
    public String access_transfer;
    public String transfer_id;

    public GetWalletTransactionMessageInput(String str, String str2) {
        this.transfer_id = str;
        this.access_transfer = str2;
    }
}
