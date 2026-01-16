package ir.resaneh1.iptv.model.wallet;

import ir.resaneh1.iptv.model.Link;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class WalletTransactionObject {
    public String access_transfer;
    public ArrayList<CreditDetailObject> credit_details;
    public String currency_title;
    public String description;
    public Link link;
    public String receiver_wallet_id;
    public String sender_wallet_id;
    public long time;
    public String total_amount;
    public String track_id;
    public String transaction_id;
    public String transfer_id;
    public TransactionTypeEnum type;

    public enum TransactionTypeEnum {
        Charge,
        Send,
        Receive,
        CashOut
    }
}
