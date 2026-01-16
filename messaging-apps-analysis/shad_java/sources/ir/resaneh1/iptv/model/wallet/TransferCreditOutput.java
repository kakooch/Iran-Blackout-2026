package ir.resaneh1.iptv.model.wallet;

/* loaded from: classes3.dex */
public class TransferCreditOutput {
    public TransferCreditStatusEnum status;
    public WalletObject wallet;
    public WalletTransactionObject wallet_transaction;

    public enum TransferCreditStatusEnum {
        OK,
        NotSufficientAmount,
        TransferError,
        DupLocalID
    }
}
