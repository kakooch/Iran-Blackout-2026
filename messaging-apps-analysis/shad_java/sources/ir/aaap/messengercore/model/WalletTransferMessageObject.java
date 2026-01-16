package ir.aaap.messengercore.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class WalletTransferMessageObject {
    public String amount;
    public ArrayList<KeyboardButton> buttons;
    public String currency_title;
    public String description;
    public ChatAbsObject receiver_abs_object;
    public ChatAbsObject sender_abs_object;
    public Status status;
    public String track_id;
    public long transaction_time;

    public enum Status {
        Paid,
        Reversed
    }
}
