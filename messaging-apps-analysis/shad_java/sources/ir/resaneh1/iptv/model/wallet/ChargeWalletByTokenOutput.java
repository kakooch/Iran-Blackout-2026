package ir.resaneh1.iptv.model.wallet;

/* loaded from: classes3.dex */
public class ChargeWalletByTokenOutput {
    public ChargeWalletStatusEnum status;
    public WalletObject wallet;

    public enum ChargeWalletStatusEnum {
        OK,
        NotValidToken,
        UsedToken,
        ExpiredToken,
        ChargeError
    }
}
