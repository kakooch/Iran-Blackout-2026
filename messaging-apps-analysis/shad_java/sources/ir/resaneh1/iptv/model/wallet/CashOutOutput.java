package ir.resaneh1.iptv.model.wallet;

/* loaded from: classes3.dex */
public class CashOutOutput {
    public CashOutStatusEnum status;
    public WalletObject wallet;
    public WalletTransactionObject wallet_transaction;

    public enum CashOutStatusEnum {
        OK,
        TooMuchAmount,
        cashOutError,
        DupLocalID
    }
}
