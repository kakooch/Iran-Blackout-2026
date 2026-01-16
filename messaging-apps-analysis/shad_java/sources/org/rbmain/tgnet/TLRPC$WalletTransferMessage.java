package org.rbmain.tgnet;

import ir.aaap.messengercore.model.WalletTransferMessageObject;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$WalletTransferMessage {
    public String amount;
    public ArrayList<TLRPC$KeyboardButton> buttons;
    public String currencyTitle;
    public String description;
    public TLRPC$User receiverUser;
    public TLRPC$User senderUser;
    public WalletTransferMessageObject.Status status;
    public String trackId;
    public long transaction_time;
}
