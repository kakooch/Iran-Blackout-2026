package ir.resaneh1.iptv.model.wallet;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class WalletObject {
    public boolean allow_cash_out;
    public boolean allow_charge;
    public boolean allow_receive;
    public boolean allow_send;
    public String currency_title;
    public long wallet_amount;
    public String wallet_id;
    public ArrayList<WalletItemObject> wallet_items;
}
